import { Injectable } from '@angular/core';
import { HttpRequest, HttpHandler, HttpEvent, HttpInterceptor } from '@angular/common/http';
import { Observable } from 'rxjs';

import { LoginServiceService } from './login-service.service';
@Injectable()
export class JwtInterceptor implements HttpInterceptor {
    constructor(private authService: LoginServiceService) { }

    intercept(req, next) {
  console.log("!!!!!!!!1");
  
      if (req.headers.get('skip')) {
        return next.handle(req);
  
  
      }
  
  
      const tokenizedReq = req.clone({
        setHeaders: {
          'Authorization': 'Bearer ' + this.authService.getoken()
        }
      });
    console.log("#####",tokenizedReq);
      return next.handle(tokenizedReq);
    }

}

