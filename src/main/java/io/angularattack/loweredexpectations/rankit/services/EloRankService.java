package io.angularattack.loweredexpectations.rankit.services;

import io.angularattack.loweredexpectations.rankit.api.EloOutcomeDto;
import io.angularattack.loweredexpectations.rankit.api.MatchResultEnum;
import org.springframework.stereotype.Service;

@Service
public class EloRankService {
    private static double ELO_SPECIFIER = 400;
    private static double WIN = 1;
    private static double DRAW = 0.5;
    private static double LOSS = 0;
    private static double K_FACTOR = 32; // Chess uses this.  This can modified to suit our needs.

    public EloOutcomeDto updateRanking(Integer initialScoreA, Integer initialScoreB, MatchResultEnum matchResult) {
        double transformedA = Math.pow(10, initialScoreA / ELO_SPECIFIER);
        double transformedB = Math.pow(10, initialScoreB / ELO_SPECIFIER);

        double expectedA = transformedA / (transformedA + transformedB);
        double expectedB = transformedB / (transformedA + transformedB);

        double winLossPercentageA = calculateItemAMultiplier(matchResult);
        double winLossPercentageB = calculateItemBMultiplier(matchResult);

        double updatedScoreA = initialScoreA + K_FACTOR * (winLossPercentageA - expectedA);
        double updatedScoreB = initialScoreB + K_FACTOR * (winLossPercentageB - expectedB);
        return new EloOutcomeDto()
                .setScoreA(Integer.valueOf((int) Math.round(updatedScoreA)))
                .setScoreB(Integer.valueOf((int) Math.round(updatedScoreB)));
    }

    private double calculateItemAMultiplier(MatchResultEnum matchResult) {
        if (matchResult == MatchResultEnum.WINNER_A) {
            return WIN;
        } else if (matchResult == MatchResultEnum.DRAW) {
            return DRAW;
        }
        return LOSS;
    }

    private double calculateItemBMultiplier(MatchResultEnum matchResult) {
        if (matchResult == MatchResultEnum.WINNER_B) {
            return WIN;
        } else if (matchResult == MatchResultEnum.DRAW) {
            return DRAW;
        }
        return LOSS;
    }
}
