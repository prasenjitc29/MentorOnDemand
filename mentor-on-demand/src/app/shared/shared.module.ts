import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { DropdownDirective } from './dropdown.directive';
import { FormsModule,ReactiveFormsModule } from "@angular/forms";

@NgModule({
  declarations: [DropdownDirective],
  imports: [
    CommonModule
  ],
  exports: [
    FormsModule,
    ReactiveFormsModule,
    DropdownDirective
  ]
})
export class SharedModule { }
