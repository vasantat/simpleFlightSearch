/**
 * 
 */
package com.united.service;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.united.vo.FlightDetailsVO;

/**
 * @author Vasanta
 *
 */
@Service
public class UnitedFlightServiceImpl implements UnitedFlightSearchService {


	static String json = "{\"flightDetails\":[ {\r\n" + "    \"flightNumber\": \"2005\",\r\n"
			+ "    \"carrier\": \"UA\",\r\n" + "    \"origin\": \"IAH\",\r\n"
			+ "    \"departure\": \"2018-01-31T05:10:00\",\r\n" + "    \"destination\": \"ORD\",\r\n"
			+ "    \"arrival\": \"2018-01-31T07:57:00\",\r\n" + "    \"aircraft\": \"Airbus A320\",\r\n"
			+ "    \"distance\": 925,\r\n" + "    \"travelTime\": \"02:47\",\r\n"
			+ "    \"status\": \"Arrived at Gate\"\r\n" + "\r\n" + "  },\r\n" + "  {\r\n"
			+ "    \"flightNumber\": \"0638\",\r\n" + "    \"carrier\": \"UA\",\r\n" + "    \"origin\": \"IAH\",\r\n"
			+ "    \"departure\": \"2018-01-31T07:45:00\",\r\n" + "    \"destination\": \"ORD\",\r\n"
			+ "    \"arrival\": \"2018-01-31T10:18:00\",\r\n" + "    \"aircraft\": \"Boeing 737-900\",\r\n"
			+ "    \"distance\": 925,\r\n" + "    \"travelTime\": \"02:33\",\r\n"
			+ "    \"status\": \"Arrived at Gate\"\r\n" + "  },\r\n" + "  {\r\n" + "    \"flightNumber\": \"1160\",\r\n"
			+ "    \"carrier\": \"UA\",\r\n" + "    \"origin\": \"IAH\",\r\n"
			+ "    \"departure\": \"2018-01-31T12:05:00\",\r\n" + "    \"destination\": \"ORD\",\r\n"
			+ "    \"arrival\": \"2018-01-31T14:38:00\",\r\n" + "    \"aircraft\": \"Boeing 737-800\",\r\n"
			+ "    \"distance\": 925,\r\n" + "    \"travelTime\": \"02:41\",\r\n"
			+ "    \"status\": \"Arrived at Gate\"\r\n" + "  },\r\n" + "  {\r\n" + "    \"flightNumber\": \"1256\",\r\n"
			+ "    \"carrier\": \"UA\",\r\n" + "    \"origin\": \"IAH\",\r\n"
			+ "    \"departure\": \"2018-01-31T14:22:00\",\r\n" + "    \"destination\": \"ORD\",\r\n"
			+ "    \"arrival\": \"2018-01-31T17:01:00\",\r\n" + "    \"aircraft\": \"Boeing 737-800\",\r\n"
			+ "    \"distance\": 925,\r\n" + "    \"travelTime\": \"02:41\",\r\n" + "    \"status\": \"On Time\"\r\n"
			+ "  },\r\n" + "  {\r\n" + "    \"flightNumber\": \"2153\",\r\n" + "    \"carrier\": \"UA\",\r\n"
			+ "    \"origin\": \"IAH\",\r\n" + "    \"departure\": \"2018-01-31T16:24:00\",\r\n"
			+ "    \"destination\": \"ORD\",\r\n" + "    \"arrival\": \"2018-01-31T19:27:00\",\r\n"
			+ "    \"aircraft\": \"Boeing 737-800\",\r\n" + "    \"distance\": 925,\r\n"
			+ "    \"travelTime\": \"02:47\",\r\n" + "    \"status\": \"On Time\"\r\n" + "  },\r\n" + "  {\r\n"
			+ "    \"flightNumber\": \"2155\",\r\n" + "    \"carrier\": \"UA\",\r\n" + "    \"origin\": \"IAH\",\r\n"
			+ "    \"departure\": \"2018-01-31T18:10:00\",\r\n" + "    \"destination\": \"ORD\",\r\n"
			+ "    \"arrival\": \"2018-01-31T20:49:00\",\r\n" + "    \"aircraft\": \"Boeing 737-900\",\r\n"
			+ "    \"distance\": 925,\r\n" + "    \"travelTime\": \"02:39\",\r\n" + "    \"status\": \"On Time\"\r\n"
			+ "  },\r\n" + "  {\r\n" + "    \"flightNumber\": \"2131\",\r\n" + "    \"carrier\": \"UA\",\r\n"
			+ "    \"origin\": \"IAH\",\r\n" + "    \"departure\": \"2018-01-31T19:49:00\",\r\n"
			+ "    \"destination\": \"ORD\",\r\n" + "    \"arrival\": \"2018-01-31T22:00:00\",\r\n"
			+ "    \"aircraft\": \"Boeing 737-900\",\r\n" + "    \"distance\": 925,\r\n"
			+ "    \"travelTime\": \"02:31\",\r\n" + "    \"status\": \"On Time\"\r\n" + "  },\r\n" + "  {\r\n"
			+ "    \"flightNumber\": \"2043\",\r\n" + "    \"carrier\": \"UA\",\r\n" + "    \"origin\": \"ORD\",\r\n"
			+ "    \"departure\": \"2018-01-31T06:08:00\",\r\n" + "    \"destination\": \"IAH\",\r\n"
			+ "    \"arrival\": \"2018-01-31T08:42:00\",\r\n" + "    \"aircraft\": \"Boeing 737-800\",\r\n"
			+ "    \"distance\": 925,\r\n" + "    \"travelTime\": \"02:34\",\r\n"
			+ "    \"status\": \"Arrived at Gate\"\r\n" + "  },\r\n" + "  {\r\n" + "    \"flightNumber\": \"0748\",\r\n"
			+ "    \"carrier\": \"UA\",\r\n" + "    \"origin\": \"ORD\",\r\n"
			+ "    \"departure\": \"2018-01-31T08:10:00\",\r\n" + "    \"destination\": \"IAH\",\r\n"
			+ "    \"arrival\": \"2018-01-31T10:44:00\",\r\n" + "    \"aircraft\": \"Boeing 737-900\",\r\n"
			+ "    \"distance\": 925,\r\n" + "    \"travelTime\": \"02:34\",\r\n"
			+ "    \"status\": \"Arrived at Gate\"\r\n" + "  },\r\n" + "  {\r\n" + "    \"flightNumber\": \"2166\",\r\n"
			+ "    \"carrier\": \"UA\",\r\n" + "    \"origin\": \"ORD\",\r\n"
			+ "    \"departure\": \"2018-01-31T10:15:00\",\r\n" + "    \"destination\": \"IAH\",\r\n"
			+ "    \"arrival\": \"2018-01-31T12:53:00\",\r\n" + "    \"aircraft\": \"Airbus A320\",\r\n"
			+ "    \"distance\": 925,\r\n" + "    \"travelTime\": \"02:34\",\r\n"
			+ "    \"status\": \"Arrived at Gate\"\r\n" + "  },\r\n" + "  {\r\n" + "    \"flightNumber\": \"2171\",\r\n"
			+ "    \"carrier\": \"UA\",\r\n" + "    \"origin\": \"ORD\",\r\n"
			+ "    \"departure\": \"2018-01-31T12:45:00\",\r\n" + "    \"destination\": \"IAH\",\r\n"
			+ "    \"arrival\": \"2018-01-31T15:34:00\",\r\n" + "    \"aircraft\": \"Airbus A320\",\r\n"
			+ "    \"distance\": 925,\r\n" + "    \"travelTime\": \"02:39\",\r\n" + "    \"status\": \"On Time\"\r\n"
			+ "  },\r\n" + "  {\r\n" + "    \"flightNumber\": \"1128\",\r\n" + "    \"carrier\": \"UA\",\r\n"
			+ "    \"origin\": \"ORD\",\r\n" + "    \"departure\": \"2018-01-31T14:05:00\",\r\n"
			+ "    \"destination\": \"IAH\",\r\n" + "    \"arrival\": \"2018-01-31T16:52:00\",\r\n"
			+ "    \"aircraft\": \"Boeing 737-800\",\r\n" + "    \"distance\": 925,\r\n"
			+ "    \"travelTime\": \"02:41\",\r\n" + "    \"status\": \"On Time\"\r\n" + "  }\r\n" + "\r\n" + "]}";

	List<FlightDetailsVO> jsonToFlightDetailsObject() throws JSONException, ParseException {
		JSONObject obj = new JSONObject(json);

		JSONArray arr = obj.getJSONArray("flightDetails");

		List<FlightDetailsVO> flightDetailsVOList = new ArrayList<FlightDetailsVO>();

		for (int i = 0; i < arr.length(); i++) {

			FlightDetailsVO flightDetailsVO = new FlightDetailsVO();

			flightDetailsVO.setAircraft(arr.getJSONObject(i).getString("aircraft"));
			flightDetailsVO.setFlightNumber(arr.getJSONObject(i).getString("flightNumber"));
			flightDetailsVO.setOrigin(arr.getJSONObject(i).getString("origin"));
			flightDetailsVO.setArrival(arr.getJSONObject(i).getString("arrival"));
			flightDetailsVO.setCarrier(arr.getJSONObject(i).getString("carrier"));
			flightDetailsVO.setDeparture(arr.getJSONObject(i).getString("departure"));

			flightDetailsVO.setDestination(arr.getJSONObject(i).getString("destination"));
			flightDetailsVO.setStatus(arr.getJSONObject(i).getString("status"));
			flightDetailsVO
					.setTravelTime(new SimpleDateFormat("hh:mm").parse(arr.getJSONObject(i).getString("travelTime")));
			flightDetailsVO.setDistance(arr.getJSONObject(i).getInt("distance"));
			flightDetailsVOList.add(flightDetailsVO);
		}

		return flightDetailsVOList;
	}

	public List<FlightDetailsVO> getFlightdetails(String flightNumber, String origin, String destination,
			String journeyDate)
			throws JsonParseException, JsonMappingException, IOException, JSONException, ParseException {
		// TODO Auto-generated method stub

		List<FlightDetailsVO> flightDetailsVOList = jsonToFlightDetailsObject();

		return searchFlightDetails(flightDetailsVOList, flightNumber, origin, destination, journeyDate);
	}

	public List<FlightDetailsVO> searchFlightDetails(List<FlightDetailsVO> flightDetailsVOList, String flightNumber,
			String origin, String destination, String journeyDate) throws ParseException {
		Iterator<FlightDetailsVO> listItr = flightDetailsVOList.iterator();

		List<FlightDetailsVO> filteredFlightDetailsVOList = new ArrayList<FlightDetailsVO>();

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		Date journeyDateInput = sdf.parse(journeyDate);

		Date journeyDateFromJSON = null;

		while (listItr.hasNext()) {

			FlightDetailsVO flightDetailsVO = new FlightDetailsVO();

			flightDetailsVO = listItr.next();

			journeyDateFromJSON = sdf.parse(flightDetailsVO.getDeparture());

			if (((flightDetailsVO.getFlightNumber() == flightNumber)
					|| (flightDetailsVO.getOrigin().equalsIgnoreCase(origin)
							&& flightDetailsVO.getDestination().equalsIgnoreCase(destination)))
					&& (journeyDateFromJSON.compareTo(journeyDateInput) == 0)) {
				filteredFlightDetailsVOList.add(flightDetailsVO);
			}

		}
		return filteredFlightDetailsVOList;
	}

	{

	}
}
