import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { TodoComponent } from './thuc_hanh/todo/todo.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {RegisterComponent} from './bai_tap/register/register.component';
import {TemplateDrivenFormComponent} from './bai_tap/template-driven-form/template-driven-form.component';
import {RegisterFinalComponent} from './bai_tap/register-final/register-final.component';
import {LoginComponent} from './bai_tap/login/login.component';
import { TestRouterComponent } from './bai_tap/test-router/test-router.component';

@NgModule({
  declarations: [
    AppComponent,
    TemplateDrivenFormComponent,
    RegisterComponent,
    RegisterFinalComponent,
    LoginComponent,
    TodoComponent,
    TestRouterComponent,
  ],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
