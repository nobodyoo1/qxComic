package com.comic.mapper;

import com.comic.pojo.TbSource;
import com.comic.pojo.TbSourceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbSourceMapper {
    int countByExample(TbSourceExample example);

    int deleteByExample(TbSourceExample example);

    int deleteByPrimaryKey(Integer sourceid);

    int insert(TbSource record);

    int insertSelective(TbSource record);

    List<TbSource> selectByExample(TbSourceExample example);

    TbSource selectByPrimaryKey(Integer sourceid);

    int updateByExampleSelective(@Param("record") TbSource record, @Param("example") TbSourceExample example);

    int updateByExample(@Param("record") TbSource record, @Param("example") TbSourceExample example);

    int updateByPrimaryKeySelective(TbSource record);

    int updateByPrimaryKey(TbSource record);
}