import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  registerForm: FormGroup;
  constructor(private fb: FormBuilder) { }

  ngOnInit() {
    this.registerForm = this.fb.group({
      fName : ["",Validators.required],
      lName : ["",Validators.required],
      userName : ["",Validators.required],
      course : ["0",Validators.required],
      email:["",[Validators.required, Validators.email]],
      password : ["",[Validators.required,Validators.minLength(6)]],
      confirmPassword : ["",Validators.required],
    },{
      validators: this.mustMatch("password","confirmPassword")
    });
  }

  get formControls(){
    return this.registerForm.controls;
  }

  mustMatch(firstControlName:string,secondCOntrolName:string){
    return (formgrp: FormGroup)=>{
      const firstControl = formgrp.controls[firstControlName];
      const secondCOntrol = formgrp.controls[secondCOntrolName];

      if(secondCOntrol.errors && ! secondCOntrol.errors.mustMatch){
        return;
      }

      if(firstControl.value != secondCOntrol.value){
        secondCOntrol.setErrors({mustMatch :true});
      }else{
        secondCOntrol.setErrors(null);
      }

    }
  }

  onSubmit() {
      if (this.registerForm.invalid) {
          return;
      }

      alert('SUCCESS!! :-)\n\n' + JSON.stringify(this.registerForm.value, null, 4));
  }

  onReset() {
      this.registerForm.reset();
  }

}
