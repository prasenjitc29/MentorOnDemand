import { Injectable } from '@angular/core';
import { environment } from '../../../environments/environment';
import { BehaviorSubject, Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { HttpClient } from '@angular/common/http';

@Injectable()
export class TraineeService {

    constructor(private http: HttpClient) {}


    getAllCourses() {
      return this.http.get<any>(`${environment.apiUrl}/api/search/courses`);
    }



}
