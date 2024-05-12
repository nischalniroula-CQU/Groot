package com.fyp.groot.controller;

import com.fyp.groot.entity.Event;
import com.fyp.groot.model.GetAllEventRequest;
import com.fyp.groot.model.GetAllEventResponse;
import com.fyp.groot.model.ViewEventResponse;
import com.fyp.groot.service.BusinessService;
import com.fyp.groot.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

	@GetMapping("/getAll")
	public ResponseEntity<GetAllEventResponse> getAllEvents(@RequestBody GetAllEventRequest request) {
		List<Event> event = eventService.getAllEvents(request);
		GetAllEventResponse response = new GetAllEventResponse();
		response.setEvent(event);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	//	@PostMapping("/addEvent")
	//    public ResponseEntity<AddEventResponse> addEvent(@RequestBody AddEventRequest request) {
	//
	//		// Retrieve the business entity from the database based on businessId
	//        Business business = businessService.findById(request.getBusinessID());
	//
	//     // Check if business exists
	//        if (business == null) {
	//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	//        }
	//
	//        Event event = new Event();
	//        event.setEventName(request.getEventName());
	//        event.setLocation(request.getLocation());
	//        event.setPriceRange(request.getPriceRange());
	//        event.setMaxSeat(request.getMaxSeat());
	//        event.setBusiness(business);
	//
	//        Event savedEvent = eventService.addEvent(event);
	//
	//        AddEventResponse response = new AddEventResponse();
	//        response.setEventID(savedEvent.getEventId());
	//        response.setMessage("Event added successfully");
	//        //response.setEventName(savedEvent.getEventName());
	//        //response.setLocation(savedEvent.getLocation());
	//        //response.setPriceRange(savedEvent.getPriceRange());
	//        //response.setMaxSeat(savedEvent.getMaxSeat());
	//        //response.setBusinessId(savedEvent.getBusinessId());
	//
	//        return new ResponseEntity<>(response, HttpStatus.CREATED);
	//    }

	@GetMapping("/getbyid")
	public ResponseEntity<ViewEventResponse> viewEventById(@RequestParam Long eventId) {
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
