import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { EmployeeDetails } from '../../../app/employeeDetails-dto';
import { LoginServiceService } from '../../login-service.service'
@Component({
  selector: 'app-add-employee',
  templateUrl: './add-employee.component.html',
  styleUrls: ['./add-employee.component.css']
})
export class AddEmployeeComponent implements OnInit {
  public userForm: FormGroup;
  imageSrc:string;
  TodayDate=new Date();
  myImgUrl:string='https://www.xovi.com/wp-content/plugins/all-in-one-seo-pack/images/default-user-image.png';
 
  constructor(private _fb: FormBuilder, public login: LoginServiceService) {

    this.userForm = this._fb.group({

      emp_name: ['', Validators.required],
      emp_email: ['', Validators.required,Validators.pattern("^[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$]")],
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


  }

  ngOnInit() {
  }
  onFileChange(event) {
    const reader = new FileReader();
    
    if(event.target.files && event.target.files.length) {
      const [file] = event.target.files;
      reader.readAsDataURL(file);
    
      reader.onload = () => {
   
        this.imageSrc = reader.result as string;
     console.log('image url',this.imageSrc);

        this.userForm.patchValue({
          image_url: reader.result 
        });
   
      };
   
    }
  }
  submit()
  {
    this.login.addEmployeee(this.userForm.value).subscribe(data=>{
      console.log('success data',data);
    })
  }
}
