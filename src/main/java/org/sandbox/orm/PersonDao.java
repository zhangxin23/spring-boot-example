package org.sandbox.orm;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Author: zhangxin
 * Date:   15-9-16
 */
public class PersonDao extends SqlSessionDaoSupport {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private PersonMapper personMapper;

    public Person select(int id) {
        logger.info("###PersonDao### select person, id is " + id);

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
