package com.atoss.checkout_planner.controller;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.atoss.checkout_planner.model.PlannedShift;
import com.atoss.checkout_planner.service.PlanningService;

@RestController
@RequestMapping("/plan")
public class PlanningController {
    
    @Autowired
    private PlanningService planningService;

    @PostMapping("/{date}")
    public ResponseEntity<?> planShifts(@PathVariable String date,
        @RequestHeader(value = "X-User-Role", defaultValue = "employee") String role) {
        
        if (!"admin".equalsIgnoreCase(role)) {
            Map<String, String> error = new HashMap<>();
            error.put("error", "Access denied: only admins can generate plans.");
            return ResponseEntity.status(403).body(error);
        }
        
        List<PlannedShift> result = planningService.generatePlanForDate(LocalDate.parse(date));
        return ResponseEntity.ok(result);
    }
}