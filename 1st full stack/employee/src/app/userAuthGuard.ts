import { Injectable } from '@angular/core';
import { Router, CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot } from '@angular/router';
import { LoginServiceService } from './login-service.service';

@Injectable({ providedIn: 'root' })
export class UserAuthGuard implements CanActivate{

    constructor(
        public router: Router,
        public login: LoginServiceService
    ) { }
    canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot):any {

        const currentUser = this.login.loginform.username;
        const password = this.login.loginform.password;
        const token = this.login.token;
        if(currentUser!=null && password!=null && token !=null)
        {

            return true;
        }
        else{
            return false;
        }

    }

}