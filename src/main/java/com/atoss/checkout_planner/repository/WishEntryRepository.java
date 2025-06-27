package com.atoss.checkout_planner.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.atoss.checkout_planner.model.ShiftType;
import com.atoss.checkout_planner.model.WishEntry;

public interface WishEntryRepository extends JpaRepository<WishEntry, Long> {
    List<WishEntry> findByDateAndShift(LocalDate date, ShiftType shift);
}