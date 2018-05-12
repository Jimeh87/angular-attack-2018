import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import {HelloWorldService} from "./services/hello-world.service";
import {HttpClientModule} from "@angular/common/http";
import { HelloWorldComponent } from './hello-world/hello-world.component';

@NgModule({
  declarations: [
      AppComponent,
      HelloWorldComponent
  ],
  imports: [
      BrowserModule,
      HttpClientModule
  ],
  providers: [HelloWorldService],
  bootstrap: [AppComponent]
})
export class AppModule { }
