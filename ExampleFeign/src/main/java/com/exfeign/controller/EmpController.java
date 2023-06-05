package com.exfeign.controller;

import com.exfeign.dto.EmpDTO;
import com.exfeign.entity.Employee;
import com.exfeign.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/emp")
public class EmpController {

    @Autowired
    private EmpService empService;

    public ResponseEntity<Object> generateResponse(Object response, String messageCode,
                                                   boolean isSuccess, HttpStatus httpStatus) {
        Map<String, Object> map = new HashMap<>();
        map.put("data", response);
        map.put("message", messageCode);
        map.put("isSuccess", isSuccess);
        map.put("timeStamp", new Date().getTime());
        return new ResponseEntity<>(map, httpStatus);
    }

    @PostMapping(value = "/saveEmp")
    public ResponseEntity<Object> saveEmp(@RequestBody EmpDTO empDTO) {
        Employee employee = empService.saveEmp(empDTO);
        return ResponseEntity.status(HttpStatus.OK).body(employee);
    }

    @GetMapping(value = "/getEmp/{empId}")
    public ResponseEntity<Object> getEmp(@PathVariable(name = "empId") Long empId) {
        Employee emp = empService.getEmp(empId);
        if (emp != null)
            return ResponseEntity.status(HttpStatus.OK).body(emp);
        else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @GetMapping(value = "/getEmps")
    public ResponseEntity<Object> getEmp() {
        List<Employee> emps = empService.getEmps();
        return generateResponse(emps, "all emps", true, HttpStatus.OK);
    }

    @GetMapping(value = "/getEmp")
    public ResponseEntity<Object> getEmpById(@RequestParam(name = "empId") Long empId) {
        Employee emp = empService.getEmp(empId);
        if (emp != null)
            return generateResponse(emp, "Fetched Successfully", true, HttpStatus.OK);
        else
            return generateResponse("", "Error while Fetching Emp", false, HttpStatus.BAD_REQUEST);
    }
}
