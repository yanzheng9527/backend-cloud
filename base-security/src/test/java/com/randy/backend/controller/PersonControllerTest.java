package com.randy.backend.controller;

import com.randy.backend.BaseSecurityApplication;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BaseSecurityApplication.class)
@AutoConfigureMockMvc
@Transactional
public class PersonControllerTest {
  @Autowired private MockMvc mockMvc;
  @Autowired private WebApplicationContext webApplicationConnect;

  @Before
  public void setUp() throws Exception {}

  @After
  public void tearDown() throws Exception {}

  @Test
  public void createPerson() throws Exception {
    String json = "{\n" + "\t\"name\":\"randytest\",\n" + "\t\"age\":\"10\"\n" + "}";
    mockMvc
        .perform(
            MockMvcRequestBuilders.post("/createPerson")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
        .andExpect(MockMvcResultMatchers.status().isOk());
    //                .param("name","test1").param("age","10"))
  }

  @Test
  public void getPerson() throws Exception {
    mockMvc
        .perform(MockMvcRequestBuilders.get("/getPerson/randytest"))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("randytest"));
  }

  @Test
  public void listPerson() throws Exception {
    String responseString =
        mockMvc
            .perform(MockMvcRequestBuilders.get("/listPerson"))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andReturn()
            .getResponse()
            .getContentAsString();
    System.out.println("--------返回的json = " + responseString);
  }

  @Test
  public void deletePerson() throws Exception {
    mockMvc
        .perform(MockMvcRequestBuilders.get("/deletePerson/randytest"))
        .andExpect(MockMvcResultMatchers.status().isOk());
  }
}
