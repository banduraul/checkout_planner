package com.atoss.checkout_planner.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.atoss.checkout_planner.model.PlannedShift;
import com.atoss.checkout_planner.service.PlanningService;

@RestController
@RequestMapping("/schedule")
public class ScheduleController {
    
    @Autowired
    private PlanningService planningService;

    @GetMapping("/{date}")
    public List<PlannedShift> getSchedule(@PathVariable String date) {
        return planningService.getSchedule(LocalDate.parse(date));
    }
}