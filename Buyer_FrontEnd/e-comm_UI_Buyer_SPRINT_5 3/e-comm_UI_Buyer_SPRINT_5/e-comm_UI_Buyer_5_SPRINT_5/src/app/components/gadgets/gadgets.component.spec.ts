import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GadgetsComponent } from './gadgets.component';

describe('GadgetsComponent', () => {
  let component: GadgetsComponent;
  let fixture: ComponentFixture<GadgetsComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [GadgetsComponent]
    });
    fixture = TestBed.createComponent(GadgetsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
