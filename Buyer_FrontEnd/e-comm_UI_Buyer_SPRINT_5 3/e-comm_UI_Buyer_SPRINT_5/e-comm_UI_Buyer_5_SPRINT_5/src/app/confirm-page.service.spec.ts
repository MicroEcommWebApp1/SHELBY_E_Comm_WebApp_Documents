import { TestBed } from '@angular/core/testing';

import { ConfirmPageService } from './confirm-page.service';

describe('ConfirmPageService', () => {
  let service: ConfirmPageService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ConfirmPageService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
