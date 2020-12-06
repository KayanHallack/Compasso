import { Component, OnDestroy, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { DatePipe, Location } from '@angular/common';

@Component({
  selector: 'app-github-user-details',
  templateUrl: './github-user-details.component.html',
  styleUrls: ['./github-user-details.component.scss'],
})
export class GithubUserDetailsComponent implements OnDestroy {
  public user!: any;

  constructor(private router: Router, private location: Location, private datePipe: DatePipe) {
    const nav = this.router.getCurrentNavigation();
    if (nav?.extras.state) {
      this.user = nav?.extras.state;
      localStorage.setItem('user', JSON.stringify(this.user));
    } else {
      const storage = localStorage.getItem('user');
      this.user = storage ? JSON.parse(storage) : this.location.back();
    }    
  }

  ngOnDestroy(): void {
    localStorage.removeItem('user');
  }

  public back(){
    this.location.back();
  }

  get formatedDate(){
    if(this.user?.created_at){
      return this.datePipe.transform(this.user.created_at, 'dd/MM/yyyy');
    }
    return '-';
  }

}
