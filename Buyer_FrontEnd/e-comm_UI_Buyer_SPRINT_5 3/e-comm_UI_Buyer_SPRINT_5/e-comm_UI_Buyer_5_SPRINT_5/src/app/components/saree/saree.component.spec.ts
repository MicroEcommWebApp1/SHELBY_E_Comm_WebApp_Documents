import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SareeComponent } from './saree.component';

describe('SareeComponent', () => {
  let component: SareeComponent;
  let fixture: ComponentFixture<SareeComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [SareeComponent]
    });
    fixture = TestBed.createComponent(SareeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
