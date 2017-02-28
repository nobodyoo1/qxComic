package com.comic.mapper;

import com.comic.pojo.TbFavorite;
import com.comic.pojo.TbFavoriteExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbFavoriteMapper {
    int countByExample(TbFavoriteExample example);

    int deleteByExample(TbFavoriteExample example);

    int deleteByPrimaryKey(Integer favoriteid);

    int insert(TbFavorite record);

    int insertSelective(TbFavorite record);

    List<TbFavorite> selectByExample(TbFavoriteExample example);

    TbFavorite selectByPrimaryKey(Integer favoriteid);

    int updateByExampleSelective(@Param("record") TbFavorite record, @Param("example") TbFavoriteExample example);

    int updateByExample(@Param("record") TbFavorite record, @Param("example") TbFavoriteExample example);

    int updateByPrimaryKeySelective(TbFavorite record);

    int updateByPrimaryKey(TbFavorite record);
}