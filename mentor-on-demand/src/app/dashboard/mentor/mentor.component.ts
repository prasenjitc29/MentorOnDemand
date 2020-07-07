import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-mentor',
  templateUrl: './mentor.component.html',
  styleUrls: ['./mentor.component.css']
})
export class MentorComponent implements OnInit {

  navLinks =[{path:"/mentor",label:"Search Mentor"},
  {path:"completed",label:"Completed"},
  {
    path:"approval",
    label: "Pending Approval"
  },
  {
    path:"inprogress",
    label: "In Progress"
  },
  {
    path:"skills",
    label: "My Skills"
  }
 ];
  constructor() { }

  ngOnInit() {
  }

}
