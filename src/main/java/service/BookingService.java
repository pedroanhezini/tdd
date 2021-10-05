package service;

import java.time.Period;
import java.util.Optional;

import org.springframework.stereotype.Service;

import model.Booking;
import repositorio.RepositorioStringBooking;

@Service
public class BookingService {
	
	
	RepositorioStringBooking repositorioStringBooking;
	
	public Integer daysCalculator(String name) {
	
		Optional<Booking> list =  repositorioStringBooking.findByReserveName(name);
		return Period.between(list.get().getCheckIn(), list.get().getCheckOut()).getDays();
	}

	
}
