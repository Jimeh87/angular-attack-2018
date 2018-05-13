import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EasyUrlComponent } from './easy-url.component';

describe('EasyUrlComponent', () => {
  let component: EasyUrlComponent;
  let fixture: ComponentFixture<EasyUrlComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EasyUrlComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EasyUrlComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
