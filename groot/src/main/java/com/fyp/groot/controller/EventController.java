package com.fyp.groot.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fyp.groot.entity.Business;
import com.fyp.groot.entity.Event;
import com.fyp.groot.model.AddEventRequest;
import com.fyp.groot.model.AddEventResponse;
import com.fyp.groot.model.ViewEventResponse;
import com.fyp.groot.service.BusinessService;
import com.fyp.groot.service.EventService;

@RestController
@RequestMapping("/api/events")
public class EventController {
	
	//@Autowired
    private EventService eventService;
	private BusinessService businessService;
	
	@Autowired
    public EventController(EventService eventService, BusinessService businessService) {
        this.eventService = eventService;
        this.businessService = businessService;
    }
	
	
	@PostMapping("/addEvent")
    public ResponseEntity<AddEventResponse> addEvent(@RequestBody AddEventRequest request) {
		
		// Retrieve the business entity from the database based on businessId
        Business business = businessService.findById(request.getBusinessID());
        
     // Check if business exists
        if (business == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        
        Event event = new Event();
        event.setEventName(request.getEventName());
        event.setLocation(request.getLocation());
        event.setPriceRange(request.getPriceRange());
        event.setMaxSeat(request.getMaxSeat());
        event.setBusiness(business);

        Event savedEvent = eventService.addEvent(event);

        AddEventResponse response = new AddEventResponse();
        response.setEventID(savedEvent.getEventId());
        response.setMessage("Event added successfully");
        //response.setEventName(savedEvent.getEventName());
        //response.setLocation(savedEvent.getLocation());
        //response.setPriceRange(savedEvent.getPriceRange());
        //response.setMaxSeat(savedEvent.getMaxSeat());
        //response.setBusinessId(savedEvent.getBusinessId());

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
	
	
	 @GetMapping("/{id}")
	    public ResponseEntity<ViewEventResponse> viewEventById(@PathVariable("id") Long eventId) {
	        Optional<Event> eventOptional = eventService.getEventById(eventId);
	        
	        if (eventOptional.isPresent()) {
	            ViewEventResponse response = new ViewEventResponse();
	            response.setEvent(eventOptional.get());
	            return new ResponseEntity<>(response, HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }
	
	

}
