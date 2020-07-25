import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-courses',
  templateUrl: './courses.component.html',
  styleUrls: ['./courses.component.css']
})
export class CoursesComponent implements OnInit {
  courses =[];
  constructor(private route: ActivatedRoute) { }

  ngOnInit() {
    this.route.data.subscribe(
      
      data =>{
        console.log('Data :', data);
        this.courses = data.courses;
      } 
      
    );
    
  }
  proposeCourse(courseId){
    alert(courseId);
  }

}
