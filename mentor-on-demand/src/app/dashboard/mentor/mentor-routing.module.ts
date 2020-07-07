import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { MentorComponent } from './mentor.component';
import { CompletedComponent } from './completed/completed.component';
import { ApprovalComponent } from './approval/approval.component';
import { InprogressComponent } from './inprogress/inprogress.component';
import { SkillsComponent } from './skills/skills.component';

const routes: Routes = [
  {
    path:"",
    component: MentorComponent,
    // canActivateChild: [AuthGuard],
    children: [
      {
        path:"completed",
        component: CompletedComponent,
      },
      {
        path:"approval",
        component: ApprovalComponent
      },
      {
        path:"inprogress",
        component: InprogressComponent
      },
      {
        path:"skills",
        component: SkillsComponent
      }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class MentorRoutingModule { }
