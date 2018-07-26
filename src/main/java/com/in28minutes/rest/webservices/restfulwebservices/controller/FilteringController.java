package com.in28minutes.rest.webservices.restfulwebservices.controller;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.in28minutes.rest.webservices.restfulwebservices.model.SomeBean;
import com.in28minutes.rest.webservices.restfulwebservices.util.UtilFilterMapping;

@RestController
public class FilteringController {
	
	private UtilFilterMapping utilFilterMapping;

	// Example dynamic filtering
	@GetMapping("/filtering")
	public MappingJacksonValue retrieveSomeBean() {
		
		SomeBean someBean = new SomeBean("value1","value2","value3");
		Set<String> setList = new HashSet<>();
		setList.add("field1");
		setList.add("field2");
		
		utilFilterMapping = new UtilFilterMapping(someBean);
		MappingJacksonValue mapping = utilFilterMapping.
				configFilterOutAllExcept(setList, "SomeBeanFilter");
		
		return mapping;
	}
	
	@GetMapping("/filtering-list")
	public MappingJacksonValue retrieveListOfSomeBean() {
		List<SomeBean> list = Arrays.asList(new SomeBean("value1", "value2", "value3"),
				new SomeBean("value4", "value5", "value6"));

		Set<String> setList = new HashSet<>();
		setList.add("field1");
		setList.add("field2");
		
		utilFilterMapping = new UtilFilterMapping(list);
		MappingJacksonValue mapping = utilFilterMapping.
				configFilterAllExcept(setList, "SomeBeanFilter");

		return mapping;
	}
}
