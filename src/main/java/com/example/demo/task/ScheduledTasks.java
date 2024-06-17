package com.example.demo.task;


import com.example.demo.Service.MouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


@Component
public class ScheduledTasks {

    private final MouseService mouseService;

    @Autowired
    public ScheduledTasks(MouseService mouseService) {
        this.mouseService = mouseService;
    }

    @Scheduled(fixedRate = 120000) // 120000 milliseconds = 2 minutes
    public void scheduleMouseMovement() {
        try {
            mouseService.clickAndTypeInNotepad();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}