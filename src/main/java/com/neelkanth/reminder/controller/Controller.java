package com.neelkanth.reminder.controller;


import com.neelkanth.reminder.model.Reminder;
import com.neelkanth.reminder.service.ReminderService;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/reminder")
@Slf4j
public class Controller {

    @Autowired
    ReminderService reminderService;

    @GetMapping("/today")
    public ResponseEntity<List<Reminder>> fetchTodaysReminder()
    {
        log.info("fetching today's {} reminders ",new Date());
        return ResponseEntity.ok(reminderService.fetchDetailsToday());
    }

    @GetMapping("/all")
    public ResponseEntity<List<Reminder>> fetchAllReminders()
    {
        List<Reminder> listOfReminders = reminderService.fetchAllReminders();
        log.info("total reminders {} present",listOfReminders.size());
        return ResponseEntity.ok(listOfReminders);
    }

    @PostMapping(value = "addnew",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Reminder> insertNewReminder(@RequestBody Reminder reminder)
    {
        log.info("insertion of new reminder entry");
        Reminder reminders = reminderService.createEntry(reminder);
        log.info("new reminder id is {}", reminders.getId());
        return ResponseEntity.ok(reminders);
    }
}
