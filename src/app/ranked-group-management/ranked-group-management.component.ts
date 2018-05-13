import {Component, OnInit} from '@angular/core';
import {AbstractControl, FormArray, FormBuilder, FormControl, FormGroup, Validator, Validators} from "@angular/forms";
import {RankedGroupService} from "../services/ranked-group.service";
import {RankedGroup} from "../models/ranked-group.model";
import {Router} from "@angular/router";

@Component({
    selector: 'app-ranked-group-management',
    templateUrl: './ranked-group-management.component.html',
    styleUrls: ['./ranked-group-management.component.css']
})
export class RankedGroupManagementComponent implements OnInit {

    submitted = false;
    formGroup: FormGroup
    rankedGroup: RankedGroup = null

    constructor(private fb: FormBuilder, private rgservice: RankedGroupService, private router: Router) {
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
        return this.fb.group({
            name: ['', Validators.required]
        });
    }

    saveGroup() {
        this.submitted = true;
        if (this.formGroup.invalid) {
            return;
        }
        this.rankedGroup = this.formGroup.value as RankedGroup;
        this.rgservice.save(this.rankedGroup).subscribe(() => {
            this.router.navigate(['/'])
        });

    }

    showValidation(control: AbstractControl, error: string) {
        return control.hasError(error) && (this.submitted || control.touched);
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
