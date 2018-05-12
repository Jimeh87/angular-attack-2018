package io.angularattack.loweredexpectations.rankit.services;

import io.angularattack.loweredexpectations.rankit.api.RankDto;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class EloRankService {
    private static double ELO_SPECIFIER = 400;
    private static double WIN = 1;
    private static double DRAW = 0.5;
    private static double LOSS = 0;
    private static double CHESS_K_FACTOR = 32;

    public void updateRanking(RankDto itemA, RankDto itemB, UUID winner) {
        boolean itemAWon = itemA.getRankId() == winner;
        boolean itemBWon = itemB.getRankId() == winner;
        boolean draw = winner == null;
        double transformedA = Math.pow(10, itemA.getScore() / ELO_SPECIFIER);
        double transformedB = Math.pow(10, itemB.getScore() / ELO_SPECIFIER);
        System.out.println(transformedA);
        System.out.println(transformedB);

        double expectedA = transformedA / (transformedA + transformedB);
        double expectedB = transformedB / (transformedA + transformedB);
        System.out.println(expectedA);
        System.out.println(expectedB);
        double multiplierA = calculateItemMultiplier(itemAWon, draw);
        double multiplierB = calculateItemMultiplier(itemBWon, draw);
        System.out.println(multiplierA);
        System.out.println(multiplierB);

        double updatedScoreA = itemA.getScore() + CHESS_K_FACTOR * (multiplierA - expectedA);
        double updatedScoreB = itemB.getScore() + CHESS_K_FACTOR * (multiplierB - expectedB);
        System.out.println(updatedScoreA);
        System.out.println(updatedScoreB);
    }

    private double calculateItemMultiplier(boolean won, boolean draw) {
        return won ? WIN : (draw ? DRAW : LOSS);
    }
}
