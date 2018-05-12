package io.angularattack.loweredexpectations.rankit.controllers;

import io.angularattack.loweredexpectations.rankit.api.MatchDto;
import io.angularattack.loweredexpectations.rankit.services.MatchMakingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/matchmaking")
public class MatchMakingController {

    @Autowired
    private MatchMakingService matchMakingService;

    @GetMapping("/{rankedGroupId}")
    public MatchDto getMatch(@PathVariable UUID rankedGroupId) {
        return matchMakingService.getMatch(rankedGroupId);
    }
}
