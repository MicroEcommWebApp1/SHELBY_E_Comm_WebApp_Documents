import { TestBed } from '@angular/core/testing';

import { ImageProcessingService } from './imageprocessing.service';

describe('ImageprocessingService', () => {
  let service: ImageProcessingService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ImageProcessingService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
