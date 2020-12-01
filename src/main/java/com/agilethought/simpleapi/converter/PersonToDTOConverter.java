package com.agilethought.simpleapi.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.agilethought.simpleapi.domain.Person;
import com.agilethought.simpleapi.dto.PersonDTO;

@Component
public class PersonToDTOConverter implements Converter<Person, PersonDTO>{

	@Override
	public PersonDTO convert(Person source) {
		PersonDTO to = new PersonDTO();
		to.setIdPerson(source.getIdPerson());
		to.setEmail(source.getEmail());
		to.setName(source.getName());
		to.setLastName(source.getLastName());
		to.setAge(source.getAge());
		to.setWeight(source.getWeight());
		to.setHeight(source.getHeight());
		to.setGender(source.getGender());
		
		return to;
	}

}
