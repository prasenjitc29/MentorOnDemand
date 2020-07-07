import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { SharedModule } from 'src/app/shared/shared.module';
import { TraineeComponent } from './trainee.component';
import { TraineeRoutingModule } from "./trainee-routing.module";
import { CompletedComponent } from './completed/completed.component';
import { InprogressComponent } from './inprogress/inprogress.component';

@NgModule({
  declarations: [ TraineeComponent, CompletedComponent, InprogressComponent ],
  imports: [
    CommonModule,
    SharedModule,
    TraineeRoutingModule
  ]
})
export class TraineeModule { }
