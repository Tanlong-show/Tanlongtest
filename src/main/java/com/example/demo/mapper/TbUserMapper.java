package com.example.demo.mapper;

import com.example.demo.domain.TbUser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
@Component
@Mapper
public interface TbUserMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(TbUser record);

    TbUser selectByPrimaryKey(Integer userId);

    List<TbUser> selectAll();

    int updateByPrimaryKey(TbUser record);
}