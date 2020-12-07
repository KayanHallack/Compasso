import { TableColumn } from 'src/app/modules/sharred/models/table-column';
import { Component, OnInit } from '@angular/core';

import { take } from 'rxjs/operators';

import { GithubService } from './../sharred/services/github.service';

@Component({
  selector: 'app-github',
  templateUrl: './github.component.html',
  styleUrls: ['./github.component.scss'],
})
export class GithubComponent implements OnInit {
  public name!: string;
  public userCols!: TableColumn[];
  public reposCols!: TableColumn[];
  public starredCols!: TableColumn[];
  public users!: any[];
  public repos!: any[];
  public starred!: any[];

  public tableLock = true;
  public loadingUser = false;
  public loadingRepos = false;
  public loadingStarred = false;

  constructor(private githubService: GithubService) {}

  ngOnInit(): void {
    this.buildCols();
  }

  public search() {
    this.tableLock = false;
    this.loadingUser = true;
    this.githubService
      .getUser(this.name)
      .pipe(take(1))
      .subscribe(
        (response) => {
          this.users = [response];
          this.loadingUser = false;
        },
        (error) => {
          this.loadingUser = false;
        }
      );
  }

  public searchRepos(input: any) {
    this.loadingRepos = true;
    this.githubService
      .getUserRepos(input.login)
      .pipe(take(1))
      .subscribe(
        (response: any) => {
          this.repos = response;
          this.loadingRepos = false;
        },
        (error) => {
          this.loadingRepos = false;
        }
      );
  }

  public searchStarred(input: any) {
    this.loadingStarred = true;
    this.githubService
      .getUserStarred(input.login)
      .pipe(take(1))
      .subscribe((response: any) => {
        this.starred = response;
        this.loadingStarred = false;
      },
      (error) => {
        this.loadingStarred = false;
      });
  }

  private buildCols() {
    this.userCols = [
      new TableColumn('Id', 'id'),
      new TableColumn('Nome', 'name'),
      new TableColumn('Login', 'login'),
      new TableColumn('Repositórios', 'public_repos'),
      new TableColumn('Seguidores', 'followers'),
      new TableColumn('Seguindo', 'following'),
    ];

    this.reposCols = [
      new TableColumn('Id', 'id'),
      new TableColumn('Nome', 'name'),
      new TableColumn('Url', 'html_url'),
    ];

    this.starredCols = [
      new TableColumn('Id', 'id'),
      new TableColumn('Nome', 'name'),
      new TableColumn('Dono', 'owner.login'),
      new TableColumn('Url', 'html_url'),
    ];
  }
}
