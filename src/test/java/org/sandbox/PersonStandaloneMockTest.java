package org.sandbox;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.sandbox.controller.PersonController;
import org.sandbox.orm.Person;
import org.sandbox.service.PersonService;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

/**
 * Author: zhangxin
 * Date:   15-9-2
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SpringBootMybatisApplication.class)
@ContextConfiguration(classes = MockServletContext.class)
public class PersonStandaloneMockTest {

    //@Mock creates a mock.
    @Mock
    private PersonService personService;

    //@InjectMocks creates an instance of the class and injects the mocks
    //that are created with the @Mock (or @Spy) annotations into this instance.
    @InjectMocks
    PersonController personController;

    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        //Note that you must use @RunWith(MockitoJUnitRunner.class) or
        //Mockito.initMocks(this) to initialise these mocks and inject them.
        MockitoAnnotations.initMocks(this);
        mockMvc = standaloneSetup(personController).build();
    }

    @Test
    public void testGetPerson() throws Exception {
        Person person = new Person();
        person.setName("5");
        when(personService.select(5)).thenReturn(person);
        mockMvc.perform(get("/demo/v1/persons/5"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("5"));
    }
}
