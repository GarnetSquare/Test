package ru.garnec.nikita.alarmclock.server.models;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Objects;

@Entity
@Table(name = "clocks")
public class Clock {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "clock_id_seq")
    private int id;
    private LocalTime time;

    public Clock() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }
    /*    @Override
    public String toString() {
        return "Clock{" +
                "id=" + id +
                ", message='" + message + '\'' +
                ", user=" + user +
                ", date=" + date +
                '}';
    }*/

/*    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Clock message1 = (Clock) o;
        return id == message1.id &&
                Objects.equals(message, message1.message) &&
                Objects.equals(user, message1.user) &&
                Objects.equals(date, message1.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, message, user, date);
    }*/
}
