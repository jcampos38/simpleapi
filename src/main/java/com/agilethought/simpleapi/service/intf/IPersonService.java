package com.agilethought.simpleapi.service.intf;

import java.util.List;

import com.agilethought.simpleapi.dto.PersonDTO;

public interface IPersonService {
	
	public List<PersonDTO> findPersonList();
	
	public PersonDTO findPersonById(Integer id);
	
	public PersonDTO createPerson(PersonDTO person);
	
	public void deletePerson(Integer id);

	public PersonDTO updatePerson(Integer id, PersonDTO person);

}
