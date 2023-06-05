package com.callfeign;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
class CallFeignApplicationTests {

    @Autowired
    private CallService callService;

    @Test
    void contextLoads() {
    }

    @Test
    void getEmp() {
        Employee emp = callService.getEmp(1L);
        log.info("Emp : {}", emp);
    }

    @Test
    void getEmps() {
        ResponseDTO responseDTO = callService.getEmpls();
        log.info("Emps : {}", responseDTO);
    }

    @Test
    void saveEmp() {
        Employee employee = callService.saveEmp();
        log.info("Save Emp : {}", employee);
    }

    @Test
    void getEmpById() {
        ResponseDTO responseDTO = callService.getEmpById();
        log.info("empById : {}", responseDTO);
    }

}
