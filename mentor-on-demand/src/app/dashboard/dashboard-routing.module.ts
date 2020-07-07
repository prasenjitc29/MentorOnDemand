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
        canActivateChild: [AuthGuard],
        data: { roles: [Role.Admin] },
        loadChildren: () => import("./admin/admin.module").then(module => module.AdminModule)
      },
      {
        path:"mentor",
        loadChildren: () => import("./mentor/mentor.module").then(module => module.MentorModule)
      },
      {
        path:"trainee",
       loadChildren: () => import("./trainee/trainee.module").then(module => module.TraineeModule)
      }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class DashboardRoutingModule { }
