package com.kit.cgv.jpa.domain.reservation;

import com.kit.cgv.jpa.domain.reservation.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}
