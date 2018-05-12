import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RankedGroupComponent } from './ranked-group.component';

describe('RankedGroupComponent', () => {
  let component: RankedGroupComponent;
  let fixture: ComponentFixture<RankedGroupComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RankedGroupComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RankedGroupComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
