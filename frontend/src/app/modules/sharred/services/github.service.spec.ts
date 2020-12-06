import { Observable } from 'rxjs';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { TestBed } from '@angular/core/testing';

import { GithubService } from './github.service';

describe('GithubService', () => {
  let service: GithubService;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
      providers: [GithubService],
    });
    service = TestBed.inject(GithubService);
  });

  it('should create', () => {
    expect(service).toBeTruthy();
  });

  it('getUser should return observable ', () => {
    expect(service.getUser('')).toBeInstanceOf(Observable);
  });

  it('getUserRepos should return observable ', () => {
    expect(service.getUser('')).toBeInstanceOf(Observable);
  });

  it('getUserStarred should return observable ', () => {
    expect(service.getUser('')).toBeInstanceOf(Observable);
  });
});
