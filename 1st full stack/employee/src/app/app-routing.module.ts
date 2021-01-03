import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { MasterloginComponent } from './masterlogin/masterlogin.component';
import { AuthGuard } from './AuthGuard';
import { AdminAuthGuard } from './AdminAuthGuard';
import { UserAuthGuard } from './userAuthGuard';
const routes: Routes = [];

@NgModule({
  imports: [RouterModule.forRoot([{
    path:'',
    redirectTo: '/login',
    pathMatch: 'full'
  },
  {
    path:'login',
    component:MasterloginComponent
  },
  {
    path:'login/admin',
    loadChildren: ()=>import('./admin/admin.module').then(m=>m.AdminModule),
    canActivate: [AdminAuthGuard]

  },
  {

    path:'login/user',
    loadChildren: ()=>import('./user/user.module').then(m=>m.UserModule),
    canActivate: [UserAuthGuard]
  }
 

  
 


])],
  exports: [RouterModule]
})
export class AppRoutingModule { }
