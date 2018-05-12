package io.angularattack.loweredexpectations.rankit.services;

import io.angularattack.loweredexpectations.rankit.api.RankDto;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.UUID;

public class EloRankServiceTest {

    private EloRankService eloRankService = new EloRankService();

    @Test
    public void testUpdateRankingItemAWon() {
        RankDto itemA = new RankDto().setRankId(UUID.randomUUID()).setScore(2400);
        RankDto itemB = new RankDto().setRankId(UUID.randomUUID()).setScore(2000);
        eloRankService.updateRanking(itemA, itemB, itemB.getRankId());
    }
}
