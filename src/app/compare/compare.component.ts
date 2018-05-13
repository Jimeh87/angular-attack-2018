import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {MatchMakerService} from "../services/match-maker.service";
import {Match} from "../models/match.model";
import {RankedGroupService} from "../services/ranked-group.service";
import {map} from "rxjs/operators";
import {forkJoin} from "rxjs/internal/observable/forkJoin";
import {MatchResult} from "../models/match-outcome.model";
import {RankService} from "../services/rank.service";
import {animate, state, style, transition, trigger} from "@angular/animations";

@Component({
    selector: 'app-compare',
    templateUrl: './compare.component.html',
    styleUrls: ['./compare.component.scss'],
    animations: [
        trigger('flyInOut', [
            state('in', style({transform: 'translateX(0)'})),
            transition('void => *', [
                style({transform: 'translateX(-100%)'}),
                animate(100)
            ]),
            transition('* => void', [
                animate(100, style({transform: 'translateX(100%)'}))
            ])
        ])
    ]
})
export class CompareComponent implements OnInit {

    rankedGroupId: string;
    groupName: string;
    match: Match;

    constructor(private route: ActivatedRoute,
                private router: Router,
                private matchMakerService: MatchMakerService,
                private rankedGroupService: RankedGroupService,
                private rankService: RankService) {
    }

    ngOnInit() {
        this.route.params
            .pipe(map(params => params['rankedGroupId']))
            .subscribe(rankedGroupId => {
                this.rankedGroupId = rankedGroupId;
                forkJoin(
                    this.rankedGroupService.get(rankedGroupId),
                    this.matchMakerService.get(rankedGroupId)
                ).subscribe(([rankedGroup, match]) => {
                    this.groupName = rankedGroup.name;
                    this.match = match;
                })
            });
    }

    matchAWon() {
        this.pushResultAndRestart(MatchResult.OptionA);
    }

    matchBWon() {
        this.pushResultAndRestart(MatchResult.OptionB);
    }

    noDecision() {
        this.pushResultAndRestart(MatchResult.Draw);
    }

    private pushResultAndRestart(matchResult: MatchResult) {
        this.rankService.saveMatchResult({
            optionAId: this.match.itemA.id,
            optionBId: this.match.itemB.id,
            result: matchResult
        }).subscribe(() => {
            this.match = null;
            this.matchMakerService.get(this.rankedGroupId).subscribe(match => this.match = match);
        });
    }
}
