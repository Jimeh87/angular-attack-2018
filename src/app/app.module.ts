import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {AppComponent} from './app.component';
import {HelloWorldService} from "./services/hello-world.service";
import {HttpClientModule} from "@angular/common/http";
import {HelloWorldComponent} from './hello-world/hello-world.component';
import {RankedGroupManagementComponent} from './ranked-group-management/ranked-group-management.component';
import {PageNotFoundComponent} from './page-not-found/page-not-found.component';
import {RankedGroupService} from "./services/ranked-group.service";
import {ReactiveFormsModule} from "@angular/forms";
import {RankedGroupComponent} from './ranked-group/ranked-group.component';
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {
    MatButtonModule,
    MatCardModule, MatDividerModule,
    MatGridListModule,
    MatIconModule,
    MatInputModule, MatTableModule,
    MatToolbarModule
} from "@angular/material";
import {CompareComponent} from './compare/compare.component';
import { HomeComponent } from './home/home.component';

const appRoutes: Routes = [
    {path: 'manage-ranked-group/:id', component: RankedGroupManagementComponent},
    {path: 'compare/:rankedGroupId', component: CompareComponent},
    {path: 'ranked-group', component: RankedGroupComponent},
    {path: 'manage-ranked-group', component: RankedGroupManagementComponent},
    {path: '', component: HelloWorldComponent},
    {path: '**', component: PageNotFoundComponent}
];

@NgModule({
    declarations: [
        AppComponent,
        HelloWorldComponent,
        RankedGroupManagementComponent,
        PageNotFoundComponent,
        CompareComponent,
        RankedGroupComponent,
        HomeComponent
    ],
    imports: [
        BrowserModule,
        HttpClientModule,
        ReactiveFormsModule,
        RouterModule.forRoot(appRoutes),
        BrowserAnimationsModule,
        MatCardModule,
        MatGridListModule,
        MatCardModule,
        MatInputModule,
        MatButtonModule,
        MatTableModule,
        MatDividerModule,
        MatToolbarModule,
        MatIconModule
    ],
    providers: [HelloWorldService, RankedGroupService],
    bootstrap: [AppComponent]
})
export class AppModule {
}
