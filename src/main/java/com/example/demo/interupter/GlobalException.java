package com.example.demo.interupter;


import com.example.demo.exception.DemoException;
import com.example.demo.utility.Constiont;
import com.example.demo.vo.ErrorVO;
import com.example.demo.vo.ResponseVO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalException {


    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    @ExceptionHandler(DemoException.class)
    public ResponseEntity<ResponseVO<Object>> demoExcpetion(DemoException demoException)
    {
        ErrorVO errorVO=new ErrorVO();
        errorVO.setErrorCode(demoException.getErrorCode());
        errorVO.setDisplayTitle(demoException.getDisplayTitle());
        errorVO.setStatus(demoException.getStatus().value());
        ResponseVO responseVO=new ResponseVO<>();
        responseVO.setError(errorVO);
        responseVO.setStutus(demoException.getStatus().value());
        responseVO.setMessage(demoException.getMessage());
        return new ResponseEntity<>(responseVO,demoException.getStatus());
    }

    public static byte[] getUnauthorizedResponseForAuthFilterErrors(Exception exception) {
        ErrorVO errorVO = new ErrorVO();
        errorVO.getErrors().add(exception.getMessage());
        if (exception instanceof DemoException) {
            errorVO.setErrorCode(((DemoException) exception).getErrorCode());
        } else {
            errorVO.setErrorCode(Constiont.UNAUTHORIZED_ERROR_CODE);
        }
        ResponseVO<Object> responseVO = new ResponseVO<>();
        responseVO.setStutus(HttpStatus.UNAUTHORIZED.value());
        responseVO.setMessage(HttpStatus.UNAUTHORIZED.getReasonPhrase());
        responseVO.setError(errorVO);
        String responseString = convertToJsonString(responseVO);
        return responseString.getBytes();
    }

    private static String convertToJsonString(ResponseVO<Object> response) {
        String responseString = null;
        try {
            responseString = OBJECT_MAPPER.writeValueAsString(response);
        } catch (JsonProcessingException e) {
            responseString = response.toString();
        }
        return responseString;
    }
}
