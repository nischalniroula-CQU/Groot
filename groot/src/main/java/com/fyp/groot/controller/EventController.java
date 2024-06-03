package com.fyp.groot.controller;

import com.fyp.groot.entity.Event;
import com.fyp.groot.model.AddEventRequest;
import com.fyp.groot.model.AddEventResponse;
import com.fyp.groot.model.GetAllEventRequest;
import com.fyp.groot.model.GetAllEventResponse;
import com.fyp.groot.model.GetEventByForeignIdRequest;
import com.fyp.groot.model.ViewEventResponse;
import com.fyp.groot.service.BusinessService;
import com.fyp.groot.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * EventController handles HTTP requests for event-related operations.
 */
@RestController
@RequestMapping("/api/events")
public class EventController {

    private EventService eventService;
    private BusinessService businessService;

    @Autowired
    public EventController(EventService eventService, BusinessService businessService) {
        this.eventService = eventService;
        this.businessService = businessService;
    }

    /**
     * Maps an Event object to a ViewEventResponse object.
     * 
     * @param event the Event object to map
     * @return a ViewEventResponse object
     */
    private ViewEventResponse mapEventToViewEventResponse(Event event) {
        ViewEventResponse viewEventResponse = new ViewEventResponse();
        viewEventResponse.setEvent(event);
        return viewEventResponse;
    }

    /**
     * Handles POST requests to get all events.
     * 
     * @param request the request body containing criteria to view multiple events
     * @return a ResponseEntity containing the response with the list of events
     */
    @PostMapping("/getAll")
    public ResponseEntity<GetAllEventResponse> getAllEvents(@RequestBody GetAllEventRequest request) {
        List<Event> events = eventService.getAllEvents(request);
        
        // Map Event objects to ViewEventResponse objects
        List<ViewEventResponse> eventResponses = events.stream()
                .map(this::mapEventToViewEventResponse)
                .collect(Collectors.toList());
        
        GetAllEventResponse response = new GetAllEventResponse();
        response.setEvent(eventResponses);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /**
     * Handles GET requests to get an event by its ID.
     * 
     * @param eventid the ID of the event to retrieve
     * @return a ResponseEntity containing the event details
     */
    @GetMapping("/getbyid")
    public ResponseEntity<ViewEventResponse> getEventById(@RequestParam Long eventid) {
        ViewEventResponse response = eventService.getEventById(eventid);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /**
     * Handles POST requests to add a new event.
     * 
     * @param request the request body containing the new event details
     * @return a ResponseEntity containing the added event
     */
    @PostMapping("/add")
    public ResponseEntity<AddEventResponse> addEvent(@RequestBody AddEventRequest request) {
        AddEventResponse response = new AddEventResponse();
        response.setEvent(eventService.addEvent(request));
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    /**
     * Handles PUT requests to update an event.
     * 
     * @param eventId the ID of the event to update
     * @param request the request body containing the updated event details
     * @return a ResponseEntity containing the updated event
     */
    @PutMapping("/update/{id}")
    public ResponseEntity<AddEventResponse> updateEvent(@PathVariable("id") Long eventId, @RequestBody AddEventRequest request) {
        AddEventResponse response = eventService.updateEvent(request, eventId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /**
     * Handles DELETE requests to delete an event by its ID.
     * 
     * @param eventId the ID of the event to delete
     * @return a ResponseEntity with HTTP status OK
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteEvent(@PathVariable("id") Long eventId) {
        eventService.deleteEvent(eventId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Handles POST requests to get events by filter criteria.
     * 
     * @param request the request body containing filter criteria
     * @return a ResponseEntity containing the response with the filtered events
     */
    @PostMapping("/getbyfilter")
    public ResponseEntity<GetAllEventResponse> getEventByForeignId(@RequestBody GetEventByForeignIdRequest request) {
        GetAllEventResponse response = eventService.getEventByForeignId(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
