import {Injectable} from '@angular/core';
import {Observable} from "rxjs/internal/Observable";
import {HttpClient} from "@angular/common/http";
import {MatchOutcome} from "../models/match-outcome.model";

@Injectable({
    providedIn: 'root'
})
export class RankService {

    constructor(private http: HttpClient) {
    }

    saveMatchResult(matchOutcome: MatchOutcome): Observable<void> {
        return this.http.put<void>('api/v1/rank', matchOutcome);
    }
}
