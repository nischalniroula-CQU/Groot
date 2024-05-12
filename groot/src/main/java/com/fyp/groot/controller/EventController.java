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
	
	private ViewEventResponse mapEventToViewEventResponse(Event event) {
	    ViewEventResponse viewEventResponse = new ViewEventResponse();
	    viewEventResponse.setEvent(event); // Assuming you have appropriate setters in ViewEventResponse
	    return viewEventResponse;
	}

	@GetMapping("/getAll")
	public ResponseEntity<GetAllEventResponse> getAllEvents(@RequestBody GetAllEventRequest request) {
		List<Event> events = eventService.getAllEvents(request);
		
		// Map Event objects to ViewEventResponse objects
	    List<ViewEventResponse> eventResponses = events.stream()
	            .map(this::mapEventToViewEventResponse) // assuming you have a method to map Event to ViewEventResponse
	            .collect(Collectors.toList());
		
		GetAllEventResponse response = new GetAllEventResponse();
		response.setEvent(eventResponses);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@GetMapping("/getbyid")
	public ResponseEntity<ViewEventResponse> getEventById(@RequestParam Long eventid) {
		ViewEventResponse response = eventService.getEventById(eventid);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<AddEventResponse> addEvent(@RequestBody AddEventRequest request) {
		AddEventResponse response = new AddEventResponse();
		response.setEvent(eventService.addEvent(request));
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<AddEventResponse> updateEvent(@PathVariable("id") Long eventId, @RequestBody AddEventRequest request) {
		AddEventResponse response = eventService.updateEvent(request, eventId);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteEvent(@PathVariable("id") Long eventId) {
		eventService.deleteEvent(eventId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
	@PostMapping("/getbyfilter")
	public ResponseEntity<GetAllEventResponse> getEventByForeignId(@RequestBody GetEventByForeignIdRequest request) {
		GetAllEventResponse response = eventService.getEventByForeignId(request);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

}
