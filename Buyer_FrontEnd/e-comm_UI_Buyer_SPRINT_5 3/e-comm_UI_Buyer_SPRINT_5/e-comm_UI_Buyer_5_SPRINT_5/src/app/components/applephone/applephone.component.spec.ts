import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ApplephoneComponent } from './applephone.component';

describe('ApplephoneComponent', () => {
  let component: ApplephoneComponent;
  let fixture: ComponentFixture<ApplephoneComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ApplephoneComponent]
    });
    fixture = TestBed.createComponent(ApplephoneComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
