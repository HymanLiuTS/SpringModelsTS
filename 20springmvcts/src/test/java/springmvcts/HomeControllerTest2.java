package springmvcts;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import springmvcts.domain.SpitterService;

public class HomeControllerTest2 {

	@Mock
	private SpitterService service;
	
	@InjectMocks
	private HomeController homeController;
	
	//private MockMvc mockMvc;
	
	@Test
	public void showHomePageTest() {
		MockitoAnnotations.initMocks(this);
		 Mockito.when(service.getHome()).thenReturn("hello");
		 
		 HashMap<String,Object> model=new HashMap<String,Object>();
		 String viewName = homeController.showHomePage(model);
		 assertEquals("hello",viewName);
	}

}
