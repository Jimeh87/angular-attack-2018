package io.angularattack.loweredexpectations.rankit.controllers;

import io.angularattack.loweredexpectations.rankit.api.MatchOutcomeDto;
import io.angularattack.loweredexpectations.rankit.services.RankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/rank")
public class RankController {

    @Autowired
    private RankService rankService;

    @PutMapping
    public void rank(@RequestBody MatchOutcomeDto matchOutcome) {
        rankService.rank(matchOutcome);
    }
}
