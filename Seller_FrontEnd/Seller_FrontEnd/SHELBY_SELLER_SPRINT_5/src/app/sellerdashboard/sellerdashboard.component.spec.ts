import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SellerdashboardComponent } from './sellerdashboard.component';

describe('SellerdashboardComponent', () => {
  let component: SellerdashboardComponent;
  let fixture: ComponentFixture<SellerdashboardComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [SellerdashboardComponent]
    });
    fixture = TestBed.createComponent(SellerdashboardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
