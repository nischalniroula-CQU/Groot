package com.fyp.groot.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fyp.groot.entity.Business;
import com.fyp.groot.entity.Event;
import com.fyp.groot.model.GetAllEventRequest;
import com.fyp.groot.model.GetAllEventResponse;
import com.fyp.groot.model.ViewBusinessResponse;
import com.fyp.groot.model.ViewMultipleBusinessRequest;
import com.fyp.groot.model.ViewMultipleBusinessResponse;
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
    
    
    public List<GetAllEventResponse> getAllEvents(GetAllEventRequest request) {
		// Fetch all businesses from the repository
		List<Event> event = eventRepository.findAll();

		// Apply filters based on request parameters
		if (request.getEventName() != null) {
			event = event.stream()
					.filter(e -> request.getEventName().equalsIgnoreCase(e.getEventName()))
					.collect(Collectors.toList());
		}

		if (request.getEventId() != null) {
			event = event.stream()
					.filter(e -> request.getEventId().equals(e.getEventId()))
					.collect(Collectors.toList());
		}

		if (request.getLocation() != null) {
			event = event.stream()
					.filter(e -> request.getLocation().equalsIgnoreCase(e.getLocation()))
					.collect(Collectors.toList());
		}

		if (request.getBusinessId() != null) {
			event = event.stream().filter(e -> request.getBusinessId().equals(e.getBusinessId()))
					.collect(Collectors.toList());
		}

		// Map filtered businesses to response objects
		List<GetAllEventResponse> eventResponses = event.stream().map(this::mapEventToResponse)
				.collect(Collectors.toList());

		//Create and return response object
		//GetAllEventResponse response = new GetAllEventResponse();
		//response.setEvent(eventResponses);
		//return response;
		return event.stream()
                .map(this::mapEventToResponse) // Call the correct mapping method
                .collect(Collectors.toList());
	}

	private GetAllEventResponse mapEventToResponse(Event event) {
		return GetAllEventResponse.builder()
				.event(getAllEvents())
//				.name(business.getName())
//				.addedOn(business.getAddOn())
//				.address(business.getAddress())
//				.basicDetail(business.getBasicDetails())
//				.address(business.getAddress())
//				.subtitle(business.getSubtitle())
//				.cultureId(business.getCultureId())
//				.contactMethod(business.getContactMethod())
//				.phoneNumber(business.getPhoneNumber())
//				.email(business.getEmailId())
//				.latitude(business.getLatitude())
//				.longitude(business.getLongitude())
//				.city(business.getCity())
//				.country(business.getCountry())
//				.priceRange(business.getPriceRange())
//				.status(business.getStatus())
				.build();
	}

}
