package crud.springboot.controller;


import static org.junit.Assert.assertEquals;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.xmlunit.util.Mapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import crud.springboot.entity.Employee;

//@SpringBootTest
@ContextConfiguration
@WebMvcTest
@RunWith(SpringJUnit4ClassRunner.class)
public class EmployeeControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private WebApplicationContext wc;
	
	 Employee employee = new Employee(3,"sanju","basavaraj",854,"Team lead","ddd","2021-4-26","ccc","2021-4-26",true);
			
	
	List<Employee> employees = new ArrayList<Employee>();
	ObjectMapper MAPPER = new ObjectMapper();
	
	@Before
	public void setUp(){
		mockMvc = MockMvcBuilders.webAppContextSetup(wc).build();
	}
	
	@Test
	public void updateEmployee() throws JsonProcessingException, Exception{
		MvcResult result = mockMvc.perform(put("/api/employees")
				.contentType(APPLICATION_JSON_VALUE)
				.content(MAPPER.writeValueAsString(employee)))
				.andExpect(status().isOk())
				.andReturn();
		
		Employee response = MAPPER.readValue(result.getResponse().getContentAsString(), Employee.class);
	   assertEquals(employee, response);
	}
	
	@Test
	public void findAll() throws JsonProcessingException, Exception{
		MvcResult result = mockMvc.perform(get("/api/employees")
				.contentType(APPLICATION_JSON_VALUE))
				.andExpect(status().isOk())
				.andReturn();
		List<Employee> response = MAPPER.readValue(result.getResponse()
				.getContentAsString(), new TypeReference<List<Employee>>() {
		});
		assertEquals(employees, response);
	}
	
	@Test
    public void addEmployee() throws Exception {
        MvcResult result = mockMvc.perform(post("/api/employees")
                .contentType(APPLICATION_JSON_VALUE)
                .content(MAPPER.writeValueAsString(employee)))
                .andExpect(status().isOk())
                .andReturn();
        Employee response = MAPPER.readValue(result.getResponse().getContentAsString(), Employee.class);
        assertEquals(employee, response);
    }
	
	@Test
	public void deleteEmployee() throws Exception {
		mockMvc.perform(delete("/api/employees/{employee-id}")
				.contentType(APPLICATION_JSON_VALUE))
				.andExpect(status().isNoContent())
				.andReturn();
	}
}
