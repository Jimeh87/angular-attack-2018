import { TestBed, inject } from '@angular/core/testing';

import { RankService } from './rank.service';

describe('RankService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [RankService]
    });
  });

  it('should be created', inject([RankService], (service: RankService) => {
    expect(service).toBeTruthy();
  }));
});
