package com.neelkanth.reminder.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/reminder")
public class Controller {

    @GetMapping("/today")
    public ResponseEntity<String> fetchTodaysReminder()
    {
        return ResponseEntity.ok(new Date().toString());
    }
}
