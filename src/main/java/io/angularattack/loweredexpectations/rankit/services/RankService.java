package io.angularattack.loweredexpectations.rankit.services;


import io.angularattack.loweredexpectations.rankit.api.EloOutcomeDto;
import io.angularattack.loweredexpectations.rankit.api.MatchOutcomeDto;
import io.angularattack.loweredexpectations.rankit.api.RankedItemDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RankService {

    @Autowired
    private EloRankService eloRankService;

    @Autowired
    private RankedItemService rankedItemService;

    public void rank(MatchOutcomeDto outcome) {
        RankedItemDto itemA = rankedItemService.get(outcome.getOptionAId());
        RankedItemDto itemB = rankedItemService.get(outcome.getOptionBId());
        EloOutcomeDto eloRankOutcome = eloRankService.updateRanking(
                itemA.getScore(),
                itemB.getScore(),
                outcome.getResult());
        itemA.setScore(eloRankOutcome.getScoreA());
        itemB.setScore(eloRankOutcome.getScoreB());
        itemA = rankedItemService.update(itemA);
        itemB = rankedItemService.update(itemB);
        System.out.println("Saved: " + itemA);
        System.out.println("Saved: " + itemB);
    }
}
