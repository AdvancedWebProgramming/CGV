package com.kit.cgv.pbh.repository;

import com.kit.cgv.pbh.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}
