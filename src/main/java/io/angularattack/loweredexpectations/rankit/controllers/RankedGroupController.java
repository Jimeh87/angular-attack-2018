package io.angularattack.loweredexpectations.rankit.controllers;

import io.angularattack.loweredexpectations.rankit.api.RankedGroupDto;
import io.angularattack.loweredexpectations.rankit.services.RankedGroupService;
import lombok.extern.slf4j.Slf4j;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/ranked-groups")
@Slf4j
public class RankedGroupController {

    @Autowired
    private RankedGroupService rankedGroupService;

    @GetMapping()
    public List<RankedGroupDto> findAll() {
        return rankedGroupService.findAll();
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
    	//TODO disallow create if they're specifying short code??
    	//TODO handle collision of randomized shortened id
    	rankedGroupDto.setShortCode(RandomStringUtils.random(8, "0123456789abcdefg") );
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
