package com.cg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.exception.DataNotFoundException;
import com.cg.model.AirPollution;
import com.cg.repository.AirPollutionRepository;
@Service
public class AirPollutionServiceimpl implements AirPollutionService {
	
	@Autowired
	private AirPollutionRepository airPollution;

	
	//Methods for User----------------------------------------------------------------------------------
	
	  //Serviceimpl method for searching pollution by city for user------------------
	
	@Override
	public List<AirPollution> findPollutionByCity(String city)throws DataNotFoundException {
		 List<AirPollution> airpollution = airPollution.findByCity(city);
		if(airpollution.isEmpty()) {
			throw new  DataNotFoundException();
		}else {
			return airpollution;
		}
	}

	  //Serviceimpl method for searching pollution by country for user---------------

	@Override
	public List<AirPollution> findPollutionByCountry(String country)throws DataNotFoundException {
		List<AirPollution> airpollution = airPollution.findByCountry(country);
		if(airpollution.isEmpty()) {
			throw new  DataNotFoundException();
		}else {
			return airpollution;
		}
	}

	  //Serviceimpl method for searching pollution by state for user------------------

	@Override
	public List<AirPollution> findPollutionByState(String state)throws DataNotFoundException {
		List<AirPollution> airpollution = airPollution.findByState(state);
		if(airpollution.isEmpty()) {
			throw new  DataNotFoundException();
		}else {
			return airpollution;
		}
	}
	
    
	
}
