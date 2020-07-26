import { Component, OnInit } from '@angular/core';
import { StudentTrainings } from 'src/app/_models/student-trainings';
import { TraineeService } from '../trainee.service';

@Component({
  selector: 'app-inprogress',
  templateUrl: './inprogress.component.html',
  styleUrls: ['./inprogress.component.css']
})
export class InprogressComponent implements OnInit {

  currentTrainings: StudentTrainings[] = [];
progress = 60;
  constructor(private traineeService: TraineeService) { }

  ngOnInit(): void {
    this.getCurrentTrainings();
  }

  getCurrentTrainings(){
    let userId:Number;
    this.traineeService.getCurrentTrainings(userId)
                        .subscribe(
                          data => {
                            this.currentTrainings = data;                            
                          },
                          error => {
                            let st =  new StudentTrainings();
                            st.courseName = "Test";
                            st.batchName = "Test";
                            this.currentTrainings.push(st);
                          } 
                        );
  }


}
