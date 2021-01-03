import { Component, OnInit } from '@angular/core';
import { LoginServiceService } from '../../login-service.service'
import { Router, ActivatedRoute } from '@angular/router';
@Component({
  selector: 'app-user-header',
  templateUrl: './user-header.component.html',
  styleUrls: ['./user-header.component.css']
})
export class UserHeaderComponent implements OnInit {
  nav:string='home';
  constructor(public login:LoginServiceService,private route: ActivatedRoute,
    private router: Router) { }

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
