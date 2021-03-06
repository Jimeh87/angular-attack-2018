import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';

import { Cloudinary } from 'cloudinary-core/cloudinary-core-shrinkwrap';
import { CloudinaryConfiguration, CloudinaryModule} from '@cloudinary/angular-5.x';
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
    MatCardModule,
    MatDividerModule,
    MatGridListModule,
    MatIconModule,
    MatInputModule,
    MatTableModule,
    MatToolbarModule
} from "@angular/material";
import {CompareComponent} from './compare/compare.component';
import {HomeComponent} from './home/home.component';
import { EasyUrlComponent } from './easy-url/easy-url.component';

const appRoutes: Routes = [
    {path: 'r/:shortId', component: EasyUrlComponent},
    {path: 'manage-ranked-group/:id', component: RankedGroupManagementComponent},
    {path: 'compare/:rankedGroupId', component: CompareComponent},
    {path: 'ranked-group', component: RankedGroupComponent},
    {path: 'manage-ranked-group', component: RankedGroupManagementComponent},
    {path: '', component: HomeComponent},
    {path: '**', component: PageNotFoundComponent}
];

const cloudConfig = {
    cloud_name: 'loweredexpectations', upload_preset: 'e6cxednp'
};

const cloudinaryLib = {
    Cloudinary: Cloudinary
};

@NgModule({
    declarations: [
        AppComponent,
        HelloWorldComponent,
        RankedGroupManagementComponent,
        PageNotFoundComponent,
        CompareComponent,
        RankedGroupComponent,
        HomeComponent,
        EasyUrlComponent
    ],
    imports: [
        BrowserModule,
        HttpClientModule,
        ReactiveFormsModule,
        RouterModule.forRoot( appRoutes),
        CloudinaryModule.forRoot(cloudinaryLib, cloudConfig as CloudinaryConfiguration),
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
