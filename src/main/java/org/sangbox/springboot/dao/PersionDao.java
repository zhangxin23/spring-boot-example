package org.sangbox.springboot.dao;

import org.sangbox.springboot.mapper.PersionMapper;
import org.sangbox.springboot.model.Persion;
import org.sangbox.springboot.model.PersionExample;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by zhangxin on 15/8/27.
 */
public class PersionDao {

    @Autowired
    private PersionMapper persionMapper;

    public int insert(Persion persion) {
        return persionMapper.insertSelective(persion);
    }

    public Persion select(int id) {
        PersionExample example = new PersionExample();
        PersionExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(id);
        List<Persion> persions = persionMapper.selectByExample(example);
        if(persions != null && persions.size() > 0) {
            return persions.get(0);
        }
        return null;
    }
}
