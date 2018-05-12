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

    constructor(private rgService: RankedGroupService, private router: Router) {
    }

    ngOnInit() {
        this.rgService.findAll().subscribe(value => {
            this.rankedGroups = value;
            console.log("Saved group successful: " + JSON.stringify(this.rankedGroups));
        });
    }

    addGroup() {
        this.router.navigate(['/manage-ranked-group']);
    }
}