import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ApparelHeaderComponent } from './apparel-header.component';

describe('ApparelHeaderComponent', () => {
  let component: ApparelHeaderComponent;
  let fixture: ComponentFixture<ApparelHeaderComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ApparelHeaderComponent]
    });
    fixture = TestBed.createComponent(ApparelHeaderComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
