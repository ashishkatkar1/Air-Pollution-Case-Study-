package com.cg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.exception.CityDataAlreadyExistsException;
import com.cg.exception.DataNotFoundException;
import com.cg.model.AirPollution;
import com.cg.repository.AirPollutionRepository;
@Service
public class AirPollutionServiceimpl implements AirPollutionService {
	
	@Autowired
	private AirPollutionRepository airPollution;
	
	//Methods for Admin--------------------------------------------------------------------------------
	 
	//ServiceImpl method for adding pollution for admin-------------------------


	@Override
	public AirPollution addPollution(AirPollution pollutionDetails)throws CityDataAlreadyExistsException {
		Optional<AirPollution> checkData = airPollution.findByPostCode(pollutionDetails.getPostCode());
		if(checkData.isPresent()) {
			throw new CityDataAlreadyExistsException();
		}else {
		
		return airPollution.save(pollutionDetails);
		}
	}
	
	  //Serviceimpl method for updating pollution for admin------------------------
	

	@Override
	public AirPollution updatePollution(AirPollution airpollution)throws DataNotFoundException {
		Optional<AirPollution> updatedPollution = airPollution.findByPostCode(airpollution.getPostCode());
		if(updatedPollution.isPresent()) {
			AirPollution airpollutionupdate = updatedPollution.get();
			airpollutionupdate.setCountry(airpollution.getCountry());
			airpollutionupdate.setState(airpollution.getState());
			airpollutionupdate.setCity(airpollution.getCity());
			airpollutionupdate.setAqi(airpollution.getAqi());
			airpollutionupdate.setPm25(airpollution.getPm25());
			airpollutionupdate.setPm10(airpollution.getPm10());
			airpollutionupdate.setO3(airpollution.getO3());
			airpollutionupdate.setNo2(airpollution.getNo2());
			airPollution.save(airpollutionupdate);
			
			 return airpollutionupdate;
		}else {
		     throw new  DataNotFoundException();
		}
	}
	
	  //Serviceimpl method for deleting pollution for admin-------------------------
	

	@Override
	public String deletePollution(int postCode)throws DataNotFoundException {
		Optional<AirPollution> delete = airPollution.findByPostCode(postCode);
		if(delete.isPresent()) {
		airPollution.delete(delete.get());
		}else {
		     throw new  DataNotFoundException();			
		}
		return null;
	}

	
	//Methods for Search----------------------------------------------------------------------------------
	
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
