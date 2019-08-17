import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import { ParkingsmoduleModule } from './parkingsmodule.module';
import { ParkingserviceService } from './parkingservice.service';
import { CodegenComponentFactoryResolver } from '@angular/core/src/linker/component_factory_resolver';

@Component({
	selector: 'app-root',
	templateUrl: './app.component.html',
	styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {

	parkings: ParkingsmoduleModule[];
	error_message: String;
	parkObj: ParkingsmoduleModule = new ParkingsmoduleModule();
	vehicleForm = new FormGroup({
		vehicleLot: new FormControl(),
		vehicleNumber: new FormControl(),
		vehicleDuration: new FormControl(),
		vehicleAmount: new FormControl(this.parkObj.parking_amount),
	});
	
	errorAlert: boolean;

	constructor(private http: ParkingserviceService) { }

	onSubmit() {
		this.parkObj.lot = this.vehicleForm.get('vehicleLot').value;
		this.parkObj.vaichel_number = this.vehicleForm.get('vehicleNumber').value;
		this.parkObj.parking_duration = this.vehicleForm.get('vehicleDuration').value;
		this.parkObj.parking_amount = parseInt(this.vehicleForm.get('vehicleAmount').value);
		const result = this.parkings.filter(r => {
			 return r.lot === this.parkObj.lot && r.vaichel_number ===this.parkObj.vaichel_number;
		})
		console.log('>>>>>>'+result)
		if(result.length === 0){
            this.http.addParkLot(this.parkObj)
			.subscribe
			(
				data => {
					this.ngOnInit();
				},
				err => {
					console.log('>>>>>>>>>>>' + err.status);
				}
			);
			
		}else{
			 this.errorAlert = true;
			 this.error_message = "Vehicle Already Exist"
		}
		 }  
		
		calculateAmount(){
			this.vehicleForm.controls['vehicleAmount'].setValue(Math.round((this.vehicleForm.get('vehicleDuration').value / 60) * 20) >=20 ? Math.round((this.vehicleForm.get('vehicleDuration').value / 60) * 20) : 20)
		}

			ngOnInit() {
				this.errorAlert = false;
				this.http.getAllParkLots()
					.subscribe
					(
						(data) => {
							console.log("Received" + data);
							this.parkings = data;
						}
					);
			}
}
