package org.sandbox.service;

import org.sandbox.orm.Person;
import org.sandbox.orm.PersonExample;
import org.sandbox.orm.PersonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Author: zhangxin
 * Date:   15-8-28
 */
@Service
public class PersonService {
    @Autowired
    private PersonMapper personMapper;

    public int insert(Person person) {
        return personMapper.insertSelective(person);
    }

    public int update(Person person) {
        PersonExample example = new PersonExample();
        PersonExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(person.getId());

        return personMapper.updateByExample(person, example);
    }

    public int delete(int id) {
        return personMapper.deleteByPrimaryKey(id);
    }

    public Person select(int id) {
        PersonExample example = new PersonExample();
        PersonExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(id);
        List<Person> persons = personMapper.selectByExample(example);
        if(persons != null && persons.size() > 0) {
            return persons.get(0);
        }
        return null;
    }
}
