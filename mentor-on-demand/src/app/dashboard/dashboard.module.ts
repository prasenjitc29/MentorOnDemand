import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { DashboardRoutingModule } from './dashboard-routing.module';
import { DashboardComponent } from './dashboard.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { AdminComponent } from './admin/admin.component';
import { MentorComponent } from './mentor/mentor.component';
import { TraineeComponent } from './trainee/trainee.component';
import { SharedModule } from '../shared/shared.module';


@NgModule({
  declarations: [DashboardComponent, HeaderComponent, FooterComponent, AdminComponent, MentorComponent, TraineeComponent],
  imports: [
    CommonModule,
    SharedModule,
    DashboardRoutingModule
  ]
})
export class DashboardModule { }
