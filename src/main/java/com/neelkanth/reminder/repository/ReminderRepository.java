package com.neelkanth.reminder.repository;

import com.neelkanth.reminder.model.Reminder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;


@Repository
public interface ReminderRepository extends JpaRepository<Reminder,Long> {

    @Query(value = "select * from Reminder where trigger_date =:date",nativeQuery = true)
    List<Reminder> findbyCreationDate(@Param("date")Date creationDate);
}
