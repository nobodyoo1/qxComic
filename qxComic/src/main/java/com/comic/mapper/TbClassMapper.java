package com.comic.mapper;

import com.comic.pojo.TbClass;
import com.comic.pojo.TbClassExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbClassMapper {
    int countByExample(TbClassExample example);

    int deleteByExample(TbClassExample example);

    int deleteByPrimaryKey(Integer classid);

    int insert(TbClass record);

    int insertSelective(TbClass record);

    List<TbClass> selectByExample(TbClassExample example);

    TbClass selectByPrimaryKey(Integer classid);

    int updateByExampleSelective(@Param("record") TbClass record, @Param("example") TbClassExample example);

    int updateByExample(@Param("record") TbClass record, @Param("example") TbClassExample example);

    int updateByPrimaryKeySelective(TbClass record);

    int updateByPrimaryKey(TbClass record);
}