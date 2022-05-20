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

import com.cg.exception.DataNotFoundException;
import com.cg.model.AirPollution;
import com.cg.service.AirPollutionServiceimpl;

@RestController
@RequestMapping("/api/user")
public class AirPollutionController {
	
	@Autowired
	private AirPollutionServiceimpl airPollserviceimpl;
	
	

	// User Controller Request -------------------------------------------------------------------------------------
	
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
