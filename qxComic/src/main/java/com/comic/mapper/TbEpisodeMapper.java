package com.comic.mapper;

import com.comic.pojo.TbEpisode;
import com.comic.pojo.TbEpisodeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbEpisodeMapper {
    int countByExample(TbEpisodeExample example);

    int deleteByExample(TbEpisodeExample example);

    int deleteByPrimaryKey(Integer episodeid);

    int insert(TbEpisode record);

    int insertSelective(TbEpisode record);

    List<TbEpisode> selectByExample(TbEpisodeExample example);

    TbEpisode selectByPrimaryKey(Integer episodeid);

    int updateByExampleSelective(@Param("record") TbEpisode record, @Param("example") TbEpisodeExample example);

    int updateByExample(@Param("record") TbEpisode record, @Param("example") TbEpisodeExample example);

    int updateByPrimaryKeySelective(TbEpisode record);

    int updateByPrimaryKey(TbEpisode record);
}