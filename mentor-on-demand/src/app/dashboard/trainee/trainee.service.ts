import { Injectable } from '@angular/core';
import { environment } from '../../../environments/environment';
import { BehaviorSubject, Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { HttpClient } from '@angular/common/http';
import { StudentTrainings } from 'src/app/_models/student-trainings';

@Injectable()
export class TraineeService {

    constructor(private http: HttpClient) {}


    getAllCourses() {
      return this.http.get<any>(`${environment.apiUrl}/api/search/courses`);
    }

    getCurrentTrainings(userId) : Observable<StudentTrainings[]>{
      let searchParams = {
        "userId" : userId,
        "courseStatus" : "InProgress"
      };
      return this.http.get<StudentTrainings[]>(`${environment.apiUrl}`,{params:searchParams});
    }
  
    getCompletedTrainings(userId): Observable<StudentTrainings[]> {
      let searchParams = {
        "userId" : userId,
        "courseStatus" : "Completed"
      };
      return this.http.get<StudentTrainings[]>(`${environment.apiUrl}`,{params:searchParams});
    }
  
    getTraining(trainingId, userId) {
      
    }


}
