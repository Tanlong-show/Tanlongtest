package com.example.demo.mapper;

import com.example.demo.domain.TbVideo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
@Component
@Mapper
public interface TbVideoMapper {
    int deleteByPrimaryKey(Integer videoId);

    int insert(TbVideo record);

    TbVideo selectByPrimaryKey(Integer videoId);

    List<TbVideo> selectAll();

    int updateByPrimaryKey(TbVideo record);
}