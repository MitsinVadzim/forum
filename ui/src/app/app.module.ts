import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './shared/layout/header/header.component';
import { PostListComponent } from './post-list/post-list.component';
import { PostCreateComponent } from './post-create/post-create.component';
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {MyMaterialModule} from "./material.module";
import { LoginComponent } from './login/login.component';
import {FormsModule} from "@angular/forms";
import { ErrorComponent } from './error/error.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    PostListComponent,
    PostCreateComponent,
    LoginComponent,
    ErrorComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MyMaterialModule,
    FormsModule
  ],
  entryComponents: [ErrorComponent],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
