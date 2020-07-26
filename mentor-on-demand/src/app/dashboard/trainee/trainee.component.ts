import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-trainee',
  templateUrl: './trainee.component.html',
  styleUrls: ['./trainee.component.css']
})
export class TraineeComponent implements OnInit {

  navLinks =[{path:"/trainee",label:"Trainings"},
  {path:"completed",label:"Completed"},
  {
    path:"inprogress",
    label: "In Progress"
  }
 ];
  constructor() { }

  ngOnInit() {
   
  }

}
