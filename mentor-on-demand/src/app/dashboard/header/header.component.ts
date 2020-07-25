import { Component, OnInit } from '@angular/core';
import { AuthService } from 'src/app/auth/auth.service';
import { Router } from '@angular/router';
import { Role } from 'src/app/_models/role';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  adminRole=false;
  mentorRole=false;
  user;
  constructor(private authService: AuthService,private router: Router) { }

  ngOnInit() {
    this.user=this.authService.currentUserValue;
    if(this.user.roles.includes(Role.Admin)){
      this.adminRole= true;
    }
    if(this.user.roles.includes(Role.Mentor)){
      this.mentorRole= true;
    }
    
  }
  logout(){
    this.authService.logout();
    this.router.navigate(["/login"]);
  }

}
