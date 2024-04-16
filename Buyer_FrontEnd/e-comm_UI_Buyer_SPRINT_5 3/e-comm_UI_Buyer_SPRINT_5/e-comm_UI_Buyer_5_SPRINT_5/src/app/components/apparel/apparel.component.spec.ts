import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ApparelComponent } from './apparel.component';

describe('ApparelComponent', () => {
  let component: ApparelComponent;
  let fixture: ComponentFixture<ApparelComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ApparelComponent]
    });
    fixture = TestBed.createComponent(ApparelComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
