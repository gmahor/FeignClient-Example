package com.callfeign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Service
@FeignClient(name = "EMP-SERVICE", url = "http://localhost:8181")
public interface FeignClientService {

    @PostMapping("/emp/saveEmp")
    Employee saveEmp(@RequestBody Map<String, Object> emDto);

    @GetMapping("/emp/getEmp/{empId}")
    Employee getEmp(@PathVariable(name = "empId") Long empId);


    @GetMapping("/emp/getEmps")
    ResponseDTO getEmps();

    @GetMapping("/emp/getEmp")
    ResponseDTO getEmpById(@RequestParam(name = "empId") Long empId);

}
