import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { TraineeComponent } from './trainee.component';
import { CompletedComponent } from './completed/completed.component';
import { InprogressComponent } from './inprogress/inprogress.component';
import { CoursesComponent } from './courses/courses.component';
import { CourseResolverService } from './course-resolver.service';

const routes: Routes = [
  {
    path:"",
    component: TraineeComponent,
    children: [
      {
        path:"",
        component: CoursesComponent,
        resolve: {
          courses: CourseResolverService
          }
      },
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
