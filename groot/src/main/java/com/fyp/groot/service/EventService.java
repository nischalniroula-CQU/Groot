package com.fyp.groot.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fyp.groot.entity.Event;
import com.fyp.groot.model.AddEventRequest;
import com.fyp.groot.model.AddEventResponse;
import com.fyp.groot.model.GetAllEventRequest;
import com.fyp.groot.model.GetAllEventResponse;
import com.fyp.groot.model.GetEventByForeignIdRequest;
import com.fyp.groot.model.ViewEventResponse;
import com.fyp.groot.repository.EventRepository;

@Service
public class EventService {
	
	@Autowired
    private EventRepository eventRepository;
	
	
	private Event mapRequestToEvent(AddEventRequest request, Event event) {

		event = Event.builder()
				.eventName(request.getEventName())
				.location(request.getLocation())
				.maxSeat(request.getMaxSeat())
				.priceRange(request.getPriceRange())
				.businessId(request.getBusinessID())
				.build();

		return event;
	}

    public Event addEvent(AddEventRequest request) {
        // Add business logic as required (validation, etc.)
    	Event event = mapRequestToEvent(request, new Event());
        return eventRepository.save(event);
    }
    
    public AddEventResponse updateEvent(AddEventRequest request, Long eventId) {
    	AddEventResponse response = new AddEventResponse();

    	Event existingEvent = eventRepository.findById(eventId).orElseThrow();
		existingEvent = mapRequestToEvent(request, existingEvent);

		Event updatedEvent = eventRepository.save(existingEvent);
		response.setEvent(updatedEvent);
		return response;
	}
    
    public ViewEventResponse getEventById(Long eventId) {
        //return eventRepository.findById(eventId);
        
        Event event = eventRepository.findById(eventId).orElseThrow(() -> new RuntimeException("Event not found with ID: " + eventId));

		return mapEventToResponse(event);
    }
    
    public void deleteEvent(Long eventId) {
    	eventRepository.deleteById(eventId);
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
    
    
    private ViewEventResponse mapEventToResponse(Event event) {
		return ViewEventResponse.builder().event(event)
				.build();
	}
    
    
    public GetAllEventResponse getEventByForeignId(GetEventByForeignIdRequest request) {
		// Fetch all businesses from the repository
		List<Event> events = eventRepository.findAll();

		// Apply filters based on request parameters

		if (request.getBusinessId() != null) {
			events = events.stream().filter(event -> request.getBusinessId().equals(event.getBusinessId())).collect(Collectors.toList());
		}


		// Map filtered businesses to response objects
		List<ViewEventResponse> eventResponses = events.stream().map(this::mapEventToResponse).collect(Collectors.toList());

		// Create and return response object
		GetAllEventResponse response = new GetAllEventResponse();
		response.setEvent(eventResponses);
		return response;
	}

}
