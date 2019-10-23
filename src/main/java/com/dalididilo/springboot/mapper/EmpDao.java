package com.dalididilo.springboot.mapper;


import com.dalididilo.springboot.bean.Employee;
import org.springframework.stereotype.Repository;


@Repository
public interface EmpDao {

    Employee getEmpById(Integer empId);

}
