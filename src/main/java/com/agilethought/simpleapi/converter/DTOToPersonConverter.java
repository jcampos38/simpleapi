package com.agilethought.simpleapi.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.agilethought.simpleapi.domain.Person;
import com.agilethought.simpleapi.dto.PersonDTO;

@Component
public class DTOToPersonConverter implements Converter<PersonDTO, Person>{

	@Override
	public Person convert(PersonDTO source) {
		Person target = new Person();
		BeanUtils.copyProperties(source, target);
		
		return target;
	}

}
