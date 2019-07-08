import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {PostListComponent} from "./post-list/post-list.component";
import {PostCreateComponent} from "./post-create/post-create.component";
import {LoginComponent} from "./login/login.component";

const routes: Routes = [
  {
    path: 'post-list',
    component: PostListComponent
  },
  {
    path: 'post-create',
    component: PostCreateComponent
  },
  {
    path: 'login',
    component: LoginComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
