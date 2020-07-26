import { Component, OnInit } from '@angular/core';
import { StudentTrainings } from 'src/app/_models/student-trainings';

@Component({
  selector: 'app-approval',
  templateUrl: './approval.component.html',
  styleUrls: ['./approval.component.css']
})
export class ApprovalComponent implements OnInit {

  approvals : StudentTrainings[] = [];
  displayedColumns: string[] = ['courseName', 'batchName','studentName','action'];
  pushData:boolean = false;

  constructor() { }

  ngOnInit(): void {
    this.getApprovalRatings();
  }

  getApprovalRatings() {
    let st = new StudentTrainings();
    st.batchName = "Morning";
    st.courseName = "UI Complete Basics";
    st.userName = "Kiran";
    this.approvals.push(st);
  }

  approveTraining(element) {

  }

  rejectTraining(element) {

  }

}
