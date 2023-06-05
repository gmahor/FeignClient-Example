package com.exfeign.service;

import com.exfeign.dto.EmpDTO;
import com.exfeign.entity.Employee;
import com.exfeign.repository.EmpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpService {

    @Autowired
    private EmpRepository empRepository;

    public Employee saveEmp(EmpDTO empDTO) {
        Employee employee = Employee
                .builder()
                .empName(empDTO.getEmpName())
                .email(empDTO.getEmail())
                .phone(empDTO.getPhone())
                .build();
        return empRepository.save(employee);
    }


    public Employee getEmp(Long id) {
        return empRepository.findById(id).orElse(null);
    }


    public List<Employee> getEmps() {
        return empRepository.findAll();
    }


}
