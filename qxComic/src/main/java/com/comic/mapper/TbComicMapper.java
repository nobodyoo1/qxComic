package com.comic.mapper;

import com.comic.pojo.TbComic;
import com.comic.pojo.TbComicExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbComicMapper {
    int countByExample(TbComicExample example);

    int deleteByExample(TbComicExample example);

    int deleteByPrimaryKey(Integer comicid);

    int insert(TbComic record);

    int insertSelective(TbComic record);

    List<TbComic> selectByExample(TbComicExample example);

    TbComic selectByPrimaryKey(Integer comicid);

    int updateByExampleSelective(@Param("record") TbComic record, @Param("example") TbComicExample example);

    int updateByExample(@Param("record") TbComic record, @Param("example") TbComicExample example);

    int updateByPrimaryKeySelective(TbComic record);

    int updateByPrimaryKey(TbComic record);
}