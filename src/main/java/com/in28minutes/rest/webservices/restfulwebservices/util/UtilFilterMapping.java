package com.in28minutes.rest.webservices.restfulwebservices.util;

import java.util.Set;

import org.springframework.http.converter.json.MappingJacksonValue;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

public class UtilFilterMapping {

	private MappingJacksonValue mapping;
	private SimpleBeanPropertyFilter filter;
	private FilterProvider filters;
	
	public UtilFilterMapping(Object object) {
		MappingJacksonValue mapping = new MappingJacksonValue(object);
	}
	
	public void configFilter(Set<String> setFilter, String filterBean) {
		this.setFilter(SimpleBeanPropertyFilter.serializeAllExcept(setFilter));
		
		this.setFilters(new SimpleFilterProvider().
				addFilter(filterBean, this.getFilter()));
		
		
	}
	

	public MappingJacksonValue getMapping() {
		return mapping;
	}

	public void setMapping(MappingJacksonValue mapping) {
		this.mapping = mapping;
	}

	public SimpleBeanPropertyFilter getFilter() {
		return filter;
	}

	public void setFilter(SimpleBeanPropertyFilter filter) {
		this.filter = filter;
	}

	public FilterProvider getFilters() {
		return filters;
	}

	public void setFilters(FilterProvider filters) {
		this.filters = filters;
	}
}
