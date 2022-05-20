package com.cg.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.exception.CityDataAlreadyExistsException;
import com.cg.exception.DataNotFoundException;
import com.cg.model.AirPollution;
@Service
public interface AirPollutionService {
	
	  // Service methods for Admin----------------------------------------------------------------------------------
	
	  //Service method for adding pollution for admin-------------------------
	
      public AirPollution addPollution(AirPollution pollutionDetails)throws CityDataAlreadyExistsException;
      
	  //Service method for updating pollution for admin------------------------

      public AirPollution updatePollution( AirPollution airpollution)throws DataNotFoundException;
      
	  //Service method for deleting pollution for admin-------------------------

      public String deletePollution(int postCode)throws DataNotFoundException;
      
      //methods for Searching--------------------------------------------------------------------------------------------
      
	  //Service method for searching pollution by city for user------------------

      
      public List<AirPollution> findPollutionByCity(String city)throws DataNotFoundException; 
      
	  //Service method for searching pollution by country for user---------------
      
      public List<AirPollution> findPollutionByCountry(String country)throws DataNotFoundException;
      
	  //Service method for searching pollution by state for user------------------
     
      public List<AirPollution> findPollutionByState(String state)throws DataNotFoundException;
      
}
