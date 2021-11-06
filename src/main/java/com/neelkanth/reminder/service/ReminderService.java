package com.neelkanth.reminder.service;

import com.neelkanth.reminder.model.Reminder;
import com.neelkanth.reminder.repository.ReminderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ReminderService {

    @Autowired
    private ReminderRepository reminderRepository;

    public List<Reminder> fetchDetailsToday()
    {
        Date date = new Date();
        Optional<List<Reminder>> object = Optional.of(reminderRepository.findbyCreationDate(date));
        return object.orElse(List.of(new Reminder()));
    }

    public Reminder createEntry(Reminder remind)
    {
        Reminder response = reminderRepository.save(remind);
        Optional<Reminder> hold = Optional.of(response);
        return hold.orElse(new Reminder());
    }
}
