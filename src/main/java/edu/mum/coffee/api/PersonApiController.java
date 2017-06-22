package edu.mum.coffee.api;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.UriComponentsBuilder;

import edu.mum.coffee.domain.Person;
import edu.mum.coffee.service.PersonService;

@Controller
public class PersonApiController {
	
	public static final Logger logger = LoggerFactory.getLogger(PersonApiController.class);
	
	@Autowired
	PersonService personService;
	
	 // -------------------Retrieve All Persons---------------------------------------------
	 
    @RequestMapping(value = "/api/person", method = RequestMethod.GET, produces={"application/json"})
    public @ResponseBody ResponseEntity<List<Person>> listAllUsers() {
        return new ResponseEntity<List<Person>>(personService.getAllPerson(), HttpStatus.OK);
    }

	// --------------Create/Update person -----------//
	@RequestMapping(value = "/api/person", method = RequestMethod.POST)
	 public @ResponseBody ResponseEntity<?> createPerson(@RequestBody Person person, UriComponentsBuilder ucBuilder) {
        logger.info("Creating a person : {}", person);
 
        /*if (personService.findByEmail(person.getEmail()).size() > 0) {
            logger.error("Unable to create. A User with name {} already exist", person.getFirstName());
            return new ResponseEntity<>(new CustomErrorType("Unable to create. A Person with name " + 
            person.getFirstName() + " already exist."),HttpStatus.CONFLICT);
        }*/
        personService.savePerson(person);
 
        //HttpHeaders headers = new HttpHeaders();
        //headers.setLocation(ucBuilder.path("/api/user/{id}").buildAndExpand(person.getId()).toUri());
        return new ResponseEntity<Boolean>(true, HttpStatus.CREATED);
    }
	
	// --------------Delete person -----------//
	@RequestMapping(value = "/api/person/{id}", method = RequestMethod.DELETE)
	 public @ResponseBody ResponseEntity<?> updatePerson(@PathVariable("id") long id) {
       
       Person person = personService.findById(id);
       personService.removePerson(person);
       return new ResponseEntity<Boolean>(true, HttpStatus.OK);
   }
}
