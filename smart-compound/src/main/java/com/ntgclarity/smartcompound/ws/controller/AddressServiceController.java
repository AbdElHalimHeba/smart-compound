package com.ntgclarity.smartcompound.ws.controller;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.codehaus.jackson.map.ObjectMapper;
import org.jboss.resteasy.annotations.providers.jackson.Formatted;

import com.ntgclarity.smartcompound.addressservice.helperClasses.GoogleResponse;
import com.ntgclarity.smartcompound.addressservice.helperClasses.Result;

/**Heba's work**/

@Path("/addressServiceController")
public class AddressServiceController extends AbstractController {


	/*
	 * Geocode request URL. Here see we are passing "json" it means we will get
	 * the output in JSON format. For XML output URL will be
	 * "http://maps.googleapis.com/maps/api/geocode/xml";
	 */

	/*
	 * Create an java.net.URL object by passing the request URL in constructor.
	 * Here you can see I am converting the fullAddress String in UTF-8 format.
	 * You will get Exception if you don't convert your address in UTF-8 format.
	 * In parameter we also need to pass "sensor" parameter. This indicates
	 * whether or not the geocoding request comes from a device with a location
	 * sensor.
	 */

	private static final String URL = "http://maps.googleapis.com/maps/api/geocode/json";

	public GoogleResponse convertFromLatLong(String latString, String longString)
			throws IOException {

		String latlongString = latString+","+longString;
		URL url = new URL(URL + "?latlng="
				+ URLEncoder.encode(latlongString, "UTF-8") + "&sensor=false");

		// Open the Connection
		URLConnection connection = url.openConnection();

		InputStream inputStream = connection.getInputStream();
		ObjectMapper mapper = new ObjectMapper();
		GoogleResponse response = (GoogleResponse) mapper.readValue(
				inputStream, GoogleResponse.class);
		inputStream.close();
		return response;

	}

	public GoogleResponse getRestfulLocation(String latString, String longString)
			throws IOException {

		GoogleResponse googleResponse = new AddressServiceController()
				.convertFromLatLong(latString, longString);

		if (googleResponse.getStatus().equals("OK")) {
			System.out.println("Address is :" + returnAddress(googleResponse));
		} else {
			System.out.println(googleResponse.getStatus());
		}

		return googleResponse;
	}

	public String returnAddress(GoogleResponse googleResponse) {

		Result result[] = googleResponse.getResults();
		return result[0].getFormatted_address();
	}

	@GET
	@Path("/print/{latString}/{longString}")
	@Produces("application/json")
	@Formatted
	public Response addressDetailPrint(
			@PathParam("latString") String latString, @PathParam("longString")String longString) {
		GoogleResponse googleResponse;
		try {
			googleResponse = getRestfulLocation(latString, longString);
			return Response.ok(returnAddress(googleResponse)).build();
		} catch (IOException e) {
			Logger.getLogger(AddressServiceController.class.getName()).log(Level.SEVERE,
					null, e);
		}
		return null;
	}
}