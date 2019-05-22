package com.united.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.united.service.UnitedFlightSearchService;
import com.united.vo.FlightDetailsVO;
import com.united.vo.SearchInputVO;


/**
 * @author Vasanta
 *
 */


@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UnitedHomeController {

	@Autowired
	UnitedFlightSearchService unitedFlightService;

	@RequestMapping(value = "/getFlightDetails", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<FlightDetailsVO> getFlightdetails(@RequestParam("origin") String origin,
			@RequestParam("destination") String destination, @RequestParam("flightNumber") String flightNumber,
			@RequestParam("departure") String departure)
			throws JsonParseException, JsonMappingException, IOException, JSONException, ParseException {
		SearchInputVO searchInputVO = new SearchInputVO();
		searchInputVO.setOrigin(origin);
		searchInputVO.setDeparture(departure);
		searchInputVO.setFlightNumber(flightNumber);
		searchInputVO.setDestination(destination);
		System.out.println(searchInputVO);

		List<FlightDetailsVO> flightDetailsVOList = unitedFlightService.getFlightdetails(
				searchInputVO.getFlightNumber(), searchInputVO.getOrigin(), searchInputVO.getDestination(),
				searchInputVO.getDeparture());

		return flightDetailsVOList;

	}

}
