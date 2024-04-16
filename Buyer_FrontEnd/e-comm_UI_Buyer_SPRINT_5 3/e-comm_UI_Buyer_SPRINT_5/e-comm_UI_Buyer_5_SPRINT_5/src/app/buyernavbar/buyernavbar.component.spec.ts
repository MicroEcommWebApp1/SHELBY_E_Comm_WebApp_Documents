import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BuyernavbarComponent } from './buyernavbar.component';

describe('BuyernavbarComponent', () => {
  let component: BuyernavbarComponent;
  let fixture: ComponentFixture<BuyernavbarComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BuyernavbarComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(BuyernavbarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
