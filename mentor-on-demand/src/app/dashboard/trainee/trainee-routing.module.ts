import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { TraineeComponent } from './trainee.component';
import { CompletedComponent } from './completed/completed.component';
import { InprogressComponent } from './inprogress/inprogress.component';

const routes: Routes = [
  {
    path:"",
    component: TraineeComponent,
    children: [
      {
        path:"completed",
        component: CompletedComponent,
      },
      {
        path:"inprogress",
        component: InprogressComponent
      }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class TraineeRoutingModule { }
