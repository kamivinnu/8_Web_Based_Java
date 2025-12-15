package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.entity.ServiceBooking;

import java.time.LocalDate;
import java.util.List;

public interface ServiceBookingRepository extends JpaRepository<ServiceBooking, Long> {

    List<ServiceBooking> findByServiceType(String serviceType);

    List<ServiceBooking> findByServiceDateAfter(LocalDate date);
}
