import { Component, OnInit } from '@angular/core';
import {FormArray, FormBuilder, FormControl, FormGroup} from "@angular/forms";

@Component({
  selector: 'app-ranked-group-management',
  templateUrl: './ranked-group-management.component.html',
  styleUrls: ['./ranked-group-management.component.css']
})
export class RankedGroupManagementComponent implements OnInit {

  constructor(private fb: FormBuilder) { }

    formGroup: FormGroup;

    ngOnInit() {
        this.createForm();
    }

    createForm(): void {
        this.formGroup = this.fb.group({
            groupName: '',
            items: this.fb.array([this.createItemForm()])
        });
    }

    private createItemForm() {
        return this.fb.group({
            itemName: ''
        });
    }

    addItem() {
        const items = this.formGroup.get('items') as FormArray;
        items.push(this.createItemForm());
    }

    removeItem(index: number) {
        const items = this.formGroup.get('items') as FormArray;
        items.removeAt(index);
    }

    submitForm() {
        console.log("Input: " + JSON.stringify(this.formGroup.value))
    }
}
