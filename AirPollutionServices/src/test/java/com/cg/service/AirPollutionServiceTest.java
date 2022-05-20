package com.cg.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import com.cg.exception.DataNotFoundException;
import com.cg.model.AirPollution;
import com.cg.repository.AirPollutionRepository;

import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
class AirPollutionServiceTest {
	
	@MockBean
	private AirPollutionRepository pollutionRepository;
	
	@InjectMocks
	private AirPollutionServiceimpl servcimpl;
	
	//service layer test for find pollution by city
	
	@Test
	public void getPollutionByCityTest() throws DataNotFoundException {
		AirPollution airPollution = new AirPollution("india","maharashtra","mumbai",415540,1,3,1,3,1);
		AirPollution airPollution2 = new AirPollution("india","maharashtra","pune",415542,1,3,1,3,1);
		pollutionRepository.save(airPollution);
		pollutionRepository.save(airPollution2);
		List<AirPollution> pollutionList = new ArrayList<>();
		pollutionList.add(airPollution);
		when(pollutionRepository.findByCity("mumbai")).thenReturn(pollutionList);
		
		List<AirPollution> getPollutionData = servcimpl.findPollutionByCity("mumbai");
		assertEquals(pollutionList,getPollutionData);
	}
	
	//service layer test for find pollution by country	
	
	@Test
	public void getPollutionByCountryTest() throws DataNotFoundException {
		AirPollution airPollution = new AirPollution("America","NYC","mumbai",415540,1,3,1,3,1);
		AirPollution airPollution2 = new AirPollution("india","banglore","pune",415542,1,3,1,3,1);
		pollutionRepository.save(airPollution);
		pollutionRepository.save(airPollution2);
		List<AirPollution> pollutionList = new ArrayList<>();
		pollutionList.add(airPollution);
		when(pollutionRepository.findByCountry("America")).thenReturn(pollutionList);
		
		List<AirPollution> getPollutionData = servcimpl.findPollutionByCountry("America");
		assertEquals(pollutionList,getPollutionData);
	}
	
	//service layer test for find pollution by state
	
	@Test
	public void getPollutionByStateTest() throws DataNotFoundException {
		AirPollution airPollution = new AirPollution("india","maharashtra","mumbai",415540,1,3,1,3,1);
		AirPollution airPollution2 = new AirPollution("india","banglore","pune",415542,1,3,1,3,1);
		pollutionRepository.save(airPollution);
		pollutionRepository.save(airPollution2);
		List<AirPollution> pollutionList = new ArrayList<>();
		pollutionList.add(airPollution);
		when(pollutionRepository.findByState("banglore")).thenReturn(pollutionList);
		
		List<AirPollution> getPollutionData = servcimpl.findPollutionByState("banglore");
		assertEquals(pollutionList,getPollutionData);
	}

}
