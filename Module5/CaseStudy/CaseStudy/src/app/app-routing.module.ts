import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { Ng2SearchPipeModule } from 'ng2-search-filter';
import { FormsModule, ReactiveFormsModule} from '@angular/forms';
import {NgxPaginationModule} from 'ngx-pagination';

import { HomeComponent } from './components/home/home.component';
import { PageNotFoundComponent } from './components/page-not-found/page-not-found.component';
import { EmployeesComponent } from './components/employees/employees.component';
import { EmployeeListComponent } from './components/employees/employee-list/employee-list.component';
import {CommonModule} from '@angular/common';
import {EmployeeAddComponent} from './components/employees/employee-add/employee-add.component';
import { MaterialModule} from './material.module';
import { EmployeeDeleteDialogComponent } from './components/employees/employee-delete-dialog/employee-delete-dialog.component';
import { EmployeeEditComponent } from './components/employees/employee-edit/employee-edit.component';

const routes: Routes = [
  { path: '', component: HomeComponent},
  { path: 'employee-list', component: EmployeeListComponent},
  { path: 'employee-add', component: EmployeeAddComponent},
  { path: 'employee-edit/:id', component: EmployeeEditComponent},


  { path:'**', component: PageNotFoundComponent}
  // dấu * có nghĩa là nếu được dẫn không phải 2 cái trên thì mặc định chạy lầ Pagenotfound
];

@NgModule({
  imports: [RouterModule.forRoot(routes), CommonModule,
    Ng2SearchPipeModule, FormsModule, NgxPaginationModule, ReactiveFormsModule, MaterialModule],
  exports: [RouterModule],
  declarations: [HomeComponent, PageNotFoundComponent, EmployeesComponent, EmployeeListComponent, EmployeeDeleteDialogComponent, EmployeeEditComponent]
})
export class AppRoutingModule { }
