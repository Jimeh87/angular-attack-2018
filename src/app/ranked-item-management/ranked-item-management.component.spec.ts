import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RankedItemManagementComponent } from './ranked-item-management.component';

describe('RankedItemManagementComponent', () => {
  let component: RankedItemManagementComponent;
  let fixture: ComponentFixture<RankedItemManagementComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RankedItemManagementComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RankedItemManagementComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
