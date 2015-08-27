package org.sandbox.springboot.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
import org.sandbox.springboot.model.PersionExample;
import org.sandbox.springboot.model.Persion;

public interface PersionMapper {
    int countByExample(PersionExample example);

    int deleteByExample(PersionExample example);

    @Delete({
        "delete from persion",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into persion (name, age, ",
        "country)",
        "values (#{name,jdbcType=VARCHAR}, #{age,jdbcType=INTEGER}, ",
        "#{country,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(Persion record);

    int insertSelective(Persion record);

    List<Persion> selectByExample(PersionExample example);

    @Select({
        "select",
        "id, name, age, country",
        "from persion",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @ResultMap("BaseResultMap")
    Persion selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Persion record, @Param("example") PersionExample example);

    int updateByExample(@Param("record") Persion record, @Param("example") PersionExample example);

    int updateByPrimaryKeySelective(Persion record);

    @Update({
        "update persion",
        "set name = #{name,jdbcType=VARCHAR},",
          "age = #{age,jdbcType=INTEGER},",
          "country = #{country,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Persion record);
}