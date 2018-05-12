import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';

import {AppComponent} from './app.component';
import {HelloWorldService} from "./services/hello-world.service";
import {HttpClientModule} from "@angular/common/http";
import {HelloWorldComponent} from './hello-world/hello-world.component';
import {RankedGroupManagementComponent} from './ranked-group-management/ranked-group-management.component';
import {PageNotFoundComponent} from './page-not-found/page-not-found.component';
import {RankedItemManagementComponent} from './ranked-item-management/ranked-item-management.component';
import {RankedGroupService} from "./services/ranked-group.service";
import {ReactiveFormsModule} from "@angular/forms";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {MatCardModule} from "@angular/material";

const appRoutes: Routes = [
    {path: 'manage-ranked-group/:id', component: RankedGroupManagementComponent},
    {path: 'manage-ranked-item/:id', component: RankedItemManagementComponent},
    {path: '', component: HelloWorldComponent},
    {path: '**', component: PageNotFoundComponent}
];

@NgModule({
    declarations: [
        AppComponent,
        HelloWorldComponent,
        RankedGroupManagementComponent,
        PageNotFoundComponent,
        RankedItemManagementComponent
    ],
    imports: [
        BrowserModule,
        HttpClientModule,
        ReactiveFormsModule,
        RouterModule.forRoot(
            appRoutes,
            {enableTracing: true} // <-- debugging purposes only
        ),
        BrowserAnimationsModule,
        MatCardModule
    ],
    providers: [HelloWorldService, RankedGroupService],
    bootstrap: [AppComponent]
})
export class AppModule {
}
