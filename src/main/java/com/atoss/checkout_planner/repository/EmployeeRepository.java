package com.atoss.checkout_planner.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.atoss.checkout_planner.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}