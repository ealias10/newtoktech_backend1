package com.example.demo.controller;


import com.example.demo.exception.UserNotFoundException;
import com.example.demo.request.LoginRequest;
import com.example.demo.service.UserSevice;
import com.example.demo.vo.LoginVO;
import com.example.demo.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserSevice userSevice;

    @PostMapping("/login")
    public ResponseEntity<ResponseVO<Object>> login(@RequestBody(required = true)LoginRequest request) throws UserNotFoundException {
      ResponseVO responseVO=new ResponseVO<>();
      LoginVO  loginVO=userSevice.createLogIn(request);
      responseVO.addData(loginVO);
      System.out.println(loginVO);
      return new ResponseEntity<>(responseVO,HttpStatus.OK);
    }



}
