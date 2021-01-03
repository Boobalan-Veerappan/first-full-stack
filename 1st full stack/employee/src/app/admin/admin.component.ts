import { Component, OnInit } from '@angular/core';
import { LoginServiceService } from '../login-service.service'
import { Router, ActivatedRoute } from '@angular/router';
@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {
nav:string='home';
currentuser:any;
myImgUrl:string='https://www.xovi.com/wp-content/plugins/all-in-one-seo-pack/images/default-user-image.png';
  constructor(public login:LoginServiceService,private route: ActivatedRoute,
    private router: Router) {


   }

  ngOnInit() {
  
  }

  navchange(tab)
  {
this.nav = tab;
  }

  logout(){
     localStorage.removeItem('token');
    this.router.navigate(['/login']);
   
  }
  

}
