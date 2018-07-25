package com.in28minutes.rest.webservices.restfulwebservices.controller;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.in28minutes.rest.webservices.restfulwebservices.model.SomeBean;

@RestController
public class FilteringController {

	// Example dynamic filtering
	@GetMapping("/filtering")
	public MappingJacksonValue retrieveSomeBean() {
		SomeBean someBean = new SomeBean("value1","value2","value3");
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter
				.serializeAllExcept("field1","field2");
				//filterOutAllExcept("field1","field2");
		
		FilterProvider filters = new SimpleFilterProvider().
				addFilter("SomeBeanFilter", filter);
		
		MappingJacksonValue mapping = new MappingJacksonValue(someBean);
		mapping.setFilters(filters);
		
		return mapping;
	}
	
	@GetMapping("/filtering-list")
	public MappingJacksonValue retrieveListOfSomeBean() {
		List<SomeBean> list = Arrays.asList(new SomeBean("value1", "value2", "value3"),
				new SomeBean("value4", "value5", "value6"));

		Set<String> setList = new HashSet<>();
		setList.add("field1");
		setList.add("field2");
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter
				.serializeAllExcept(setList);
		// filterOutAllExcept("field1","field2");

		FilterProvider filters = new SimpleFilterProvider().
				addFilter("SomeBeanFilter", filter);

		MappingJacksonValue mapping = new MappingJacksonValue(list);
		mapping.setFilters(filters);

		return mapping;
	}
}
