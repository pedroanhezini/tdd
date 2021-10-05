package model;

import java.time.LocalDate;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Booking {

	String nameReserve;
	LocalDate checkIn;
	LocalDate checkOut;
	Integer numberGuest;
}
