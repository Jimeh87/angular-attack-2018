package io.angularattack.loweredexpectations.rankit.controllers;

import io.angularattack.loweredexpectations.rankit.api.RankedGroupDto;
import io.angularattack.loweredexpectations.rankit.services.RankedGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/ranked-groups")
public class RankedGroupController {

    @Autowired
    private RankedGroupService rankedGroupService;

    @GetMapping
    public List<RankedGroupDto> findAll() {
        return rankedGroupService.findAll();
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
        rankedGroupDto.setId(id);
        return rankedGroupService.update(rankedGroupDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        rankedGroupService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }
}
