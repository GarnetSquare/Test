package ru.garnec.nikita.alarmclock.server.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import ru.garnec.nikita.alarmclock.server.models.Clock;

import java.util.List;

@Component
public interface ClockRepository extends CrudRepository<Clock, Integer> {
    List<Clock> findAll();
}
