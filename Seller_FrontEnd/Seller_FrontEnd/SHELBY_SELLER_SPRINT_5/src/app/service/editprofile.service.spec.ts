import { TestBed } from '@angular/core/testing';

import { EditprofileService } from './editprofile.service';

describe('EditprofileService', () => {
  let service: EditprofileService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(EditprofileService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
