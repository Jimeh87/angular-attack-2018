import {Component, OnInit} from '@angular/core';
import {RankedGroupService} from "../services/ranked-group.service";
import {RankedGroup} from "../models/ranked-group.model";
import {Router} from "@angular/router";

@Component({
    selector: 'app-ranked-group',
    templateUrl: './ranked-group.component.html',
    styleUrls: ['./ranked-group.component.css']
})
export class RankedGroupComponent implements OnInit {

    rankedGroups: Array<RankedGroup> = [];
    displayedColumns = ['rank', 'name', 'image'];

    constructor(private rgService: RankedGroupService, private router: Router) {
    }

    ngOnInit() {
        this.rgService.findAll().subscribe((rankedGroups: RankedGroup[]) => {
            rankedGroups.forEach(g => g.rankedItems = g.rankedItems.sort((a, b) => b.score - a.score));
            this.rankedGroups = rankedGroups;
            console.log("Saved group successful: " + JSON.stringify(this.rankedGroups));
        });
    }

}
