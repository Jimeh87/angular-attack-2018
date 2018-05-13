import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {map} from "rxjs/operators";
import {RankedGroupService} from "../services/ranked-group.service";

@Component({
    selector: 'app-easy-url',
    templateUrl: './easy-url.component.html',
    styleUrls: ['./easy-url.component.css']
})
export class EasyUrlComponent implements OnInit {

    constructor(private router: Router,
                private route: ActivatedRoute,
                private rankedGroupService: RankedGroupService) {
    }

    ngOnInit() {
        this.route.params
            .pipe(map(params => params['shortId']))
            .subscribe(shortId => {
                this.rankedGroupService.findByShortId(shortId).subscribe(group => this.router.navigate(['/compare', group.id]));
            });
    }

}
