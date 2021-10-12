package com.flightSerachMicroservice.SearchResource;



import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.flightSerachMicroservice.SearchRepositary.flightRepositary;
import com.flightSerachMicroservice.mongoDB.model.flights;
@CrossOrigin("*")
@RestController
@RequestMapping("/search")
public class SearchController {
	Logger log=LoggerFactory.getLogger(SearchController.class);
	
	@Autowired
	private flightRepositary flightrepositary;
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Autowired
	private MongoOperations mongoOperations;
	@RequestMapping("/welcome")
	public String getting() {
		
		log.error("Getting() method executed");
		return "hello naresh";
	}
	
	@PostMapping("/addFlight")
	public String saveFlight(@RequestBody flights flight) {
		log.error("Save Flight() method executed");
		log.error("Save flight() method executed");
		flightrepositary.save(flight);
		return "Added Flight with ID:"+flight.getFlightId();
	}
	
	@GetMapping("/allFlights")
	public List<flights> getFlights(){
		log.error("Getting All flights() method executed");
		return flightrepositary.findAll();
	}
	
	@GetMapping("/allFlights/{id}")
	public Optional<flights> getSelectedFlight(@PathVariable String id){
		log.error("Get selected flight() method executed");
		return flightrepositary.findById(id);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteflight(@PathVariable String id) {
		log.error("deleteFlight() method executed");
		flightrepositary.deleteById(id);
		return "deleted Flight with ID:"+id;
	}
	/*@GetMapping("/flights/{from}/{to}/{date}")
	List<flights> findAll(@PathVariable(value="from") String from,
			@PathVariable(value="to") String to,
			@PathVariable(value="date") String date)
	{
		return flightrepositary.findByFromToAndDate(from,to,date);
	}
	@PostMapping("/regexfrom")
	  public List<flights> regexFlightsFrom(@RequestBody String from){
		  Query query = new Query();
		  query.addCriteria(Criteria.where("from").regex(from));
		  List<flights> trai = mongoOperations.find(query, flights.class);
		  return trai;
	  }
	  
	  
	  @PostMapping("/regexto")
	  public List<flights> regexFlightTo(@RequestBody String to){
		  Query query = new Query();
		  query.addCriteria(Criteria.where("to").regex(to));
		  List<flights> trai = mongoOperations.find(query, flights.class);
		  return trai;
	  }
	  @PostMapping("/regexDate")
	  public List<flights> regexFlightDate(@RequestBody String date){
		  Query query = new Query();
		  query.addCriteria(Criteria.where("date").regex(date));
		  List<flights> trai = mongoOperations.find(query, flights.class);
		  return trai;
	  }
	  
	  @PostMapping("/regexAll/{from}/{to}/{date}")
	  public List<flights> regexAll(@RequestBody String from,@RequestBody String to,@RequestBody String date){
		  Query query = new Query();
		  query.addCriteria(
				  new Criteria().andOperator(Criteria.where("from").regex(from),
				  			Criteria.where("to").regex(to),
				  			Criteria.where("date").regex(date)));
		  List<flights> trai = mongoOperations.find(query, flights.class);
		  return trai;
	  }*/
	  
	  @GetMapping("/details/{from}/{to}/{date}")
		public List<flights> getdetails(@PathVariable("from") String from,
				@PathVariable("to") String to,@PathVariable("date") String date){
			log.error("GetDetails() method executed");
			return flightrepositary.findByLocation(from,to,date);
			
		}

}




