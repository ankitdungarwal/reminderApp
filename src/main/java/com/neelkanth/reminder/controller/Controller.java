package com.neelkanth.reminder.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reminder")
public class Controller {

    @GetMapping("/todaysreminder")
    public ResponseEntity<String> fetchTodaysReminder()
    {
        return ResponseEntity.ok("test");
    }
}
