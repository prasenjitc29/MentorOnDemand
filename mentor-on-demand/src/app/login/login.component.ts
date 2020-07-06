import { Component, OnInit } from '@angular/core';
import { AuthService } from '../auth/auth.service';
import { NgForm } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';
import { first } from 'rxjs/operators';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  returnUrl:string;
  constructor(private authService: AuthService,private router: Router,private route: ActivatedRoute) { }

  ngOnInit() {
    if (this.authService.currentUserValue) { 
      this.router.navigate(['']);
    }
    this.returnUrl = this.route.snapshot.queryParams['returnUrl'] || '';
  }

  login(loginForm:NgForm){
    this.authService.login(loginForm.value.username,loginForm.value.password)
    .pipe(first())
    .subscribe(
      data =>{
        this.router.navigate([this.returnUrl]);
      }
    );
      
    

  }
}
