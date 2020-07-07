import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { SharedModule } from 'src/app/shared/shared.module';
import { AdminComponent } from './admin.component';
import { AdminRoutingModule } from './admin-routing.module';
import { UsersComponent } from './users/users.component';
import { SkillsComponent } from './skills/skills.component';
import { TrainingComponent } from './training/training.component';


@NgModule({
  declarations: [ AdminComponent, UsersComponent, SkillsComponent, TrainingComponent],
  imports: [
    CommonModule,
    SharedModule,
    AdminRoutingModule
  ]
})
export class AdminModule { }
