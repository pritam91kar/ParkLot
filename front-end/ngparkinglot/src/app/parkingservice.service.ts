import { Injectable } from '@angular/core';
import { HttpClient} from '@angular/common/http';
import { Observable } from 'rxjs';
import { ParkingsmoduleModule } from './parkingsmodule.module';

@Injectable({
  providedIn: 'root'
})
export class ParkingserviceService {

  constructor(private http: HttpClient) { }

  getAllParkLots(): Observable<any> {
        return this.http.get('http://localhost:8092/api/view');
	}
  addParkLot(parkingLot: ParkingsmoduleModule): Observable<any> {
        return this.http.post('http://localhost:8092/api/add',parkingLot);
	}
}
