import { Component, NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ListEmployeeComponent } from './list-employee/list-employee.component';
import { AdminComponent } from './admin.component';
import { AddEmployeeComponent } from './add-employee/add-employee.component';
import { AdminProfileComponent } from './admin-profile/admin-profile.component';
const routes: Routes = [{

  path:'',
component:AdminComponent,
children:[
  {
  path:'',
  component:ListEmployeeComponent
  },
  {
    path:'add',
    component:AddEmployeeComponent
  },
  {
    path:'profile',
    component:AdminProfileComponent
  }

]

  }];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AdminRoutingModule { }
