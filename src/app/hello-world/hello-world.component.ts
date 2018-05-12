import {Component, OnDestroy, OnInit} from '@angular/core';
import {HelloWorldService} from "../services/hello-world.service";
import {Hello} from "../models/hello.model";
import {Subscription} from "rxjs/index";

@Component({
  selector: 'app-hello-world',
  templateUrl: './hello-world.component.html',
  styleUrls: ['./hello-world.component.css']
})
export class HelloWorldComponent implements OnInit, OnDestroy {

  constructor(private helloWorldService: HelloWorldService) { }
  private hello: Hello;
  private helloSubscription: Subscription = Subscription.EMPTY;


  ngOnInit() {
    this.helloSubscription = this.helloWorldService.helloWorld().subscribe( (response: Hello) => {
      this.hello = response;
      this.helloSubscription.unsubscribe();
    });
  }

  ngOnDestroy() {
    this.helloSubscription.unsubscribe();
  }

}
