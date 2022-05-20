package com.cg.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.cg.model.AirPollution;
@SpringBootTest
@ExtendWith(SpringExtension.class)
class AirPollutionRepositoryTest {
	
	@Autowired
	private AirPollutionRepository airPollutionRepository;

	//Test for addPollution
	@Test
	public void addPollutionData() {
		AirPollution airPollution = new AirPollution("india","maharashtra","pune",415540,1,3,1,3,1);
		AirPollution airpollutionsaved = airPollutionRepository.save(airPollution);
		assertNotNull(airpollutionsaved);
	}
	//Test for updatePollution
	@Test
	public void updatePollution() {
		int postCode = 415540;
		AirPollution airPollution = new AirPollution("india","maharashtra","pune",postCode,1,3,1,3,1);
		airPollutionRepository.save(airPollution);
		Optional<AirPollution> airPollutionUpdate = airPollutionRepository.findByPostCode(postCode);
		AirPollution airPollutionupdated = airPollutionUpdate.get();
		assertEquals(airPollutionupdated.getPostCode(),postCode);
	}
	
	//Test for deletePollution

	@Test
	public void deletePollution() {
		int postCode = 415540;
		AirPollution airPollution = new AirPollution("india","maharashtra","pune",postCode,1,3,1,3,1);
		airPollutionRepository.save(airPollution);
		Optional<AirPollution> airPollutionUpdate = airPollutionRepository.findByPostCode(postCode);
		AirPollution airPollutionupdated = airPollutionUpdate.get();
		
		
	}
	
	
	//Test for Search Methods
	
	//Test for findPollution by city

	@Test
	public void findPollutionByCity() {
		String city = "mumbai";
		AirPollution airPollution = new AirPollution("india","maharashtra",city,415540,1,3,1,3,1);
		AirPollution airPollution2 = new AirPollution("india","maharashtra","pune",415542,1,3,1,3,1);
		airPollutionRepository.save(airPollution);
		airPollutionRepository.save(airPollution2);
		List<AirPollution> airPollutionGetCity = airPollutionRepository.findByCity("pune");
		assertNotNull(airPollution);
		AirPollution airPollutionGet = airPollutionGetCity.get(0);
		assertEquals(airPollutionGet.getCity(),"pune");
		
	}
	//Test for findPollution by country
	
	@Test
	public void findPollutionByCountry() {
		String country = "india";
		AirPollution airPollution = new AirPollution("country","maharashtra","pune",415540,1,3,1,3,1);
		airPollutionRepository.save(airPollution);
		List<AirPollution> airPollutionGetCountry = airPollutionRepository.findByCountry(country);
		assertNotNull(airPollution);
		AirPollution airPollutionGet = airPollutionGetCountry.get(0);
		assertEquals(airPollutionGet.getCountry(),"india");
		
	}
	//Test for findPollution by state
	
	@Test
	public void findPollutionByState() {
		String state = "karnataka";
		AirPollution airPollution = new AirPollution("india","state","banglore",415540,1,3,1,3,1);
		AirPollution airPollution2 = new AirPollution("india","maharashtra","pune",415542,1,3,1,3,1);
		airPollutionRepository.save(airPollution);
		airPollutionRepository.save(airPollution2);
		List<AirPollution> airPollutionGetState = airPollutionRepository.findByState("maharashtra");
		assertNotNull(airPollution);
		AirPollution airPollutionGet = airPollutionGetState.get(0);
		assertEquals(airPollutionGet.getCity(),"pune");
		
	}

}
