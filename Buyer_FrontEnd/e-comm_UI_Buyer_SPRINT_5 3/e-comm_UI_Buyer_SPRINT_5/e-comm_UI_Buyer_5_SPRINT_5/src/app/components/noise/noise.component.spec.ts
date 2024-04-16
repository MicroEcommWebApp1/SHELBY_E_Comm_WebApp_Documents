import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NoiseComponent } from './noise.component';

describe('NoiseComponent', () => {
  let component: NoiseComponent;
  let fixture: ComponentFixture<NoiseComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [NoiseComponent]
    });
    fixture = TestBed.createComponent(NoiseComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
