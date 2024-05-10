package com.fyp.groot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fyp.groot.entity.Event;
import com.fyp.groot.repository.EventRepository;

@Service
public class EventService {
	
	@Autowired
    private EventRepository eventRepository;

    public Event addEvent(Event event) {
        // Add business logic as required (validation, etc.)
        return eventRepository.save(event);
    }
    
    public Optional<Event> getEventById(Long eventId) {
        return eventRepository.findById(eventId);
    }
    
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }
    
    public long countEvents() {
        return eventRepository.count();
    }

}
