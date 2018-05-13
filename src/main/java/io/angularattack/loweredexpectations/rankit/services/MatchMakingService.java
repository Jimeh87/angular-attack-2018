package io.angularattack.loweredexpectations.rankit.services;

import io.angularattack.loweredexpectations.rankit.api.MatchDto;
import io.angularattack.loweredexpectations.rankit.api.RankedGroupDto;
import io.angularattack.loweredexpectations.rankit.api.RankedItemDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class MatchMakingService {
    @Autowired
    private RankedGroupService rankedGroupService;

    public MatchDto getMatch(UUID rankedGroupId) {
        RankedGroupDto rankedGroup = rankedGroupService.get(rankedGroupId);
        List<RankedItemDto> items = rankedGroup.getRankedItems();
        return getMatchItems(items);
    }

    private MatchDto getMatchItems(List<RankedItemDto> items) {
        int curIndex = getRandomIndex(items.size());
        RankedItemDto itemA = items.get(curIndex);
        items.remove(curIndex);
        curIndex = getRandomIndex(items.size());
        RankedItemDto itemB = items.get(curIndex);
        return new MatchDto().setItemA(itemA).setItemB(itemB);
    }

    private int getRandomIndex(int listSize) {
        return (int)(Math.random() * (listSize));
    }

}
