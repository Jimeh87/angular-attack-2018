package io.angularattack.loweredexpectations.rankit.controllers;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageConfig;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import io.angularattack.loweredexpectations.rankit.api.RankedGroupDto;
import io.angularattack.loweredexpectations.rankit.services.RankedGroupService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/ranked-groups")
@Slf4j
public class RankedGroupController {

    private static final String GROUP_URL = "http://localhost:4200/thegrouplink/";
	@Autowired
    private RankedGroupService rankedGroupService;

    @GetMapping()
    public List<RankedGroupDto> findAll() {
        return rankedGroupService.findAll();
    }

	@GetMapping(value = "/{id}/qr", produces = MediaType.IMAGE_PNG_VALUE)
	public byte[] getQRCode(@PathVariable UUID id) throws WriterException, IOException {
		RankedGroupDto group = get(id);
		if(group == null) {
			//TODO return null....really???  prolly http code
			return null;
		}
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		BitMatrix matrix = new MultiFormatWriter().encode(GROUP_URL + group.getShortCode(), BarcodeFormat.QR_CODE, 400, 400);
		MatrixToImageWriter.writeToStream(matrix, MediaType.IMAGE_PNG.getSubtype(), baos, new MatrixToImageConfig());
		return baos.toByteArray();
	}

    @GetMapping(params= "shortCode")
    public RankedGroupDto get(@RequestParam(name="shortCode") String shortCode) {
    	return rankedGroupService.getByShortCode(shortCode);
    }

    @GetMapping("/{id}")
    public RankedGroupDto get(@PathVariable UUID id) {
        return rankedGroupService.get(id);
    }

    @PostMapping
    public RankedGroupDto create(@RequestBody RankedGroupDto rankedGroupDto) {
        return rankedGroupService.create(rankedGroupDto);
    }

    @PutMapping("/{id}")
    public RankedGroupDto update(@PathVariable UUID id, @RequestBody RankedGroupDto rankedGroupDto) {
        return rankedGroupService.update(rankedGroupDto.setId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        rankedGroupService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }
}
