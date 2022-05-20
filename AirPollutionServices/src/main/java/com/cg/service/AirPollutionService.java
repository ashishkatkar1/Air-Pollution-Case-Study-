package com.cg.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.exception.DataNotFoundException;
import com.cg.model.AirPollution;
@Service
public interface AirPollutionService {
	
      
      //methods for user--------------------------------------------------------------------------------------------
      
	  //Service method for searching pollution by city for user------------------

      
      public List<AirPollution> findPollutionByCity(String city)throws DataNotFoundException; 
      
	  //Service method for searching pollution by country for user---------------
      
      public List<AirPollution> findPollutionByCountry(String country)throws DataNotFoundException;
      
	  //Service method for searching pollution by state for user------------------
     
      public List<AirPollution> findPollutionByState(String state)throws DataNotFoundException;
      
}
