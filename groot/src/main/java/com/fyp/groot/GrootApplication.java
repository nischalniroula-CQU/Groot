package com.fyp.groot;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.fyp.groot.entity.Business;
import com.fyp.groot.entity.BusinessReview;
import com.fyp.groot.entity.BusinessTiming;
import com.fyp.groot.entity.Category;
import com.fyp.groot.entity.City;
import com.fyp.groot.entity.Country;
import com.fyp.groot.entity.Culture;
import com.fyp.groot.entity.Event;
import com.fyp.groot.entity.Favourite;
import com.fyp.groot.entity.ImageLibrary;
import com.fyp.groot.entity.InterestLibrary;
import com.fyp.groot.entity.PersonalInterest;
import com.fyp.groot.entity.Plan;
import com.fyp.groot.entity.Product;
import com.fyp.groot.entity.Tag;
import com.fyp.groot.entity.University;
import com.fyp.groot.entity.User;
import com.fyp.groot.repository.BusinessRepository;
import com.fyp.groot.repository.BusinessReviewRepository;
import com.fyp.groot.repository.BusinessTimingRepository;
import com.fyp.groot.repository.CategoryRepository;
import com.fyp.groot.repository.CityRepository;
import com.fyp.groot.repository.CountryRepository;
import com.fyp.groot.repository.CultureRepository;
import com.fyp.groot.repository.EventRepository;
import com.fyp.groot.repository.FavouriteRepository;
import com.fyp.groot.repository.ImageLibraryRepository;
import com.fyp.groot.repository.InterestLibraryRepository;
import com.fyp.groot.repository.PersonalInterestRepository;
import com.fyp.groot.repository.PlanRepository;
import com.fyp.groot.repository.ProductRepository;
import com.fyp.groot.repository.TagRepository;
import com.fyp.groot.repository.UniversityRepository;
import com.fyp.groot.repository.UserRepository;

@SpringBootApplication
public class GrootApplication {
	
	@Autowired
	BusinessTimingRepository businessTimingRepository;
	
	@Autowired
	BusinessRepository businessRepository;
	
	@Autowired
	ImageLibraryRepository imageLibraryRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	CategoryRepository categoryRepository;
	
	@Autowired
	CountryRepository countryRepository;
	
	@Autowired
	CityRepository cityRepository;
	
	@Autowired
	CultureRepository cultureRepository;
	
	@Autowired
	EventRepository eventRepository;
	
	@Autowired
	FavouriteRepository favouriteRepository;
	
	@Autowired
	InterestLibraryRepository interestLibraryRepository;
	
	@Autowired
	PersonalInterestRepository personalInterestRepository;
	
	@Autowired
	PlanRepository planRepository;
	
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	TagRepository tagRepository;
	
	@Autowired
	UniversityRepository universityRepository;
	
	@Autowired
	BusinessReviewRepository businessReviewRepository;

	public static void main(String[] args) throws IOException {
			
		SpringApplication.run(GrootApplication.class, args);
	}
	
	
	@Bean
    public CommandLineRunner loadData(BusinessRepository repository) {
        return args -> {
            
            repository.save(new Business(
                    null, "Attica", "Innovative Australian Cuisine", 
                    "A fine dining experience showcasing unique Australian ingredients.",
                    "Both", "+61 3 9530 0111", "info@attica.com.au",
                    "Ripponlea, Melbourne", "74 Glen Eira Rd", "Ripponlea", "Australia",
                    "$$$$", "Active", LocalDateTime.now(), "-37.8672", "145.0018",
                    1L, 1L, 1L // Assuming these are valid IDs for category, culture, owner
                ));
            
            repository.save(new Business(
                    null, "Quay", "Modern Australian with Harbour Views",
                    "Iconic Sydney restaurant with spectacular views and award-winning cuisine.",
                    "Both", "+61 2 9251 5600", "quay@quay.com.au", 
                    "The Rocks, Sydney", "Upper Level, Overseas Passenger Terminal", "The Rocks", "Australia",
                    "$$$$", "Active", LocalDateTime.now(), "-33.8568", "151.2153",
                    1L, 1L, 2L 
                ));
            
            repository.save(new Business(
                    null, "Brae", "Regional Victorian Dining",
                    "A destination restaurant set on a working farm, emphasizing seasonal produce.",
                    "Both", "+61 3 5562 5266", "info@braerestaurant.com.au",
                    "Birregurra, Victoria", "4285 Cape Otway Rd", "Birregurra", "Australia",
                    "$$$$", "Active", LocalDateTime.now(), "-38.4647", "144.0925",
                    1L, 1L, 3L 
                ));
            
            repository.save(new Business(
                    null, "Orana", "Indigenous Australian Ingredients",
                    "Celebrating native Australian ingredients in creative and thought-provoking dishes.",
                    "Both", "+61 8 8232 3444", "info@oranarestaurant.com.au",
                    "Adelaide, South Australia", "285 Rundle St", "Adelaide", "Australia",
                    "$$$", "Active", LocalDateTime.now(), "-34.9285", "138.6014",
                    1L, 1L, 4L 
                ));
            
            repository.save(new Business(
                    null, "Sepia", "Contemporary Australian Seafood",
                    "Innovative seafood-focused cuisine with Japanese influences in a stylish setting.",
                    "Both", "+61 2 9265 6388", "info@sepiarestaurant.com.au",
                    "Sussex St, Sydney", "201 Sussex St", "Sydney", "Australia",
                    "$$$$", "Active", LocalDateTime.now(), "-33.8695", "151.2070",
                    1L, 1L, 5L 
                ));
            
            //--------------------------------------------------------------------------------
            
         // Attica (businessId will be automatically generated by the database)
            businessTimingRepository.save(new BusinessTiming(
                null, "Closed", "6 PM - 10 PM", "6 PM - 10 PM", "6 PM - 10 PM",
                "6 PM - 10 PM", "6 PM - 10 PM", "Closed", businessRepository.findByName("Attica").getBusinessId()
            ));
            imageLibraryRepository.save(new ImageLibrary(
                null, "image/jpeg", "attica_dining_room.jpg", null, businessRepository.findByName("Attica").getBusinessId()
            ));
            imageLibraryRepository.save(new ImageLibrary(
                null, "image/png", "attica_signature_dish.png", null, businessRepository.findByName("Attica").getBusinessId()
            ));
            
         // Quay
            businessTimingRepository.save(new BusinessTiming(
                null, "12 PM - 2 PM", "12 PM - 2 PM", "12 PM - 2 PM",
                "12 PM - 2 PM", "12 PM - 2 PM", "12 PM - 2 PM", "12 PM - 2 PM", businessRepository.findByName("Quay").getBusinessId()
            ));
            imageLibraryRepository.save(new ImageLibrary(
                null, "image/jpeg", "quay_harbour_view.jpg", null, businessRepository.findByName("Quay").getBusinessId()
            ));
            imageLibraryRepository.save(new ImageLibrary(
                null, "image/png", "quay_snow_egg_dessert.png", null, businessRepository.findByName("Quay").getBusinessId()
            ));
            
         // Brae
            businessTimingRepository.save(new BusinessTiming(
                null, "Closed", "Closed", "6 PM - 10 PM", "6 PM - 10 PM",
                "6 PM - 10 PM", "12 PM - 3 PM, 6 PM - 10 PM", "12 PM - 3 PM", businessRepository.findByName("Brae").getBusinessId()
            ));
            imageLibraryRepository.save(new ImageLibrary(
                null, "image/jpeg", "brae_farmhouse.jpg", null, businessRepository.findByName("Brae").getBusinessId()
            ));
            imageLibraryRepository.save(new ImageLibrary(
                null, "image/png", "brae_garden_produce.png", null, businessRepository.findByName("Brae").getBusinessId()
            ));
            
         // Orana
            businessTimingRepository.save(new BusinessTiming(
                null, "Closed", "6 PM - 10 PM", "6 PM - 10 PM", "6 PM - 10 PM",
                "6 PM - 10 PM", "Closed", "Closed", businessRepository.findByName("Orana").getBusinessId()
            ));
            imageLibraryRepository.save(new ImageLibrary(
                null, "image/jpeg", "orana_interior.jpg", null, businessRepository.findByName("Orana").getBusinessId()
            ));
            imageLibraryRepository.save(new ImageLibrary(
                null, "image/png", "orana_indigenous_dish.png", null, businessRepository.findByName("Orana").getBusinessId()
            ));
            
         // Sepia
            businessTimingRepository.save(new BusinessTiming(
                null, "Closed", "12 PM - 2 PM, 6 PM - 10 PM", "12 PM - 2 PM, 6 PM - 10 PM",
                "12 PM - 2 PM, 6 PM - 10 PM", "12 PM - 2 PM, 6 PM - 10 PM", "Closed", "Closed", businessRepository.findByName("Sepia").getBusinessId()
            ));
            imageLibraryRepository.save(new ImageLibrary(
                null, "image/jpeg", "sepia_bar.jpg", null, businessRepository.findByName("Sepia").getBusinessId()
            ));
            imageLibraryRepository.save(new ImageLibrary(
                null, "image/png", "sepia_seafood_platter.png", null, businessRepository.findByName("Sepia").getBusinessId()
            ));
            
            //----------------------------------------------------------need to edit
            
            userRepository.save(new User(
                    null, "ben_shewry", LocalDateTime.now().minusDays(30), "Ben", "Shewry", 
                    "ben.shewry@attica.com.au", "+61 3 9530 0112", 
                    "74 Glen Eira Rd", "Ripponlea", "Australia",
                    OffsetDateTime.now().minusYears(15), "Active", "iPhone 14 Pro", null, "Business Owner", "1", "1", 1L
                ));
            
            userRepository.save(new User(
                    null, "peter_gilmore", LocalDateTime.now().minusDays(15), "Peter", "Gilmore",
                    "peter.gilmore@quay.com.au", "+61 2 9251 5601",
                    "Upper Level, Overseas Passenger Terminal", "The Rocks", "Australia",
                    OffsetDateTime.now().minusYears(10), "Active", "Samsung Galaxy S23 Ultra", null, "Business Owner", "1", "2", 1L
                ));
            
            userRepository.save(new User(
                    null, "dan_hunter", LocalDateTime.now().minusDays(5), "Dan", "Hunter",
                    "dan.hunter@brae.com.au", "+61 3 5562 5267",
                    "4285 Cape Otway Rd", "Birregurra", "Australia",
                    OffsetDateTime.now().minusYears(8), "Active", "Google Pixel 7", null, "Business Owner", "1", "3", 1L
                ));
            
            userRepository.save(new User(
                    null, "jock_zonfrillo", LocalDateTime.now().minusDays(2), "Jock", "Zonfrillo",
                    "jock.zonfrillo@orana.com.au", "+61 8 8232 3445",
                    "285 Rundle St", "Adelaide", "Australia",
                    OffsetDateTime.now().minusYears(6), "Active", "iPhone 13", null, "Business Owner", "1", "4", 1L
                ));
            
            userRepository.save(new User(
                    null, "martin_benn", LocalDateTime.now(), "Martin", "Benn",
                    "martin.benn@sepia.com.au", "+61 2 9265 6389",
                    "201 Sussex St", "Sydney", "Australia",
                    OffsetDateTime.now().minusYears(4), "Active", "OnePlus 11", null, "Business Owner", "1", "1", 1L
                ));
            
            //----------------------------------------------------------------------
            
            categoryRepository.save(new Category(null, "Modern Australian"));
            categoryRepository.save(new Category(null, "Fine Dining"));
            categoryRepository.save(new Category(null, "Casual Dining"));
            categoryRepository.save(new Category(null, "Seafood"));
            categoryRepository.save(new Category(null, "Steakhouse"));
            categoryRepository.save(new Category(null, "Cafe"));
            categoryRepository.save(new Category(null, "Bar"));
            categoryRepository.save(new Category(null, "Pub"));
            categoryRepository.save(new Category(null, "Bistro"));
            categoryRepository.save(new Category(null, "International Cuisine"));
            
            
          //-----------------------------------------------
            
            // Country
               countryRepository.save(new Country(null, "Australia"));
               countryRepository.save(new Country(null, "Pakistan"));
               countryRepository.save(new Country(null, "Nepal"));
               countryRepository.save(new Country(null, "Sri Lanka"));

               // Cities
               cityRepository.save(new City(null, "Melbourne"));
               cityRepository.save(new City(null, "Sydney"));
               cityRepository.save(new City(null, "Adelaide"));
               cityRepository.save(new City(null, "Birregurra")); // Small town in Victoria where Brae is located

               // Cultures
               cultureRepository.save(new Culture(null, "Australian", "Active"));
               cultureRepository.save(new Culture(null, "European", "Active"));
               cultureRepository.save(new Culture(null, "Asian", "Active"));
               
               
               //==================================================================
               
               eventRepository.save(new Event(null, "Wine Tasting Dinner", "Attica", "$$$", 30, businessRepository.findByName("Attica").getBusinessId()));
               eventRepository.save(new Event(null, "Winter Solstice Feast", "Quay", "$$$$", 50, businessRepository.findByName("Quay").getBusinessId()));
               eventRepository.save(new Event(null, "Farm-to-Table Workshop", "Brae", "$$", 20, businessRepository.findByName("Brae").getBusinessId()));
               eventRepository.save(new Event(null, "Indigenous Food Festival", "Orana", "$$", 100, businessRepository.findByName("Orana").getBusinessId()));
               eventRepository.save(new Event(null, "Seafood Masterclass", "Sepia", "$$$", 40, businessRepository.findByName("Sepia").getBusinessId()));
               
               
               //------------------------------------------------------------------
               
               
            // Ben Shewry (Attica) favorites Quay and Brae
               favouriteRepository.save(new Favourite(null, userRepository.findByUsername("ben_shewry").getUserId(), businessRepository.findByName("Quay").getBusinessId()));
               favouriteRepository.save(new Favourite(null, userRepository.findByUsername("ben_shewry").getUserId(), businessRepository.findByName("Brae").getBusinessId()));

               // Peter Gilmore (Quay) favorites Attica and Orana
               favouriteRepository.save(new Favourite(null, userRepository.findByUsername("peter_gilmore").getUserId(), businessRepository.findByName("Attica").getBusinessId()));
               favouriteRepository.save(new Favourite(null, userRepository.findByUsername("peter_gilmore").getUserId(), businessRepository.findByName("Orana").getBusinessId()));

               // Dan Hunter (Brae) favorites Sepia
               favouriteRepository.save(new Favourite(null, userRepository.findByUsername("dan_hunter").getUserId(), businessRepository.findByName("Sepia").getBusinessId()));
               
               
               //--------------------------------------------------------------------------------------
               
               
            // InterestLibrary
               interestLibraryRepository.save(new InterestLibrary(null, "Fine Dining"));
               interestLibraryRepository.save(new InterestLibrary(null, "Casual Dining"));
               interestLibraryRepository.save(new InterestLibrary(null, "Seafood"));
               interestLibraryRepository.save(new InterestLibrary(null, "Wine Tasting"));
               interestLibraryRepository.save(new InterestLibrary(null, "Craft Beer"));
               interestLibraryRepository.save(new InterestLibrary(null, "Local Produce"));
               interestLibraryRepository.save(new InterestLibrary(null, "Sustainable Dining"));
               interestLibraryRepository.save(new InterestLibrary(null, "Indigenous Cuisine"));

               // PersonalInterest (examples)

               // Ben Shewry (Attica) is interested in Fine Dining, Local Produce, and Sustainable Dining
               personalInterestRepository.save(new PersonalInterest(null, interestLibraryRepository.findByInterest("Fine Dining").getInterestLibraryId(), userRepository.findByUsername("ben_shewry").getUserId()));
               personalInterestRepository.save(new PersonalInterest(null, interestLibraryRepository.findByInterest("Local Produce").getInterestLibraryId(), userRepository.findByUsername("ben_shewry").getUserId()));
               personalInterestRepository.save(new PersonalInterest(null, interestLibraryRepository.findByInterest("Sustainable Dining").getInterestLibraryId(), userRepository.findByUsername("ben_shewry").getUserId()));

               // Peter Gilmore (Quay) is interested in Seafood and Wine Tasting
               personalInterestRepository.save(new PersonalInterest(null, interestLibraryRepository.findByInterest("Seafood").getInterestLibraryId(), userRepository.findByUsername("peter_gilmore").getUserId()));
               personalInterestRepository.save(new PersonalInterest(null, interestLibraryRepository.findByInterest("Wine Tasting").getInterestLibraryId(), userRepository.findByUsername("peter_gilmore").getUserId()));
               
               
               //--------------------------------------------------------------
               
               
            // Plans
               planRepository.save(new Plan(null, "Basic", "$0"));
               planRepository.save(new Plan(null, "Standard", "$9.99/month"));
               planRepository.save(new Plan(null, "Premium", "$19.99/month"));

               // Products (Example for Attica Restaurant, you can add similar ones for other restaurants)
               Business attica = businessRepository.findByName("Attica");
               productRepository.save(new Product(null, attica.getBusinessId(), "Chef's Tasting Menu", "A multi-course journey through seasonal Australian ingredients.", 250.0, "Active"));
               productRepository.save(new Product(null, attica.getBusinessId(), "Wine Pairing", "Expertly curated wines to complement your meal.", 120.0, "Active"));
               productRepository.save(new Product(null, attica.getBusinessId(), "Native Ingredients Gift Box", "A selection of unique Australian ingredients to take home.", 80.0, "Active"));

               // Tags (Example for Attica's Chef's Tasting Menu)
               Product atticaTastingMenu = productRepository.findByProductTitle("Chef's Tasting Menu");
               tagRepository.save(new Tag(null, atticaTastingMenu.getPromoId(), "tasting menu"));
               tagRepository.save(new Tag(null, atticaTastingMenu.getPromoId(), "fine dining"));
               tagRepository.save(new Tag(null, atticaTastingMenu.getPromoId(), "seasonal"));
               
               
               //--------------------------------------------------------------
               
               
            // Universities
               universityRepository.save(new University(null, "The University of Melbourne", "Melbourne", "Parkville", "Grattan St"));
               universityRepository.save(new University(null, "University of Sydney", "Sydney", "Camperdown", "City Rd"));
               universityRepository.save(new University(null, "University of Adelaide", "Adelaide", "North Terrace", "North Terrace"));
               universityRepository.save(new University(null, "Central QueensLand University", "Melbourne", "Victoria", "Spencer St"));
               
               // Reviews
               businessReviewRepository.save(new BusinessReview(null, businessRepository.findByName("Attica").getBusinessId(), userRepository.findByUsername("peter_gilmore").getUserId(), "5", "Exceptional dining experience, truly innovative!", "Active", LocalDateTime.now()));
               businessReviewRepository.save(new BusinessReview(null, businessRepository.findByName("Quay").getBusinessId(), userRepository.findByUsername("dan_hunter").getUserId(), "4", "Stunning views, delicious food, but a bit pricey.", "Active", LocalDateTime.now().minusDays(5)));
               businessReviewRepository.save(new BusinessReview(null, businessRepository.findByName("Brae").getBusinessId(), userRepository.findByUsername("jock_zonfrillo").getUserId(), "5", "A must-visit for any food lover. The farm-to-table concept is amazing!", "Active", LocalDateTime.now().minusDays(10)));
               businessReviewRepository.save(new BusinessReview(null, businessRepository.findByName("Orana").getBusinessId(), userRepository.findByUsername("martin_benn").getUserId(), "4", "Unique flavors and a focus on indigenous ingredients. A memorable meal.", "Active", LocalDateTime.now().minusDays(1)));

            
        };
        
        
        
    }

}









