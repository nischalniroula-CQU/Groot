package com.fyp.groot.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fyp.groot.entity.Event;
import com.fyp.groot.model.GetAllEventRequest;
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
    
    public long countEvents() {
        return eventRepository.count();
    }
    
    
    public List<Event> getAllEvents(GetAllEventRequest request) {
		// Fetch all businesses from the repository
		List<Event> events = eventRepository.findAll();

		// Apply filters based on request parameters
		if (request.getEventName() != null) {
			events = events.stream()
					.filter(e -> request.getEventName().equalsIgnoreCase(e.getEventName()))
					.collect(Collectors.toList());
		}

		if (request.getLocation() != null) {
			events = events.stream()
					.filter(e -> request.getLocation().equalsIgnoreCase(e.getLocation()))
					.collect(Collectors.toList());
		}

		if (request.getBusinessId() != null) {
			events = events.stream().filter(e -> request.getBusinessId().equals(e.getBusinessId()))
					.collect(Collectors.toList());
		}

		return events;
	}

}
