import { Component, OnInit } from '@angular/core';
import { AuthService } from '../auth/auth.service';
import { NgForm } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';
import { first } from 'rxjs/operators';
import { NotificationService } from '../notification.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  returnUrl:string;
  constructor(private authService: AuthService,private router: Router,
              private route: ActivatedRoute,private notification: NotificationService) { }

  ngOnInit() {
    if (this.authService.currentUserValue) { 
      this.router.navigate(['/trainee']);
    }
    this.returnUrl = this.route.snapshot.queryParams['returnUrl'] || '';
    console.log(this.returnUrl);
  }

  login(loginForm:NgForm){
    this.authService.login(loginForm.value.username,loginForm.value.password)
    .pipe(first())
    .subscribe(
      data =>{
        
        if(this.returnUrl === "/")
        this.router.navigate(['/trainee']);
        else
          this.router.navigate([this.returnUrl]);
      },
      // err => this.notification.showError("Something went wrong",err)
    );
      
    

  }
}
