package edu.mum.coffee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.mum.coffee.domain.Person;
import edu.mum.coffee.service.PersonService;

@Controller
public class PersonController {
	
	@Autowired
	private PersonService personService;
	
	@RequestMapping(value = "/person", method = RequestMethod.GET)
	public @ResponseBody String getPeople(Model model){
		model.addAttribute("persons", personService.getAllPerson());
		return "person";
	}
	
	@RequestMapping(value = "/person", method = RequestMethod.POST)
	public @ResponseBody String getPeople(Person person){
		personService.savePerson(person);
		return "person";
	}
	
	@RequestMapping(value = "/person/{id}", method = RequestMethod.POST)
	public @ResponseBody String getPeople(@PathVariable long id){
		Person person = personService.findById(id);
		personService.removePerson(person);
		return "person";
	}

}
