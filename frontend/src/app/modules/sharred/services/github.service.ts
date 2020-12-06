import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class GithubService {
  private url = 'https://api.github.com';

  constructor(private httpClient: HttpClient) {}

  public getUser(name: string) {
    return this.httpClient.get(`${this.url}/users/${name}`);
  }

  public getUserRepos(name: string) {
    return this.httpClient.get(`${this.url}/users/${name}/repos`);
  }

  public getUserStarred(name: string) {
    return this.httpClient.get(`${this.url}/users/${name}/starred`);
  }
}
