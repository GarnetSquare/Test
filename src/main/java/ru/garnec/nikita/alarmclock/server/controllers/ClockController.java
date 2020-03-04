package ru.garnec.nikita.alarmclock.server.controllers;

import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.garnec.nikita.alarmclock.server.services.ClockService;
import ru.garnec.nikita.alarmclock.server.models.Clock;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/clocks")
public class ClockController {

    private final ClockService clockService;
    private static DateTimeFormatter formater = DateTimeFormatter.ofPattern("HH:mm");

    @Autowired
    public ClockController(ClockService clockService) {
        this.clockService = clockService;
    }

    @GetMapping("/get")
    @ResponseBody
    public Map<String, Object> get() {
        return clockToMap(clockService.get());
    }

    @PostMapping("/save")
    @ResponseBody
    public JsonPrimitive saveClock(@RequestBody JsonObject jsonMessage) {
        try {
            clockService.deleteAll();
            Clock clock = parseClockFromJson(jsonMessage);
            clock = clockService.save(clock);
            return new JsonPrimitive(clock.getId());
        } catch (Exception e) {
            e.printStackTrace();
            return new JsonPrimitive("FAIL");
        }
    }

    private Clock parseClockFromJson(JsonObject jsonMessage) {
        Clock clock = new Clock();
        clock.setTime(LocalTime.parse(jsonMessage.get("clock").getAsString(),formater));
        return clock;
    }


    private Map<String, Object> clockToMap(Clock clock) {
        Map<String, Object> map = new HashMap<>();
        map.put("id", clock.getId());
        map.put("time", formater.format(clock.getTime()));
        return map;
    }
}
