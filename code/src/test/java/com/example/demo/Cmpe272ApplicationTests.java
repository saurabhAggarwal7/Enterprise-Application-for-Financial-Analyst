package com.example.demo;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.junit.Before;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
/*
@RunWith(SpringRunner.class)
@SpringBootTest
*/
public class Cmpe272ApplicationTests {
	/*@InjectMocks
	
	UserService service;
	
		
	@Mock
	private UserRepository userRepository;
	

	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testGetfollowersList() {
		List<Users> users = new ArrayList<Users>();
		users.add(new Users("100","sjh","sxu","yu","1"));
		Mockito.when(userRepository.findAll()).thenReturn(users);
		List<Users> result = service.getAllUsers();
		assertEquals(1, result.size());
		
}
	@Test
	public void saveUsers(){
		Users users = new Users("100","sjh","sxu","yu","1");
		when(userRepository.save(users)).thenReturn(users);
		Users result = service.addUsers(users);
		assertEquals("100", result.getUserid());
		assertEquals("sjh", result.getFirstname());
		assertEquals("sxu", result.getLastname());
		assertEquals("yu", result.getPassword());
		assertEquals("1", result.getFlag());
	}
	
	
	@Test
	public void removeUsers(){
		Users users = new Users("100","sjh","sxu","yu","1");
		service.deleteUsers("100");
        verify(userRepository, times(1)).deleteById("100");;
	}
	
	*/

	
	
	
	
	
	
	

}
