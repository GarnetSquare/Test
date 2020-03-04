package ru.sergei.komarov.chatbot.server.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import ru.sergei.komarov.chatbot.server.models.Clock;

import java.time.LocalTime;
import java.util.List;

@Component
public interface ClockRepository extends CrudRepository<Clock, Integer> {
    List<Clock> findAll();
}
