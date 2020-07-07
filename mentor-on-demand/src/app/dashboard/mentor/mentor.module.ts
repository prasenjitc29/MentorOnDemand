import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { MentorComponent } from './mentor.component';
import { SharedModule } from 'src/app/shared/shared.module';
import { MentorRoutingModule } from './mentor-routing.module';
import { CompletedComponent } from './completed/completed.component';
import { ApprovalComponent } from './approval/approval.component';
import { SkillsComponent } from './skills/skills.component';
import { InprogressComponent } from './inprogress/inprogress.component';

@NgModule({
  declarations: [ MentorComponent, CompletedComponent, ApprovalComponent, SkillsComponent, InprogressComponent, ],
  imports: [
    CommonModule,
    SharedModule,
    MentorRoutingModule
  ]
})
export class MentorModule { }
