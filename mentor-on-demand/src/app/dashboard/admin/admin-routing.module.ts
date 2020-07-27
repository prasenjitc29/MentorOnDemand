import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AdminComponent } from './admin.component';
import { UsersComponent } from './users/users.component';
import { SkillsComponent } from './skills/skills.component';
import { TrainingComponent } from './training/training.component';
import { ListCourseComponent } from './admin-course/list-course/list-course.component';
import { AdminCourseComponent } from './admin-course/admin-course.component';
import { AddCourseComponent } from './admin-course/add-course/add-course.component';
import { EditCourseComponent } from './admin-course/edit-course/edit-course.component';
import { CourseResolverService } from '../course-resolver.service';
const routes: Routes = [
  {
    path:"",
    component: AdminComponent,
    // canActivateChild: [AuthGuard],
    children: [
      {
        path:"",
        component: AdminCourseComponent,
        children : [
          {path: "addCourse", component: AddCourseComponent},
          {path: "editCourse/:id", component:EditCourseComponent},
          {path: "listCourse", component:ListCourseComponent,
            resolve: {
              courses: CourseResolverService
            }
          }
        ]
      },
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
