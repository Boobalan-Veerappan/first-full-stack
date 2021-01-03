import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { EmployeeDetails } from '../../../app/employeeDetails-dto';
import { LoginServiceService } from '../../login-service.service'
@Component({
  selector: 'app-admin-profile',
  templateUrl: './admin-profile.component.html',
  styleUrls: ['./admin-profile.component.css']
})
export class AdminProfileComponent implements OnInit {
  public userForm: FormGroup;
  currentuser:any;
  TodayDate=new Date();
  myImgUrl:string='https://www.xovi.com/wp-content/plugins/all-in-one-seo-pack/images/default-user-image.png';
  constructor(private _fb: FormBuilder, public login: LoginServiceService) {
    this.userForm = this._fb.group({
      _id:[''],
      emp_name: ['', Validators.required],
      emp_email: ['', Validators.required],
      emp_mobile: ['', Validators.required],
      emp_dob: ['', Validators.required],
      emp_doj: ['', Validators.required],
      emp_position: ['',Validators.required],
      image_url: [''],
      emp_address: this._fb.group({
        local: ['', Validators.required],
        city: ['', Validators.required],
        state: ['', Validators.required],
        country: ['', Validators.required],
        pincode: ['', [Validators.required, Validators.pattern("^[0-9]*$")]]
      })
    });
this.userForm.patchValue(this.login.currentUser);

   }

  ngOnInit() {
  }
  submit() {

    this.userForm.get('_id').setValue(this.login.currentUser._id);
    this.login.updateEmployee(this.userForm.value).subscribe(data=>{

      this.login.currentUser = data;
    })

  }

}
