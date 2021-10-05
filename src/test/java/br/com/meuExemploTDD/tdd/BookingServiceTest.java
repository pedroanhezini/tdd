package br.com.meuExemploTDD.tdd;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import model.Booking;
import repositorio.RepositorioStringBooking;
import service.BookingService;



@RunWith(SpringRunner.class)
public class BookingServiceTest {

	@Autowired
	BookingService bookingService;
	String name = "Pedro Gay";

	
	static class TestConfiguratorBooking {
		
		@Bean
		public BookingService bookingService() {
			return new BookingService();
		}
	}
	
	@MockBean
	RepositorioStringBooking repositorioStringBooking;
	
	@Test
	public void bookingServiceTestDayscalculator() {
	
		
		Integer days = bookingService.daysCalculator(name);
		
		Assertions.assertEquals(days, 10);
	}
	
	@Before
	public void setup() {
		
		LocalDate checkIn = LocalDate.parse("2021-01-10");
		LocalDate checkOut = LocalDate.parse("2021-01-20");
		
		Booking booking = Booking.builder()
		.nameReserve(name)
		.checkIn(checkIn)
		.checkOut(checkOut)
		.numberGuest(2)
		.build();
		
		Mockito.when(repositorioStringBooking.findByReserveName(name)).thenReturn(Optional.of(booking));
		
	}
}
