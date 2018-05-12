import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RankedGroupManagementComponent } from './ranked-group-management.component';

describe('RankedGroupManagementComponent', () => {
  let component: RankedGroupManagementComponent;
  let fixture: ComponentFixture<RankedGroupManagementComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RankedGroupManagementComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RankedGroupManagementComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
