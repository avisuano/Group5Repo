import { TestBed } from '@angular/core/testing';

import { SearchConfigService } from './search-config.service';

describe('SearchConfigService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: SearchConfigService = TestBed.get(SearchConfigService);
    expect(service).toBeTruthy();
  });
});
