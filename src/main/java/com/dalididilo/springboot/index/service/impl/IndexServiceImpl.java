package com.dalididilo.springboot.index.service.impl;

import com.dalididilo.springboot.index.bean.Employee;
import com.dalididilo.springboot.index.dao.IndexDao;
import com.dalididilo.springboot.index.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IndexServiceImpl implements IndexService {


    @Autowired
    private IndexDao idexDao;


    @Override
    public Employee getEmpById(Integer empId) {
        return idexDao.getEmpById(empId);
    }
}
