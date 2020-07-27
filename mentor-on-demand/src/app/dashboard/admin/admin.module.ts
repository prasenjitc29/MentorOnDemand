import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { SharedModule } from 'src/app/shared/shared.module';
import { AdminComponent } from './admin.component';
import { AdminRoutingModule } from './admin-routing.module';
import { UsersComponent } from './users/users.component';
import { SkillsComponent } from './skills/skills.component';
import { TrainingComponent } from './training/training.component';
import { ListCourseComponent } from './admin-course/list-course/list-course.component';
import { AddCourseComponent } from './admin-course/add-course/add-course.component';
import { EditCourseComponent } from './admin-course/edit-course/edit-course.component';
import { AdminCourseComponent } from './admin-course/admin-course.component';


@NgModule({
  declarations: [ AdminComponent, UsersComponent, SkillsComponent, TrainingComponent, ListCourseComponent, AddCourseComponent, EditCourseComponent, AdminCourseComponent],
  imports: [
    CommonModule,
    SharedModule,
    AdminRoutingModule
  ]
})
export class AdminModule { }
