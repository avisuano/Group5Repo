package com.revature.springmvctest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.revature.model.Academy;
import com.revature.model.Genre;
import com.revature.model.Movie;
import com.revature.service.MovieService;
import com.revature.web.MovieController;

/*
 * Using JUnit, you can specify a test runner. This runner is a class that
 * defines how your test is run. Spring has its own Junit Test runner,
 * called: SpringJunit4ClassRunner. Using the @RunWith annotation to 
 * indicate we want tests in this class.
 */
@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration tells Spring where to look for the application context.
@ContextConfiguration(locations="classpath:testContext.xml")
// Indicates the application context is a web application context.
@WebAppConfiguration
public class MovieControllerTest {

	//This auto wires the Web App Context to our test Context
	@Autowired
	private WebApplicationContext wac;
	
	//Mocking the MovieService dependency that MovieController uses. 
	//Unit dependencies are mocked because true unit tests need to be done without dependencies
	@Mock
	private MovieService ms;
	
	@InjectMocks
	private MovieController mc;
	
	//Spring has a built in Mock MVC already
	private MockMvc mockMvc;
	
	@Before
	public void setUP() {
		//First initialize the mock
		MockitoAnnotations.initMocks(this);
		
		//Building the mock controller
		mockMvc = MockMvcBuilders.standaloneSetup(mc).build();
		
	}
	
	@Test
	public void testGetAllMoviesEndpoint() {
		//Handling the mock movie service first, by making it return mock data
		Mockito.when(ms.getAllMovies()).thenReturn(Arrays.asList(
				new Movie(1, "Any Movie Ever", new Genre(1, ""), new Academy(1, "")),
				new Movie(1, "Any Movie Ever the SQL", new Genre(1, "SQLitis"), new Academy(1, "Best SQL")),
				new Movie(1, "Any Movie Ever: The Final Countdown", new Genre(1, "Wanna see a magic trick?"), new Academy(1, "The end is nigh"))
				));
		//Performing the test of the controller
		try {
			mockMvc.perform(get("/movie/all").content(MediaType.APPLICATION_JSON_UTF8_VALUE))
				.andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
				.andDo(print()).andReturn();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
