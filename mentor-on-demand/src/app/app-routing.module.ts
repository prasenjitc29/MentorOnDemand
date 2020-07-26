import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { PageNotFoundComponent } from './shared/page-not-found/page-not-found.component';
import { AuthGuard } from './auth/auth-guard.service';


const routes: Routes = [
  {
    path:"",
    loadChildren : () => import("./dashboard/dashboard.module").then(module => module.DashboardModule),
    canActivate: [AuthGuard]
  },
  {
    path:"login",
    component :LoginComponent
  },
  {
    path:"register",
    component: RegisterComponent
  },
  {
    path:"**",
    component: PageNotFoundComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
