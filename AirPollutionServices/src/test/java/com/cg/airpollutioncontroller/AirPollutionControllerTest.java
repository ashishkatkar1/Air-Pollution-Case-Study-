package com.cg.airpollutioncontroller;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.mockito.InjectMocks;
import com.cg.model.AirPollution;
import com.cg.service.AirPollutionService;
import com.fasterxml.jackson.core.JsonProcessingException;

import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
class AirPollutionControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@Mock
	private AirPollutionService pollutionService;
	private AirPollution airPollution;
	private List<AirPollution> pollutionList;
	
	@InjectMocks
	private AirPollutionController ArPollcntrl;
	
	@BeforeEach
	public void init()
	{
		airPollution = new AirPollution("india","maharashtra","pune",415542,1,3,1,3,1);
		mockMvc = MockMvcBuilders.standaloneSetup(ArPollcntrl).build();
	}
	
	//Test for Get pollution by city
	@Test
	void PollutioByCityTest() throws JsonProcessingException, Exception {
		when(pollutionService.findPollutionByCity("pune")).thenReturn(pollutionList);
		mockMvc.perform(MockMvcRequestBuilders.get("/api/user/pollutionDataByCity/pune") 
				.contentType(MediaType.APPLICATION_JSON) 
				.content (asJSONString(airPollution))) 
				.andDo(MockMvcResultHandlers.print()); 
		verify(pollutionService, times (1)).findPollutionByCity("pune");
		
		
	}
	//Test for Get pollution by country
	
	void PollutioByCountryTest() throws JsonProcessingException, Exception {
		when(pollutionService.findPollutionByCountry("india")).thenReturn(pollutionList);
		mockMvc.perform(MockMvcRequestBuilders.get("/api/user/pollutionDataByCity/india") 
				.contentType(MediaType.APPLICATION_JSON) 
				.content (asJSONString(airPollution))) 
				.andDo(MockMvcResultHandlers.print()); 
		verify(pollutionService, times (1)).findPollutionByCountry("india");
		
		
	}
	//Test for Get pollution by state
	
	void PollutioByStateTest() throws JsonProcessingException, Exception {
		when(pollutionService.findPollutionByState("maharashtra")).thenReturn(pollutionList);
		mockMvc.perform(MockMvcRequestBuilders.get("/api/user/pollutionDataByCity/maharashtra") 
				.contentType(MediaType.APPLICATION_JSON) 
				.content (asJSONString(airPollution))) 
				.andDo(MockMvcResultHandlers.print()); 
		verify(pollutionService, times (1)).findPollutionByState("maharashtra");
		
		
	}
	
	
	public static String asJSONString(final Object obj) throws JsonProcessingException
	{
		
			return new ObjectMapper().writeValueAsString(obj);
		
	}

}
