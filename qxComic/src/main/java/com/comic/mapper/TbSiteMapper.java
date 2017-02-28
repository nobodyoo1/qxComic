package com.comic.mapper;

import com.comic.pojo.TbSite;
import com.comic.pojo.TbSiteExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbSiteMapper {
    int countByExample(TbSiteExample example);

    int deleteByExample(TbSiteExample example);

    int deleteByPrimaryKey(Integer siteid);

    int insert(TbSite record);

    int insertSelective(TbSite record);

    List<TbSite> selectByExample(TbSiteExample example);

    TbSite selectByPrimaryKey(Integer siteid);

    int updateByExampleSelective(@Param("record") TbSite record, @Param("example") TbSiteExample example);

    int updateByExample(@Param("record") TbSite record, @Param("example") TbSiteExample example);

    int updateByPrimaryKeySelective(TbSite record);

    int updateByPrimaryKey(TbSite record);
}