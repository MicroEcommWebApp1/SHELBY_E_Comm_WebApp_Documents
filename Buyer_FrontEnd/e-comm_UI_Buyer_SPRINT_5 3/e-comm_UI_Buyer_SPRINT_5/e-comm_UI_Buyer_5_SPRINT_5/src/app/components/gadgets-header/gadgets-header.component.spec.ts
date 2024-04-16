import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GadgetsHeaderComponent } from './gadgets-header.component';

describe('GadgetsHeaderComponent', () => {
  let component: GadgetsHeaderComponent;
  let fixture: ComponentFixture<GadgetsHeaderComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [GadgetsHeaderComponent]
    });
    fixture = TestBed.createComponent(GadgetsHeaderComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
