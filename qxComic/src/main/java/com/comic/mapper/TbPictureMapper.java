package com.comic.mapper;

import com.comic.pojo.TbPicture;
import com.comic.pojo.TbPictureExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbPictureMapper {
    int countByExample(TbPictureExample example);

    int deleteByExample(TbPictureExample example);

    int deleteByPrimaryKey(Integer pictureid);

    int insert(TbPicture record);

    int insertSelective(TbPicture record);

    List<TbPicture> selectByExample(TbPictureExample example);

    TbPicture selectByPrimaryKey(Integer pictureid);

    int updateByExampleSelective(@Param("record") TbPicture record, @Param("example") TbPictureExample example);

    int updateByExample(@Param("record") TbPicture record, @Param("example") TbPictureExample example);

    int updateByPrimaryKeySelective(TbPicture record);

    int updateByPrimaryKey(TbPicture record);
}