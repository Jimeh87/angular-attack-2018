import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs/internal/Observable";
import {Match} from "../models/match.model";

@Injectable({
    providedIn: 'root'
})
export class MatchMakerService {

    constructor(private http: HttpClient) {
    }

    get(rankedGroupId: string): Observable<Match> {
        return this.http.get<Match>('/api/v1/matchmaking/' + rankedGroupId);
    }
}
