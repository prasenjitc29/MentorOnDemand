import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {
  navLinks =[{path:"/admin",label:"Admin Home"},
  {path:"users",label:"All Users"},
  {
    path:"training",
    label: "All Trainings"
  },
  {
    path:"skills",
    label: "Add/Remove Skills"
  }
 ];
  constructor() { }

  ngOnInit() {
  }

}
