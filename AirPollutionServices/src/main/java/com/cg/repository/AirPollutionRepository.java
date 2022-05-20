package com.cg.repository;

import java.util.Optional;
import java.util.*;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cg.model.AirPollution;

public interface AirPollutionRepository extends MongoRepository<AirPollution, String> {
	
	//custom methods for find pollution by post code in repository
	
	public Optional<AirPollution> findByPostCode(int postCode);
	
	//custom methods for find pollution by city in repository

	public List<AirPollution> findByCity(String city);
	
	//custom methods for find pollution by country in repository

	public List<AirPollution> findByCountry(String country);
	
	//custom methods for find pollution by state in repository

	public List<AirPollution> findByState(String state);

}
