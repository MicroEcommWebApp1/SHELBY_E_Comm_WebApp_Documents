import { TestBed } from '@angular/core/testing';

import { SellerOrderListService } from './seller-order-list.service';

describe('SellerOrderListService', () => {
  let service: SellerOrderListService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SellerOrderListService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
