import {Component, OnInit} from '@angular/core';
import {AbstractControl, FormArray, FormBuilder, FormGroup, Validators} from "@angular/forms";
import {RankedGroupService} from "../services/ranked-group.service";
import {RankedGroup} from "../models/ranked-group.model";
import {Router} from "@angular/router";
import {HttpClient} from '@angular/common/http';
import {Cloudinary} from '@cloudinary/angular-5.x';
import {RankedItem} from "../models/ranked-item.model";
import {forkJoin} from "rxjs";
import {Observable} from "rxjs/internal/Observable";
import {Subscription} from "rxjs/internal/Subscription";

@Component({
    selector: 'app-ranked-group-management',
    templateUrl: './ranked-group-management.component.html',
    styleUrls: ['./ranked-group-management.component.css']
})
export class RankedGroupManagementComponent implements OnInit {

    submitted = false;
    formGroup: FormGroup;
    rankedItems: RankedItem[] = [];
    images: File[] = []
    combined: Subscription;

    constructor(
        private fb: FormBuilder,
        private rgservice: RankedGroupService,
        private router: Router,
        private cloudinary: Cloudinary,
        private http: HttpClient
    ) {
    }

    ngOnInit() {
        this.createForm();
    }

    createForm(): void {
        this.formGroup = this.fb.group({
            name: ['', Validators.required],
            rankedItems: this.fb.array([this.createItemForm()])
        });
    }

    private createItemForm() {
        this.images.push(null);
        return this.fb.group({
            name: ['', Validators.required],
            image: File = null
        });
    }

    saveGroup() {
        this.submitted = true;
        if (this.formGroup.invalid) {
            return;
        }

        const observables: Observable<any>[] = [];
        this.images.forEach((value: File) => {
            observables.push(this.uploadImage(value));
        });

        this.combined = forkJoin(
            observables
        ).subscribe((value) => {
            console.log(value);
            const rankedGroup: RankedGroup = {
                id: null,
                name: this.formGroup.get("name").value,
                shortCode: null,
                rankedItems: value.map((httpResponse: any, index: number) => {
                    const itemName = (this.formGroup.get("rankedItems") as FormArray).controls[index].get("name").value;
                    const publicId: string = httpResponse.public_id;
                    const rankedItem: RankedItem = {
                        id: null,
                        name: itemName,
                        image: publicId,
                        score: null
                    };
                    return rankedItem;
                })
            };
            this.rgservice.save(rankedGroup).subscribe(() => {
                this.router.navigate(['/']);
            });
        });
    }

    showValidation(control: AbstractControl, error: string) {
        return control.hasError(error) && (this.submitted || control.touched);
    }

    uploadImage(fileItem: File): Observable<any> {
        console.log(fileItem);
        if (fileItem === null) {
            return new Observable(null);
        }
        const form = new FormData();
        form.append('upload_preset', this.cloudinary.config().upload_preset);
        form.append('folder', 'rankit');
        // Add file to upload
        form.append('file', fileItem);

        return this.http.post(`https://api.cloudinary.com/v1_1/${this.cloudinary.config().cloud_name}/upload`, form);
    }

    addItem() {
        const items = this.formGroup.get('rankedItems') as FormArray;
        items.push(this.createItemForm());
    }

    removeItem(index: number) {
        const items = this.formGroup.get('rankedItems') as FormArray;
        items.removeAt(index);
        this.images.splice(index, 1);
    }

    getRankedItems(): FormArray {
        return (this.formGroup.get('rankedItems') as FormArray);
    }

    onFileChange(event, index: number) {
        if (event.target.files && event.target.files.length) {
            const image = event.target.files[0];
            this.images[index] = image;
        }
    }
}
