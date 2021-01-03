import { Component, OnInit } from '@angular/core';
import { LoginServiceService} from '../login-service.service'
import { Router, ActivatedRoute } from '@angular/router';
@Component({
  selector: 'app-masterlogin',
  templateUrl: './masterlogin.component.html',
  styleUrls: ['./masterlogin.component.css']
})
export class MasterloginComponent implements OnInit {

  user:string;
  pass:string;
  invalidcredial=false;
  constructor(public log : LoginServiceService,private route: ActivatedRoute,
    private router: Router) { }

  ngOnInit() {
  }

  login_save()
  {
    console.log("user :",this.user,"password",this.pass);
this.log.login(this.user,this.pass).subscribe(da=>{

},
error=>{

  this.invalidcredial = true;

}

);


  }

}
