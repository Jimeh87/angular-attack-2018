package io.angularattack.loweredexpectations.rankit.services;

import io.angularattack.loweredexpectations.rankit.api.RankedGroupDto;
import io.angularattack.loweredexpectations.rankit.api.RankedItemDto;
import io.angularattack.loweredexpectations.rankit.entities.RankedItem;
import io.angularattack.loweredexpectations.rankit.repositories.RankedItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class RankedItemService {
    @Autowired
    private RankedItemRepository rankedItemRepository;

    public RankedItemDto get(UUID id) {
        return Optional.of(rankedItemRepository.getOne(id))
                .map(this::toRankedItemDto)
                .get();
    }

    public RankedItemDto update(RankedItemDto dto) {
        RankedItem rankedItem = Optional.of(rankedItemRepository.getOne(dto.getId()))
                .orElseThrow(() ->  new IllegalStateException("No Bueno Capitan"));
        rankedItem.setScore(dto.getScore());
        return toRankedItemDto(rankedItemRepository.save(rankedItem));
    }

    private RankedItemDto toRankedItemDto(RankedItem rankedItem) {
        return new RankedItemDto()
                .setId(rankedItem.getId())
                .setName(rankedItem.getName())
                .setScore(rankedItem.getScore());
    }
}
