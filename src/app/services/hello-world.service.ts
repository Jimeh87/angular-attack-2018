import {Injectable} from "@angular/core";
import {Observable} from "rxjs";
import {Hello} from "../models/hello.model";
import {HttpClient} from "@angular/common/http";

@Injectable()
export class HelloWorldService {

    constructor(private httpClient: HttpClient) {

    }

    public helloWorld(): Observable<Hello> {
        return this.httpClient.get<Hello>("/api/v1/hello-world");
    }
}