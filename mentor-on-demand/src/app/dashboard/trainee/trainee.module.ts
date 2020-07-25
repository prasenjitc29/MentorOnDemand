import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { SharedModule } from 'src/app/shared/shared.module';
import { TraineeComponent } from './trainee.component';
import { TraineeRoutingModule } from "./trainee-routing.module";
import { CompletedComponent } from './completed/completed.component';
import { InprogressComponent } from './inprogress/inprogress.component';
import { CoursesComponent } from './courses/courses.component';
import { TraineeService } from './trainee.service';
import { CourseResolverService } from './course-resolver.service';

@NgModule({
  declarations: [ TraineeComponent, CompletedComponent, InprogressComponent, CoursesComponent ],
  imports: [
    CommonModule,
    SharedModule,
    TraineeRoutingModule
  ],
  providers:[TraineeService,CourseResolverService]
})
export class TraineeModule { }
