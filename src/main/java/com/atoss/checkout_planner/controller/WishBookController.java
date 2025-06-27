package com.atoss.checkout_planner.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.atoss.checkout_planner.model.WishEntry;
import com.atoss.checkout_planner.repository.WishEntryRepository;

@RestController
@RequestMapping("/wishbook")
public class WishBookController {
    
    @Autowired
    private WishEntryRepository wishEntryRepository;

    @PostMapping
    public WishEntry submitWish(@RequestBody WishEntry wish) {
        return wishEntryRepository.save(wish);
    }

    @GetMapping
    public List<WishEntry> getAllWishes() {
        return wishEntryRepository.findAll();
    }
}