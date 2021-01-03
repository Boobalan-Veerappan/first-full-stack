import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { map } from 'rxjs/operators';
import { loginDTO } from "./loginDTO";
import { Token } from '@angular/compiler/src/ml_parser/lexer';
import { token } from '../app/tokenDTO';
import { Router, ActivatedRoute } from '@angular/router';
import { EmployeeDetails } from './employeeDetails-dto';
@Injectable({
  providedIn: 'root'
})
export class LoginServiceService {
 
  loginform = new loginDTO();
  token: string;
  securityauthority: any;
  constructor(public http: HttpClient, private route: ActivatedRoute,
    private router: Router) { }
currentUser:EmployeeDetails;
  login(username: string, password: string) {
    this.loginform.username = username;
    this.loginform.password = password;

    console.log("datas", this.loginform);
    return this.http.post<any>('http://localhost:8080/api/v1/auth/login', this.loginform,{ headers: { skip: 'true' } })
      .pipe(map(user => {

        this.securityauthority = user.details;
        this.token = user.token;

        localStorage.setItem('token', this.token);

        if (this.securityauthority.authorities[0].authority == "ROLE_ADMIN") {

          this.searchbyemail(this.loginform.username).subscribe(data=>{
            console.log("current ",data);
            this.currentUser = data;
          })
          this.router.navigate(['/login/admin']);
          
          
        }
        else if (this.securityauthority.authorities[0].authority == "USER") {
          this.searchbyemail(this.loginform.username).subscribe(data=>{
            console.log("current ",data);
            this.currentUser = data;
          })
          this.router.navigate(['/login/user']);
        }




      }));

  }

  getoken()
  {

    const token = localStorage.getItem('token');
    return token;

  }

  AllEmployee() {
    var token = localStorage.getItem('token');
    console.log("all emp token" + token);
    return this.http.get<any>('http://localhost:8080/api/v1/emp/all', {
      headers: {
        'Content-Type': 'application/json',
        'Authorization': 'Bearer ' + token
      }

    });
  }
  findAll()
  {

    return this.http.get<any>('http://localhost:8080/api/v1/emp/all');

  }

  updateEmployee(updateValue:EmployeeDetails)
  {
return this.http.put<EmployeeDetails>('http://localhost:8080/api/v1/emp/update',updateValue);

  }

addEmployeee(addValue:EmployeeDetails)
{
return this.http.post<EmployeeDetails>('http://localhost:8080/api/v1/emp/addemp',addValue);
}

searchbyemail(email:string)
{

  return this.http.get<any>(`http://localhost:8080/api/v1/emp/searchName/${email}`);

}
deleteEmployee(id:string)
{
return this.http.delete<any>(`http://localhost:8080/api/v1/emp/delete/${id}`)
}

}
