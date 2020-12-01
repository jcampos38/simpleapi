package com.agilethought.simpleapi.service;

import java.text.MessageFormat;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.server.ResponseStatusException;

import com.agilethought.simpleapi.constant.ErrorMessage;
import com.agilethought.simpleapi.converter.DTOToPersonConverter;
import com.agilethought.simpleapi.converter.PersonToDTOConverter;
import com.agilethought.simpleapi.domain.Person;
import com.agilethought.simpleapi.dto.PersonDTO;
import com.agilethought.simpleapi.repository.PersonRepository;
import com.agilethought.simpleapi.service.intf.IPersonService;

@Service
public class PersonService implements IPersonService {
	
	@Autowired
	PersonRepository personRepository;
	
	@Autowired
	PersonToDTOConverter personToDTOConverter;
	
	@Autowired
	DTOToPersonConverter dtoToPersonConverter;

	@Override
	public List<PersonDTO> findPersonList() {
		List<Person> personList = personRepository.findAll();
		
		if(CollectionUtils.isEmpty(personList))
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, ErrorMessage.PERSON_NO_PERSONS_FOUND);
		
		return personList.stream().map(p -> personToDTOConverter.convert(p))
				.collect(Collectors.toList());
	}

	@Override
	public PersonDTO findPersonById(Integer id) {
		Person person = personRepository.findByIdPerson(id);
		
		if(person == null)
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,
					MessageFormat.format(ErrorMessage.PERSON_NO_PERSON_FOUND_BY_ID, id));
		
		return personToDTOConverter.convert(person);
	}

	@Override
	public PersonDTO createPerson(PersonDTO person) {
		Person newPerson = new Person();
		newPerson = personRepository.save(dtoToPersonConverter.convert(person));
		return personToDTOConverter.convert(newPerson);
	}

	@Override
	public void deletePerson(Integer id) {
		Person person = personRepository.findByIdPerson(id);
		
		if(person == null)
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,
					MessageFormat.format(ErrorMessage.PERSON_NO_PERSON_FOUND_BY_ID, id));
		
		personRepository.delete(person);
	}

	@Override
	public PersonDTO updatePerson(Integer id, PersonDTO person) {
		Person old = personRepository.findByIdPerson(id);
		
		if(old == null)
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,
					MessageFormat.format(ErrorMessage.PERSON_NO_PERSON_FOUND_BY_ID, id));
		
		old.setName(person.getName());
		old.setLastName(person.getLastName());
		old.setEmail(person.getEmail());
		old.setAge(person.getAge());
		old.setHeight(person.getHeight());
		old.setWeight(person.getWeight());
		return personToDTOConverter.convert(personRepository.save(old));
	}

}
