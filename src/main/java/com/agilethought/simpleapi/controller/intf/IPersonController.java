package com.agilethought.simpleapi.controller.intf;

import java.util.List;

import com.agilethought.simpleapi.dto.PersonDTO;

public interface IPersonController {
	
	public List<PersonDTO> getPersonList();
	
	public PersonDTO getPersonById(Integer id);
	
	public PersonDTO createPerson(PersonDTO person);
	
	public void deletePerson(Integer id);

	public PersonDTO updatePerson(Integer id, PersonDTO person);
	
}
