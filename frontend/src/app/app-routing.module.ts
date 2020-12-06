import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

const routes: Routes = [
  {
    path: 'github',
    loadChildren: () =>
      import('./modules/github/github.module').then((m) => m.GithubModule),
  },
  {
    path: 'user-details',
    loadChildren: () =>
      import('./modules/github-user-details/github-user-details.module').then((m) => m.GithubUserDetailsModule),
  },
  { path: '', redirectTo: '/github', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
