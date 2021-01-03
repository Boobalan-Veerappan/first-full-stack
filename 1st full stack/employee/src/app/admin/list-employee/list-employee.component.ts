import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { EmployeeDetails } from '../../../app/employeeDetails-dto';
import { LoginServiceService } from '../../login-service.service'
import { Pipe, PipeTransform } from '@angular/core';
@Component({
  selector: 'app-list-employee',
  templateUrl: './list-employee.component.html',
  styleUrls: ['./list-employee.component.css']
})
export class ListEmployeeComponent implements OnInit {

  public userForm: FormGroup;
  imageSrc:string;
  
  dataSource: any[]=[];
  selectedId: string;
  search:string;
  myImgUrl:string='https://www.xovi.com/wp-content/plugins/all-in-one-seo-pack/images/default-user-image.png';
  SelectedEmployee:EmployeeDetails;
  isEdit:boolean;
  currentuser:any;
  constructor(private _fb: FormBuilder, public login: LoginServiceService) {
   
    this.userForm = this._fb.group({
_id:[''],
      emp_name: ['', Validators.required],
      emp_email: ['', Validators.required],
      emp_mobile: ['', Validators.required],
      emp_dob: ['', Validators.required],
      emp_doj: ['', Validators.required],
      emp_position: ['', Validators.required],
      image_url: [''],
      emp_address: this._fb.group({
        local: ['', Validators.required],
        city: ['', Validators.required],
        state: ['', Validators.required],
        country: ['', Validators.required],
        pincode: ['', [Validators.required, Validators.pattern("^[0-9]*$")]]
      })
    });

 this.getAllEmployee();
  }


  getAllEmployee()
  {

    this.login.findAll().subscribe(data => {
      this.currentuser = this.login.currentUser;
      this.collectdata(data);
      
    })
  }

collectdata(data)
{
var datas: any[]=[];
  data.forEach(element => {
    if(element._id !=this.currentuser._id)
    {
datas.push(element);
    }
  });

  this.dataSource = datas;
}

  searchbyname()
  {
   this.SelectedEmployee = null;
   this.isEdit = false;
  }

  ngOnInit() {
  }

  submit() {

    this.userForm.get("_id").setValue(this.SelectedEmployee._id);
    this.imageSrc = null;
    console.log('final update value',this.userForm.value);
    this.login.updateEmployee(this.userForm.value).subscribe(data => {
      this.getAllEmployee();
this.isEdit = false;
    })
  }
  selectid(id: string) {
    this.isEdit = false;
    this.selectedId = id;
    this.dataSource.forEach(element => {
      if(element._id == id)
      {

        this.SelectedEmployee = element;

      }
    });
  }

  deleteEmployee(){
this.login.deleteEmployee(this.SelectedEmployee._id).subscribe(data=>{
   this.getAllEmployee();
this.SelectedEmployee = null;
 })

  }


  editEmployee()
  {
this.isEdit = true;
this.userForm.patchValue(this.SelectedEmployee);
console.log('edit page ',this.userForm.value);

var dob = this.SelectedEmployee.emp_dob.split('/');

if(dob.length>=2)
{
  this.userForm.get("emp_dob").setValue(new Date(parseInt(dob[2]),parseInt(dob[1]),parseInt(dob[0])));
}
var doj = this.SelectedEmployee.emp_doj.split('/');
if(dob.length>=2)
{
  this.userForm.get("emp_doj").setValue(new Date(parseInt(doj[2]),parseInt(doj[1]),parseInt(doj[0])));
}
    
   


  
  }

  browseImage()
  {

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


}
