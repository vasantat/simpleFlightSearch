import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import { Flight } from '../entities/flight';
import { Http, URLSearchParams, Headers } from '@angular/http';

@Injectable()
export class FlightService {

  flights: Flight[] = [];

  constructor(private http: Http) {
    console.debug('Liebesgrüße aus dem Konstruktor!');
  }

  find(origin: string, destination: string, flightNumber: string, departure: string): void {
    let search = new URLSearchParams();
    search.set('origin', origin);
    search.set('destination', destination);
    search.set('flightNumber',flightNumber);
    search.set('departure', departure);

    let headers = new Headers();
    headers.set('Accept', 'application/json');

    //let url = 'http://www.angular.at/api/flight';

    let url = 'http://localhost:8080/UnitedFlightSearch/getFlightDetails';

    this
        .http
        .get(url, { search, headers })
        .map(resp => resp.json())
      .subscribe(
        flights => {
          this.flights = flights;
        },
        err => {
          console.error('Console Error', err);
        }
      )

  }

}
