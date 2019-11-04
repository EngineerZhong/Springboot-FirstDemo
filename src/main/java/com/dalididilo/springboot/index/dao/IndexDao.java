package com.dalididilo.springboot.index.dao;


import com.dalididilo.springboot.index.bean.Employee;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

@Repository
public interface IndexDao {



    Employee getEmpById(Integer empId);


}
