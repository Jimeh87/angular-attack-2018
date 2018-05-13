package io.angularattack.loweredexpectations.rankit.services;

import io.angularattack.loweredexpectations.rankit.api.RankedGroupDto;
import io.angularattack.loweredexpectations.rankit.api.RankedItemDto;
import io.angularattack.loweredexpectations.rankit.entities.RankedGroup;
import io.angularattack.loweredexpectations.rankit.entities.RankedItem;
import io.angularattack.loweredexpectations.rankit.repositories.RankedGroupRepository;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class RankedGroupService {

    public static final Integer START_SCORE = 1500;

    @Autowired
    private RankedGroupRepository rankedGroupRepository;

    public List<RankedGroupDto> findAll() {
        return rankedGroupRepository.findAll()
                .stream()
                .map(this::toRankedGroupDto)
                .collect(Collectors.toList());
    }

    public RankedGroupDto getByShortCode(String shortCode) {
        return Optional.of(rankedGroupRepository.findByShortCode(shortCode))
                .map(this::toRankedGroupDto)
                .get();
    }

    public RankedGroupDto get(UUID id) {
        return Optional.of(rankedGroupRepository.getOne(id))
                .map(this::toRankedGroupDto)
                .get();
    }

    public RankedGroupDto create(RankedGroupDto rankedGroupDto) {
        return Optional.of(rankedGroupDto)
                .map(this::toRankedGroup)
                .map(this::applyDefaults)
                .map(rankedGroupRepository::save)
                .map(this::toRankedGroupDto)
                .get();
    }

    private RankedGroup applyDefaults(RankedGroup rankedGroup) {
        rankedGroup
                .setShortCode(RandomStringUtils.random(8, "0123456789abcdefg"));
        rankedGroup.getRankedItems()
                .forEach(i -> i.setScore(START_SCORE));
        return rankedGroup;
    }

    public RankedGroupDto update(RankedGroupDto rankedGroupDto) {
        throw new RuntimeException("Not done yet... (maybe not needed)");
    }

    public void delete(UUID id) {
        throw new RuntimeException("Not done yet... (maybe not needed)");
    }

    private RankedGroupDto toRankedGroupDto(RankedGroup rankedGroup) {
        return new RankedGroupDto()
                .setId(rankedGroup.getId())
                .setName(rankedGroup.getName())
                .setShortCode(rankedGroup.getShortCode())
                .setRankedItems(rankedGroup.getRankedItems()
                        .stream()
                        .map(this::toRankedItemDto)
                        .collect(Collectors.toList()));
    }

    private RankedItemDto toRankedItemDto(RankedItem rankedItem) {
        return new RankedItemDto()
                .setId(rankedItem.getId())
                .setName(rankedItem.getName())
                .setScore(rankedItem.getScore());
    }

    private RankedGroup toRankedGroup(RankedGroupDto rankedGroupDto) {
        RankedGroup rankedGroup = new RankedGroup()
                .setId(rankedGroupDto.getId())
                .setName(rankedGroupDto.getName())
                .setShortCode(rankedGroupDto.getShortCode());
        rankedGroup.getRankedItems().addAll(rankedGroupDto.getRankedItems()
                .stream()
                .map(this::toRankedItem)
                .collect(Collectors.toList()));
        return rankedGroup;
    }

    private RankedItem toRankedItem(RankedItemDto rankedItemDto) {
        return new RankedItem()
                .setId(rankedItemDto.getId())
                .setName(rankedItemDto.getName())
                .setScore(rankedItemDto.getScore());
    }

}
