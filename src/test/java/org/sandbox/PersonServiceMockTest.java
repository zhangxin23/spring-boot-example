package org.sandbox;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.sandbox.controller.PersonController;
import org.sandbox.orm.Person;
import org.sandbox.service.PersonService;
import org.springframework.test.util.ReflectionTestUtils;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Author: zhangxin
 * Date:   15-9-2
 */
public class PersonServiceMockTest {

    @Mock
    private PersonService personService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testDemo() {
        PersonController personController = new PersonController();

        //public static void setField(Object target, String name, Object value)
        //target - the target object on which to set the field
        //name - the name of the field to set
        //value - the value to set
        ReflectionTestUtils.setField(personController, "personService", personService);

        Person rtnPerson = new Person();
        rtnPerson.setName("5");
        when(personService.select(5)).thenReturn(rtnPerson);
        Person person = (Person)personController.getPerson(5);
        verify(personService, times(1)).select(5);
        assertEquals("5", person.getName());
    }

    @Test
    public void testGetPerson() {
        PersonController personController = new PersonController();
        //将personController的personService属性赋值为被@Mock注解过的personService对象
        ReflectionTestUtils.setField(personController, "personService", personService);

        Person item = new Person();
        item.setName("5");
        when(personService.select(5)).thenReturn(item);
        Person person = (Person)personController.getPerson(5);
        verify(personService, times(1)).select(5);
        assertEquals("5", person.getName());
    }
}
