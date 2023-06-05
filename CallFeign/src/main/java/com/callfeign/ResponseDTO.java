package com.callfeign;

import lombok.Data;

@Data
public class ResponseDTO {

    private String timeStamp;

    private Object data;

    private String message;

    private String isSuccess;

}
