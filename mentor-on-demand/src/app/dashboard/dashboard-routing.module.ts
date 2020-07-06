import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { DashboardComponent } from './dashboard.component';
import { MentorComponent } from './mentor/mentor.component';
import { AdminComponent } from './admin/admin.component';
import { TraineeComponent } from './trainee/trainee.component';
import { AuthGuard } from '../auth/auth-guard.service';
import { Role } from '../_models/role';


const routes: Routes = [
  {
    path:"",
    component: DashboardComponent,
    // canActivateChild: [AuthGuard],
    children: [
      {
        path:"admin",
        component: AdminComponent,
        canActivate: [AuthGuard],
        data: { roles: [Role.Admin] }
      },
      {
        path:"mentor",
        component: MentorComponent
      },
      {
        path:"trainee",
        component: TraineeComponent
      }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class DashboardRoutingModule { }
