package com.atoss.checkout_planner.service;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atoss.checkout_planner.model.Employee;
import com.atoss.checkout_planner.model.PlannedShift;
import com.atoss.checkout_planner.model.ShiftType;
import com.atoss.checkout_planner.model.WishEntry;
import com.atoss.checkout_planner.repository.WishEntryRepository;
import com.atoss.checkout_planner.repository.PlannedShiftRepository;

@Service
public class PlanningService {

    @Autowired
    private WishEntryRepository wishEntryRepository;

    @Autowired
    private PlannedShiftRepository plannedShiftRepository;

    public List<PlannedShift> generatePlanForDate(LocalDate date) {
        List<PlannedShift> result = new ArrayList<>();
        Set<Long> assignedEmployeeIds = new HashSet<>();

        for (ShiftType shift : ShiftType.values()) {
            List<WishEntry> entries = wishEntryRepository.findByDateAndShift(date, shift);
            List<Employee> selected = entries.stream()
                .map(WishEntry::getEmployee)
                .filter(e -> !assignedEmployeeIds.contains(e.getId()))
                .limit(2)
                .collect(Collectors.toList());

            assignedEmployeeIds.addAll(selected.stream().map(Employee::getId).collect(Collectors.toSet()));

            PlannedShift ps = new PlannedShift(date, shift, selected);
            result.add(plannedShiftRepository.save(ps));
        }
        return result;
    }

    public List<PlannedShift> getSchedule(LocalDate date) {
        return plannedShiftRepository.findByDate(date);
    }
}
