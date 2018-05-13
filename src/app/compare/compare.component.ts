import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {MatchMakerService} from "../services/match-maker.service";
import {Match} from "../models/match.model";
import {RankedGroupService} from "../services/ranked-group.service";
import {map} from "rxjs/operators";
import {forkJoin} from "rxjs/internal/observable/forkJoin";

@Component({
    selector: 'app-compare',
    templateUrl: './compare.component.html',
    styleUrls: ['./compare.component.scss']
})
export class CompareComponent implements OnInit {

    rankedGroupId: string;
    groupName: string;
    match: Match;

    constructor(private route: ActivatedRoute,
                private matchMakerService: MatchMakerService,
                private rankedGroupService: RankedGroupService) {
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

}
