package org.sandbox.springboot.dao;

import org.sandbox.springboot.mapper.PersionMapper;
import org.sandbox.springboot.model.Persion;
import org.sandbox.springboot.model.PersionExample;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by zhangxin on 15/8/27.
 */
public class PersionDao {

    @Resource(name = "persionMapper")
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
