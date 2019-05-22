import { Component } from '@angular/core';
import { Flight } from '../entities/flight';
import { Http, Headers, URLSearchParams } from '@angular/http';
import { FlightService } from './flight.service';

@Component({
  selector: 'flight-search',
  templateUrl: './flight-search.component.html',
  //providers: [FlightService]
})
export class FlightSearchComponent {

  origin: string;
  destination: string;
  flightNumber: string;
  departure: string;


  selectedFlight: Flight;

  // any: number, booleans, string, objects

  basket: object = {
    "3": true,
    "4": false,
    "5": true
  };

  //private http: Http;

  constructor(private flightService: FlightService) {
    //this.http = http;
    console.debug('IN flight service!');
  }

  // flights: Array<Flight> = [];

  get flights(): Array<Flight> {
    return this.flightService.flights;
  }

  search(): void {

    this.flightService.find(this.origin, this.destination,this.flightNumber,this.departure);

  }

  select(f: Flight) {
    this.selectedFlight = f;
  }
}
