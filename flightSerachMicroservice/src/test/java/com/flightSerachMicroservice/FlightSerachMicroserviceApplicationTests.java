package com.flightSerachMicroservice;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.flightSerachMicroservice.SearchRepositary.flightRepositary;
import com.flightSerachMicroservice.SearchResource.SearchController;
import com.flightSerachMicroservice.mongoDB.model.flights;

import java.util.stream.Stream;
import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class FlightSerachMicroserviceApplicationTests {

	@Autowired
	private SearchController flightController;
	
	@MockBean
	private flightRepositary flightRepo;

	@Test
	public void getTestdone() {
		when(flightRepo.findAll()).thenReturn(Stream.of(new flights("111","AirIndia","Mumbai","Delhi",20005,"2021-10-09"), 
						new flights("110","Indian Airlines","Mumbai","Kerala",60,"2021-11-08"))
				.collect(Collectors.toList()));
		assertEquals(2, flightController.getFlights().size());
	}

	@Test
	public void getFlightTest() {
		String from = "Pune";
		String to = "Hyderabad";
		String date = "2021-10-02";
		when(flightController.getdetails(from,to,date))
		.thenReturn(Stream.of(new flights("111","AirIndia","Mumbai","Delhi",20005,"2021-10-09"))
				.collect(Collectors.toList()));
		assertEquals(1, flightController.getdetails(from,to,date).size());
	}
	
	@Test
	public void deleteTest()
	{
		flightRepo.deleteById("110");
		assertThat(flightRepo.existsById("110")).isFalse();
		
	}

}



