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

/**
 * EventService handles the business logic for event-related operations.
 */
@Service
public class EventService {
	
    @Autowired
    private EventRepository eventRepository;
	
    /**
     * Maps AddEventRequest to Event entity for creating or updating an event.
     * 
     * @param request the AddEventRequest object containing event details
     * @param event the Event entity to map to
     * @return the mapped Event entity
     */
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

    /**
     * Adds a new event.
     * 
     * @param request the AddEventRequest object containing new event details
     * @return the added event
     */
    public Event addEvent(AddEventRequest request) {
        Event event = mapRequestToEvent(request, new Event());
        return eventRepository.save(event);
    }

    /**
     * Updates an existing event.
     * 
     * @param request the AddEventRequest object containing updated event details
     * @param eventId the ID of the event to update
     * @return an AddEventResponse containing the updated event details
     */
    public AddEventResponse updateEvent(AddEventRequest request, Long eventId) {
        AddEventResponse response = new AddEventResponse();

        Event existingEvent = eventRepository.findById(eventId).orElseThrow();
        existingEvent = mapRequestToEvent(request, existingEvent);

        Event updatedEvent = eventRepository.save(existingEvent);
        response.setEvent(updatedEvent);
        return response;
    }

    /**
     * Retrieves an event by its ID.
     * 
     * @param eventId the ID of the event to retrieve
     * @return a ViewEventResponse containing event details
     */
    public ViewEventResponse getEventById(Long eventId) {
        Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new RuntimeException("Event not found with ID: " + eventId));
        return mapEventToResponse(event);
    }

    /**
     * Deletes an event by its ID.
     * 
     * @param eventId the ID of the event to delete
     */
    public void deleteEvent(Long eventId) {
        eventRepository.deleteById(eventId);
    }

    /**
     * Counts the total number of events.
     * 
     * @return the total number of events
     */
    public long countEvents() {
        return eventRepository.count();
    }

    /**
     * Retrieves all events based on request parameters.
     * 
     * @param request the GetAllEventRequest object containing filter criteria
     * @return a list of events matching the filter criteria
     */
    public List<Event> getAllEvents(GetAllEventRequest request) {
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
            events = events.stream()
                    .filter(e -> request.getBusinessId().equals(e.getBusinessId()))
                    .collect(Collectors.toList());
        }

        return events;
    }

    /**
     * Maps an Event entity to a ViewEventResponse object.
     * 
     * @param event the Event entity to map
     * @return a ViewEventResponse containing event details
     */
    private ViewEventResponse mapEventToResponse(Event event) {
        return ViewEventResponse.builder()
                .event(event)
                .build();
    }

    /**
     * Retrieves events based on foreign ID filter criteria.
     * 
     * @param request the GetEventByForeignIdRequest object containing filter criteria
     * @return a GetAllEventResponse containing the list of events
     */
    public GetAllEventResponse getEventByForeignId(GetEventByForeignIdRequest request) {
        List<Event> events = eventRepository.findAll();

        // Apply filters based on request parameters
        if (request.getBusinessId() != null) {
            events = events.stream()
                    .filter(event -> request.getBusinessId().equals(event.getBusinessId()))
                    .collect(Collectors.toList());
        }

        // Map filtered events to response objects
        List<ViewEventResponse> eventResponses = events.stream()
                .map(this::mapEventToResponse)
                .collect(Collectors.toList());

        // Create and return response object
        GetAllEventResponse response = new GetAllEventResponse();
        response.setEvent(eventResponses);
        return response;
    }

    /**
     * Counts the number of events by business IDs.
     * 
     * @param businessIds the list of business IDs
     * @return the number of events associated with the specified business IDs
     */
    public long countEventsByBid(List<Long> businessIds) {
        return eventRepository.countByBusinessIds(businessIds);
    }
}
