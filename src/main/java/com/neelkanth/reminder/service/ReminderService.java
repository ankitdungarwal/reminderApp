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

    public List<Reminder> fetchAllReminders()
    {
        Optional<List<Reminder>> objects = Optional.of(reminderRepository.findAll());
        return objects.orElse(List.of(new Reminder()));
    }

    public Reminder createEntry(Reminder remind)
    {
        Reminder response = reminderRepository.save(remind);
        Optional<Reminder> hold = Optional.of(response);
        return hold.orElse(new Reminder());
    }

    public Reminder removeEntry(Long id)
    {
        Reminder response = findById(id);
        reminderRepository.delete(response);
        return response;
    }

    public Reminder updateById(Long id, Reminder object)
    {
        Reminder response = findById(id);
        response.setUpdateDate(object.getUpdateDate());
        response.setName(object.getName());
        response.setTriggerDate(object.getTriggerDate());
        return reminderRepository.save(response);
    }

    private Reminder findById(Long id)
    {
        return reminderRepository.getById(id);
    }
}
