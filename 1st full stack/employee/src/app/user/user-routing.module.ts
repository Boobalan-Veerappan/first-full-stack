import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { OtherEmployeeComponent } from './user-header/other-employee/other-employee.component'
import { UserComponent } from './user.component'
import { UserHeaderComponent } from './user-header/user-header.component'
import { UpdateProfileComponent } from './user-header/update-profile/update-profile.component'
const routes: Routes = [{

  path:'',
  component:UserHeaderComponent,
  children:[
    {
    path:'',
    component:OtherEmployeeComponent
    },
    {
      path:'update',
      component: UpdateProfileComponent
    }
  ]
}];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class UserRoutingModule { }
