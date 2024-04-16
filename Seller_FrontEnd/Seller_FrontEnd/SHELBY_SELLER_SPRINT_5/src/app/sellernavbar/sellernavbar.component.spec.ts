import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SellernavbarComponent } from './sellernavbar.component';

describe('SellernavbarComponent', () => {
  let component: SellernavbarComponent;
  let fixture: ComponentFixture<SellernavbarComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [SellernavbarComponent]
    });
    fixture = TestBed.createComponent(SellernavbarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
