import { Component, OnInit } from '@angular/core';
import { LoginServiceService } from '../../../login-service.service';
@Component({
  selector: 'app-other-employee',
  templateUrl: './other-employee.component.html',
  styleUrls: ['./other-employee.component.css']
})
export class OtherEmployeeComponent implements OnInit {
  displayedColumns: string[] = ['si', 'emp_name', 'emp_mobile', 'emp_email', 'emp_position']
  Roles: any;
  currentUser: any;
  dataSource: any[]=[];
  constructor(public login: LoginServiceService) {
    
    this.login.findAll().subscribe(data => {
      this.currentUser = this.login.currentUser;
      this.collectdata(data);
    })

  }



  collectdata(data) {

    var datas: any[]=[];
    if (data != null) {
      data.forEach(element => {
        console.log("both",element._id,this.currentUser._id);
        
        if(this.currentUser._id != element._id)
        {
          datas.push(element);
        }
          
        
      });

      this.dataSource = datas;
    }

  }

  ngOnInit() {
  }

}
