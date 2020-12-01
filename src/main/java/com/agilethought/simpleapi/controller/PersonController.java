package com.agilethought.simpleapi.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.agilethought.simpleapi.controller.intf.IPersonController;
import com.agilethought.simpleapi.dto.PersonDTO;
import com.agilethought.simpleapi.service.intf.IPersonService;

@RestController
@RequestMapping("/api/v1/persons")
public class PersonController implements IPersonController{
	
	@Autowired
	IPersonService personService;

	@Override
	@GetMapping()
	public List<PersonDTO> getPersonList() {
		return personService.findPersonList();
	}

	@Override
	@GetMapping("/{id}")
	public PersonDTO getPersonById(@PathVariable Integer id) {
		return personService.findPersonById(id);
	}

	@Override
	@PostMapping()
	public PersonDTO createPerson(@Valid @RequestBody PersonDTO person) {
		return personService.createPerson(person);
	}

	@Override
	@DeleteMapping("/{id}")
	public void deletePerson(@PathVariable Integer id) {
		personService.deletePerson(id);
	}

	@Override
	@PutMapping("/{id}")
	public PersonDTO updatePerson(@PathVariable Integer id, @Valid @RequestBody PersonDTO person) {
		return personService.updatePerson(id, person);
	}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleValidationExceptions(
	  MethodArgumentNotValidException ex) {
	    Map<String, String> errors = new HashMap<>();
	    ex.getBindingResult().getAllErrors().forEach((error) -> {
	        String fieldName = ((FieldError) error).getField();
	        String errorMessage = error.getDefaultMessage();
	        errors.put(fieldName, errorMessage);
	    });
	    return errors;
	}
	
}
