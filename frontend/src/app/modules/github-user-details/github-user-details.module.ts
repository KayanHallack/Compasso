import { NgModule } from '@angular/core';
import { CommonModule, DatePipe } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { GithubUserDetailsComponent } from './github-user-details.component';
import { GithubUserDetailsRouting } from './github-user-details.routing';
import { InputModule } from 'src/app/components/input/input.module';

@NgModule({
  declarations: [GithubUserDetailsComponent],
  imports: [CommonModule, GithubUserDetailsRouting, FormsModule, InputModule],
  providers: [DatePipe],
})
export class GithubUserDetailsModule {}
