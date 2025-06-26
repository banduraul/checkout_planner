package com.atoss.checkout_planner.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class PlannedShift {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate date;

    @Enumerated(EnumType.STRING)
    private ShiftType shift;

    @ManyToMany
    private List<Employee> employees;

    public PlannedShift() {}

    public PlannedShift(LocalDate date, ShiftType shift, List<Employee> employees) {
        this.date = date;
        this.shift = shift;
        this.employees = employees;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public ShiftType getShift() {
        return shift;
    }

    public void setShift(ShiftType shift) {
        this.shift = shift;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}