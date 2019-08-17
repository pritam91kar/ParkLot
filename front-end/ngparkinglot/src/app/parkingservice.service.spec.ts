import { TestBed } from '@angular/core/testing';

import { ParkingserviceService } from './parkingservice.service';

describe('ParkingserviceService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: ParkingserviceService = TestBed.get(ParkingserviceService);
    expect(service).toBeTruthy();
  });
});
