package com.example.demo.ServiceImpl;

import com.example.demo.Service.UserService;
import com.example.demo.domain.TbUser;
import com.example.demo.mapper.TbUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImp implements UserService {
    @Autowired
    TbUserMapper tbUserMapper;


    public List<TbUser> findAll() {
        return tbUserMapper.selectAll();
    }
}
