package com.example.HabbitTracker.db.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.*;

import java.time.Duration;
import java.time.LocalTime;

import static jakarta.persistence.CascadeType.*;

@Entity
@Table(name = "reminders")
@Setter
@Getter
@NoArgsConstructor
public class Reminder {

    @Id
    @GeneratedValue(generator = "reminder_gen", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "reminder_gen", sequenceName = "reminder_seq", allocationSize = 1)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "habitId", referencedColumnName = "id")
    private Habit habit;

    private LocalTime localTime;

    private String message;


    @ManyToOne(cascade = {DETACH, MERGE, REFRESH})
    private Frequency frequency;

}
