import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { UserRoutingModule } from './user-routing.module';
import { OtherEmployeeComponent } from './user-header/other-employee/other-employee.component';
import { UserComponent } from './user.component';
import { UserHeaderComponent } from './user-header/user-header.component';
import {MatTabsModule} from '@angular/material/tabs';
import {MatTableModule} from '@angular/material/table';
import { ReactiveFormsModule } from '@angular/forms';
import {MatDatepickerModule} from '@angular/material/datepicker';
import {MatFormFieldModule} from '@angular/material/form-field';
import { MatNativeDateModule } from '@angular/material/core';
import { MatInputModule,MatSelectModule } from '@angular/material';
import { UpdateProfileComponent } from './user-header/update-profile/update-profile.component';
import { FormsModule } from '@angular/forms';
 import { UserBasedOnName } from '../pipe/userfilter';
@NgModule({
  declarations: [UserBasedOnName,OtherEmployeeComponent,UserComponent,UserHeaderComponent, UpdateProfileComponent],
  imports: [
    CommonModule,
    UserRoutingModule,
    MatTabsModule,
    MatTableModule,
    ReactiveFormsModule,
    MatDatepickerModule,
    MatFormFieldModule,
    MatNativeDateModule,
    MatInputModule,
    MatSelectModule,
    FormsModule
  ]
})
export class UserModule { }
