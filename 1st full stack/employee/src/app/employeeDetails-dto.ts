export class EmployeeDetails{
    _id:string;
     emp_name:String;
    emp_email:String;
    emp_mobile:String;
    emp_dob:String;
    emp_address:Address;
    emp_doj:String;
    emp_position:String;
    image_url:String;
}

export class Address{
     local:String;
     city:String;
    state:String;
     country:String;
     pincode:String;

}