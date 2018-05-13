import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {RankedGroup} from "../models/ranked-group.model";
import {Observable} from "rxjs/internal/Observable";

@Injectable({
    providedIn: 'root'
})
export class RankedGroupService {

    constructor(private http: HttpClient) {
    }

    save(rankedGroup: RankedGroup): Observable<RankedGroup> {
        return this.http.post<RankedGroup>('api/v1/ranked-groups', rankedGroup);
    }

    get(id: string): Observable<RankedGroup> {
        return this.http.get<RankedGroup>('api/v1/ranked-groups/' + id);
    }

    findAll(): Observable<RankedGroup[]> {
        return this.http.get<RankedGroup[]>('api/v1/ranked-groups');
    }

    findByShortId(id: string): Observable<RankedGroup> {
        return this.http.get<RankedGroup>('api/v1/ranked-groups/?shortCode=' + id);
    }
}
