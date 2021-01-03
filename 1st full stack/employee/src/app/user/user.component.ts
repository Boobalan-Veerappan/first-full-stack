import { Component, OnInit } from '@angular/core';
import { LoginServiceService } from '../login-service.service';
@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {

  Roles:any;
  constructor(public login : LoginServiceService) {
this.Roles = this.login.securityauthority.authorities;

   }

  ngOnInit() {
  }

}
