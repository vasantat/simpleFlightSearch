/**
 * 
 */
package com.united.service;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import org.json.JSONException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.united.vo.FlightDetailsVO;

/**
 * @author Vasanta
 *
 */
public interface UnitedFlightSearchService {

	List<FlightDetailsVO> getFlightdetails(String flightNumber,String origin,String destination,String journeyDate) throws JsonParseException, JsonMappingException, IOException, JSONException, ParseException;
}
