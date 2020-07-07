import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AdminComponent } from './admin.component';
import { UsersComponent } from './users/users.component';
import { SkillsComponent } from './skills/skills.component';
import { TrainingComponent } from './training/training.component';
const routes: Routes = [
  {
    path:"",
    component: AdminComponent,
    // canActivateChild: [AuthGuard],
    children: [
      {
        path:"users",
        component: UsersComponent,
      },
      {
        path:"skills",
        component: SkillsComponent
      },
      {
        path:"training",
        component: TrainingComponent
      }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AdminRoutingModule { }
