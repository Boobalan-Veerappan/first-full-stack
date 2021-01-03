import { Injectable } from '@angular/core';
import { Router, CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot } from '@angular/router';
import { LoginServiceService } from './login-service.service';


@Injectable({ providedIn: 'root' })
export class AuthGuard implements CanActivate{

    constructor(
        public router: Router,
        public login: LoginServiceService
    ) { }


    canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot):any {

        const currentUser = this.login.loginform;

        if(currentUser)
        {
return true;
        }

        // this.router.navigate(['/login'], { queryParams: { returnUrl: state.url } });
        return false;


    }
}