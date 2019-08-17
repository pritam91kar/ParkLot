import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Identifiers } from '@angular/compiler';

@NgModule({
  declarations: [],
  imports: [
    CommonModule
  ]
})
export class ParkingsmoduleModule {
	id: Number;
	created_at: Date;
	lot: Number;
	parking_amount: Number;
	parking_duration: Number;
	updated_at: Date;
	vaichel_number: Number;

	
 }
