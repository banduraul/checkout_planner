package com.atoss.checkout_planner.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.atoss.checkout_planner.model.PlannedShift;

public interface PlannedShiftRepository extends JpaRepository<PlannedShift, Long> {
    List<PlannedShift> findByDate(LocalDate date);
}
