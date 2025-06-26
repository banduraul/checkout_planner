package com.atoss.checkout_planner.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class WishEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Employee employee;

    private LocalDate date;

    @Enumerated(EnumType.STRING)
    private ShiftType shift;

    public WishEntry() {}

    public WishEntry(Employee employee, LocalDate date, ShiftType shift) {
        this.employee = employee;
        this.date = date;
        this.shift = shift;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
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
}