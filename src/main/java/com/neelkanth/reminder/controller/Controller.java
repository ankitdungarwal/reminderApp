package com.neelkanth.reminder.controller;


import com.neelkanth.reminder.model.Reminder;
import com.neelkanth.reminder.service.ReminderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reminder")
public class Controller {

    @Autowired
    ReminderService reminderService;

    @GetMapping("/today")
    public ResponseEntity<List<Reminder>> fetchTodaysReminder()
    {
        return ResponseEntity.ok(reminderService.fetchDetailsToday());
    }

    @PostMapping(value = "addnew",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Reminder> insertNewReminder(@RequestBody Reminder reminder)
    {
        return ResponseEntity.ok(reminderService.createEntry(reminder));
    }
}
