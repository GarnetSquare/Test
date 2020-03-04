package ru.sergei.komarov.chatbot.server.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.sergei.komarov.chatbot.server.models.Clock;
import ru.sergei.komarov.chatbot.server.repositories.ClockRepository;

import java.util.List;

@Service
public class ClockService {

    private final ClockRepository clockRepository;

    @Autowired
    public ClockService(ClockRepository clockRepository) {
        this.clockRepository = clockRepository;
    }

    public Clock get() {
        List<Clock> list = clockRepository.findAll();
        if (!list.isEmpty()) {
            return clockRepository.findAll().get(0);
        }
        return null;
    }

    public Clock save(Clock clock) {
        return clockRepository.save(clock);
    }

    public void deleteAll() {
        clockRepository.deleteAll();
    }
}
