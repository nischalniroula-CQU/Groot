package com.fyp.groot.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fyp.groot.entity.Business;
import com.fyp.groot.entity.Product;
import com.fyp.groot.model.GetAllProductResponse;
import com.fyp.groot.service.BusinessService;
import com.fyp.groot.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {
	
	//@Autowired
    private ProductService productService;
	private BusinessService businessService;
	
	@Autowired
    public ProductController(ProductService productService, BusinessService businessService) {
        this.productService = productService;
        this.businessService = businessService;
    }
	
	@GetMapping("/getAll")
    public ResponseEntity<GetAllProductResponse> getAllProducts() {
		List<Product> product = productService.getAllProducts();
		GetAllProductResponse response = new GetAllProductResponse();
        response.setProduct(product);
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
	
	
//	 @GetMapping("/{id}")
//	    public ResponseEntity<ViewEventResponse> viewEventById(@PathVariable("id") Long eventId) {
//	        Optional<Event> eventOptional = eventService.getEventById(eventId);
//	        
//	        if (eventOptional.isPresent()) {
//	            ViewEventResponse response = new ViewEventResponse();
//	            response.setEvent(eventOptional.get());
//	            return new ResponseEntity<>(response, HttpStatus.OK);
//	        } else {
//	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//	        }
//	    }
	
	

}