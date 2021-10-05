package repositorio;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Booking;

public interface RepositorioStringBooking extends JpaRepository<Booking, String> {

	Optional<Booking> findByReserveName(String name);
}
