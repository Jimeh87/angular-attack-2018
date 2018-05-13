import {Component, OnInit} from '@angular/core';
import {FormArray, FormBuilder, FormControl, FormGroup} from "@angular/forms";
import {RankedGroupService} from "../services/ranked-group.service";
import {RankedGroup} from "../models/ranked-group.model";
import {Router} from "@angular/router";

@Component({
    selector: 'app-ranked-group-management',
    templateUrl: './ranked-group-management.component.html',
    styleUrls: ['./ranked-group-management.component.css']
})
export class RankedGroupManagementComponent implements OnInit {

    formGroup: FormGroup
    rankedGroup: RankedGroup = null

    constructor(private fb: FormBuilder, private rgservice: RankedGroupService, private router: Router) {
    }

    ngOnInit() {
        this.createForm();
    }

    createForm(): void {
        this.formGroup = this.fb.group({
            name: '',
            rankedItems: this.fb.array([this.createItemForm()])
        });
    }

    private createItemForm() {
        return this.fb.group({
            name: ''
        });
    }

    saveGroup() {
        this.rankedGroup = this.formGroup.value as RankedGroup;
        this.rgservice.save(this.rankedGroup).subscribe(value => {
            console.log("Saved group successful: " + JSON.stringify(this.rankedGroup));
            this.router.navigate(['/ranked-group'])
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

    getRankedItems() : FormArray {
        return (this.formGroup.get('rankedItems') as FormArray);
    }

}
