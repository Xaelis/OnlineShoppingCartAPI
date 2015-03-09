package com.model.config;

import java.io.Serializable;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.xml.Jaxb2RootElementHttpMessageConverter;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.genmymodel.api.representations.ValueDeserializer;

@Configuration
public class JacksonConfig
{
	@Bean
	public ObjectMapper objectMapper()
	{
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.setSerializationInclusion(Include.NON_NULL);
		objectMapper.configure(MapperFeature.DEFAULT_VIEW_INCLUSION, false);
		
		SimpleModule module = new SimpleModule("SerializableValueDeserializer");
		module.addDeserializer(Serializable.class, new ValueDeserializer());
		objectMapper.registerModule(module);
		return objectMapper;
	}
	
	@Bean
	public MappingJackson2HttpMessageConverter mappingJacksonMessageConverter()
	{
		MappingJackson2HttpMessageConverter converter =
			new MappingJackson2HttpMessageConverter();
		converter.setObjectMapper(objectMapper());
		return converter;
	}
	
	@Bean
	public Jaxb2RootElementHttpMessageConverter jaxbMessageConverter()
	{
		return new Jaxb2RootElementHttpMessageConverter();
	}
	
}
