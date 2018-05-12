package io.angularattack.loweredexpectations.rankit.services;

import io.angularattack.loweredexpectations.rankit.api.EloOutcomeDto;
import io.angularattack.loweredexpectations.rankit.api.MatchResultEnum;
import io.angularattack.loweredexpectations.rankit.api.RankDto;
import org.junit.Test;

import java.util.UUID;

import static org.junit.Assert.assertEquals;

public class EloRankServiceTest {

    private EloRankService eloRankService = new EloRankService();

    @Test
    public void testEloOutcomeItemAWon() {
        RankDto itemA = new RankDto().setRankId(UUID.randomUUID()).setScore(2400);
        RankDto itemB = new RankDto().setRankId(UUID.randomUUID()).setScore(2000);
        EloOutcomeDto outcome = eloRankService.updateRanking(
                itemA.getScore(),
                itemB.getScore(),
                MatchResultEnum.WINNER_A);

        assertEquals(new Integer(2403), outcome.getScoreA());
        assertEquals(new Integer(1997), outcome.getScoreB());
    }

    @Test
    public void testEloOutcomeItemBWon() {
        RankDto itemA = new RankDto().setRankId(UUID.randomUUID()).setScore(2400);
        RankDto itemB = new RankDto().setRankId(UUID.randomUUID()).setScore(2000);
        EloOutcomeDto outcome = eloRankService.updateRanking(
                itemA.getScore(),
                itemB.getScore(),
                MatchResultEnum.WINNER_B);

        assertEquals(new Integer(2371), outcome.getScoreA());
        assertEquals(new Integer(2029), outcome.getScoreB());
    }

    @Test
    public void testEloOutcomeItemDraw() {
        RankDto itemA = new RankDto().setRankId(UUID.randomUUID()).setScore(2400);
        RankDto itemB = new RankDto().setRankId(UUID.randomUUID()).setScore(2000);
        EloOutcomeDto outcome = eloRankService.updateRanking(
                itemA.getScore(),
                itemB.getScore(),
                MatchResultEnum.DRAW);

        assertEquals(new Integer(2387), outcome.getScoreA());
        assertEquals(new Integer(2013), outcome.getScoreB());
    }
}
