import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { UserRegistration } from './user-registration';
import { Observable } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { throwError } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class RegisterService {
  _url:string = "api/auth/signup";
  constructor(private _http: HttpClient) { }

  register(user:UserRegistration) : Observable<any>{
    return this._http.post<any>(`${environment.apiUrl}/api/auth/signup`, user);
  }

  getUser(userName:string) {
    return this._http.get(this._url);
  }

}
