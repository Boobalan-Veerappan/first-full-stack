import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AdminRoutingModule } from './admin-routing.module';
import { ListEmployeeComponent } from './list-employee/list-employee.component';
import { AdminComponent } from './admin.component';
import { ReactiveFormsModule } from '@angular/forms';
import {MatDatepickerModule} from '@angular/material/datepicker';
import {MatFormFieldModule} from '@angular/material/form-field';
import { MatNativeDateModule } from '@angular/material/core';
import { MatInputModule , MatTabsModule,MatTableModule, MatSelectModule} from '@angular/material';
import { MatCardModule } from '@angular/material/card';
import { AddEmployeeComponent } from './add-employee/add-employee.component';
import { AdminProfileComponent } from './admin-profile/admin-profile.component';
import { Pipe, PipeTransform } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { FilterBasedOnName } from '../pipe/filter-based-on-name';
@NgModule({
  declarations: [FilterBasedOnName,ListEmployeeComponent,AdminComponent, AddEmployeeComponent, AdminProfileComponent],
  imports: [
    CommonModule,
    AdminRoutingModule,
    MatTabsModule,
    MatTableModule,
    ReactiveFormsModule,
    MatDatepickerModule,
    MatFormFieldModule,
    MatNativeDateModule,
    MatInputModule,
    MatCardModule,
    MatSelectModule,
    FormsModule
  ]
})
export class AdminModule { }
