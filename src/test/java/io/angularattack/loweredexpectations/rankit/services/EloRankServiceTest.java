package io.angularattack.loweredexpectations.rankit.services;

import io.angularattack.loweredexpectations.rankit.api.EloOutcomeDto;
import io.angularattack.loweredexpectations.rankit.api.MatchResultEnum;
import io.angularattack.loweredexpectations.rankit.api.RankedItemDto;
import org.junit.Test;

import java.util.UUID;

import static org.junit.Assert.assertEquals;

public class EloRankServiceTest {

    private EloRankService eloRankService = new EloRankService();

    @Test
    public void testEloOutcomeItemAWon() {
        RankedItemDto itemA = new RankedItemDto().setId(UUID.randomUUID()).setScore(2400);
        RankedItemDto itemB = new RankedItemDto().setId(UUID.randomUUID()).setScore(2000);
        EloOutcomeDto outcome = eloRankService.updateRanking(
                itemA.getScore(),
                itemB.getScore(),
                MatchResultEnum.OptionA);

        assertEquals(new Integer(2403), outcome.getScoreA());
        assertEquals(new Integer(1997), outcome.getScoreB());
    }

    @Test
    public void testEloOutcomeItemBWon() {
        RankedItemDto itemA = new RankedItemDto().setId(UUID.randomUUID()).setScore(2400);
        RankedItemDto itemB = new RankedItemDto().setId(UUID.randomUUID()).setScore(2000);
        EloOutcomeDto outcome = eloRankService.updateRanking(
                itemA.getScore(),
                itemB.getScore(),
                MatchResultEnum.OptionB);

        assertEquals(new Integer(2371), outcome.getScoreA());
        assertEquals(new Integer(2029), outcome.getScoreB());
    }

    @Test
    public void testEloOutcomeItemDraw() {
        RankedItemDto itemA = new RankedItemDto().setId(UUID.randomUUID()).setScore(2400);
        RankedItemDto itemB = new RankedItemDto().setId(UUID.randomUUID()).setScore(2000);
        EloOutcomeDto outcome = eloRankService.updateRanking(
                itemA.getScore(),
                itemB.getScore(),
                MatchResultEnum.Draw);

        assertEquals(new Integer(2387), outcome.getScoreA());
        assertEquals(new Integer(2013), outcome.getScoreB());
    }
}
