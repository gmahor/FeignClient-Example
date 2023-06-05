package com.callfeign;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
public class CallService {

    @Autowired
    private FeignClientService feignClientService;

    public Employee getEmp(Long id) {
        return feignClientService.getEmp(id);
    }

    public ResponseDTO getEmpls() {
        return feignClientService.getEmps();
    }

    public Employee saveEmp() {
/*
        "empName": "gourav",
        "email":"gouravmahor60@gmail.com",
        "phone":"8447727798"
*/
        Map<String, Object> map = new HashMap<>();
        map.put("empName", "saima");
        map.put("email", "saima965@yopmail.com");
        map.put("phone", "8447727798");

        return feignClientService.saveEmp(map);
    }

    public ResponseDTO getEmpById() {
        return feignClientService.getEmpById(2L);
    }


}
