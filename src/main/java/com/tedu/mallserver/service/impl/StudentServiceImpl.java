package com.tedu.mallserver.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.tedu.mallserver.mapper.StudentMapper;
import com.tedu.mallserver.pojo.StudentDAO;
import com.tedu.mallserver.pojo.StudentDTO;
import com.tedu.mallserver.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentMapper studentMapper;

    @Override
    public Integer login(StudentDTO studentDTO) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("sno",studentDTO.getSno());
        queryWrapper.eq("password",studentDTO.getPassword());

        StudentDAO studentDAO = studentMapper.selectOne(queryWrapper);
        if(studentDAO != null)
            return studentDAO.getSno();
        else
            return -1;
    }
}
