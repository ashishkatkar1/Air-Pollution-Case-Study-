package com.cg.airpollutioncontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.exception.CityDataAlreadyExistsException;
import com.cg.exception.DataNotFoundException;
import com.cg.model.AirPollution;
import com.cg.service.AirPollutionServiceimpl;

@RestController
@RequestMapping("/api/v1")
public class AirPollutionController {
	
	@Autowired
	private AirPollutionServiceimpl airPollserviceimpl;
	


    // Admin Controller Request--------------------------------------------------------------------------------------
	
	// Route AddPollution method for adding PollutionData for cities------------
	
	@PostMapping("/addPollution")
	public ResponseEntity<AirPollution> addAirPollution(@RequestBody AirPollution pollutionDetails)throws CityDataAlreadyExistsException {
		AirPollution storeAirPollution = airPollserviceimpl.addPollution(pollutionDetails);
		return ResponseEntity.ok(storeAirPollution);
	}
	
	// Route UpdatePollution method for updating pollution-----------------------
	
	@PutMapping("/update/{postCode}")
	public ResponseEntity<AirPollution> updatePollution(@PathVariable int postCode,@RequestBody AirPollution airpollution  )throws DataNotFoundException {
		airpollution.setPostCode(postCode);
		AirPollution pollutionData = airPollserviceimpl.updatePollution(airpollution);
		return ResponseEntity.ok(pollutionData);
	}
	// Route Delete method for deleting pollution data---------------------------
	
	@DeleteMapping("delete/{postCode}")
	public ResponseEntity<String> deletePollution(@PathVariable int postCode)throws DataNotFoundException {
		airPollserviceimpl.deletePollution(postCode);
		return ResponseEntity.ok("deleted");
	}
	
	
	// Search Controller Request -------------------------------------------------------------------------------------
	
	// Route Method for searching pollution by city data--------------------------
	
    @GetMapping("pollutionDataByCity/{city}")
    public ResponseEntity<List<AirPollution>> PollutioByCity(@PathVariable String city)throws DataNotFoundException {
    	return ResponseEntity.ok(airPollserviceimpl.findPollutionByCity(city));

    }
    
    // Route method for searching country data-------------------------------------
    
    @GetMapping("pollutionDataByCountry/{country}")
    public ResponseEntity<List<AirPollution>> pollutioByCountry(@PathVariable String country)throws DataNotFoundException {
    	return ResponseEntity.ok(airPollserviceimpl.findPollutionByCountry(country));

    }
    
 // Route method for searching country data-----------------------------------------
    
    @GetMapping("pollutionDataByState/{state}")
    public ResponseEntity<List<AirPollution>> pollutioByState(@PathVariable String state)throws DataNotFoundException {
    	return ResponseEntity.ok(airPollserviceimpl.findPollutionByState(state));
    }
}
