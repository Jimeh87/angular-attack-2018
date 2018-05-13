import {ChangeDetectorRef, Component, OnInit, NgZone, Input} from '@angular/core';
import {FormArray, FormBuilder, FormControl, FormGroup} from "@angular/forms";
import {RankedGroupService} from "../services/ranked-group.service";
import {RankedGroup} from "../models/ranked-group.model";
import {Router} from "@angular/router";
import {HttpClient} from '@angular/common/http';
import {FileUploader, FileUploaderOptions, ParsedResponseHeaders} from 'ng2-file-upload';
import {Cloudinary} from '@cloudinary/angular-5.x';
import {RankedItem} from "../models/ranked-item.model";

@Component({
    selector: 'app-ranked-group-management',
    templateUrl: './ranked-group-management.component.html',
    styleUrls: ['./ranked-group-management.component.css']
})
export class RankedGroupManagementComponent implements OnInit {

    @Input()
    responses: Array<any>;

    private title: string;

    formGroup: FormGroup;
    rankedItems: RankedItem[] = [];
    private uploader: FileUploader;

    constructor(
        private fb: FormBuilder,
        private rgservice: RankedGroupService,
        private router: Router,
        private cloudinary: Cloudinary,
        private zone: NgZone,
        private http: HttpClient
    ) {
        this.responses = [];
        this.title = '';
    }

    ngOnInit() {
        this.createForm();
        this.initilizeLoader();
    }


    createForm(): void {
        this.formGroup = this.fb.group({
            name: '',
            rankedItems: this.fb.array([this.createItemForm()])
        });
    }

    private createItemForm() {
        return this.fb.group({
            name: '',
            image: File = null
        });
    }

    saveGroup() {
        const rankedGroup: RankedGroup = {
            id: null,
            name: this.formGroup.get("name").value,
            rankedItems: (this.formGroup.get("rankedItems") as FormArray).controls.map((value: FormGroup, index: number) => {
                const item : RankedItem = {
                    id: null,
                    name: value.get("name"),
                    image: value.get("image")
                };
            })
        };


    }

    uploadImage(event: any) {
        const fileItem = <File>event.target.files[0];
        const form = new FormData();
        form.append('upload_preset', this.cloudinary.config().upload_preset);
        form.append('folder', 'rankit');
        // Add file to upload
        form.append('file', fileItem);

        this.http.post(`https://api.cloudinary.com/v1_1/${this.cloudinary.config().cloud_name}/upload`, form)
            .subscribe(res => {
                console.log(res);
            });
    }


    addItem() {
        const items = this.formGroup.get('rankedItems') as FormArray;
        items.push(this.createItemForm());
    }

    removeItem(index: number) {
        const items = this.formGroup.get('rankedItems') as FormArray;
        items.removeAt(index);
    }

}
