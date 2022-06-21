package com.example.firstProject.util;

import com.example.firstProject.Data.Room;
import com.example.firstProject.Data.RoomRepository;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class AppStartupEvent implements ApplicationListener<ApplicationReadyEvent> {
    private final RoomRepository roomRepository;
    private final DateUtils dateUtils;

    public AppStartupEvent(RoomRepository roomRepository, DateUtils dateUtils) {
        this.roomRepository = roomRepository;
        this.dateUtils = dateUtils;
    }

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        Iterable<Room> rooms = this.roomRepository.findAll();
        rooms.forEach(System.out::println);
    }
}
