package com.example.demo.controller;

import com.example.demo.exception.CountryExistException;
import com.example.demo.exception.CountryNotFountException;
import com.example.demo.request.CountryRequest;
import com.example.demo.service.CountryService;
import com.example.demo.vo.CountryVO;
import com.example.demo.vo.FileUploadVO;
import com.example.demo.vo.ResponseVO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/country")
public class CountryController {

    @Autowired
    CountryService countryService;

    @PostMapping("/create")
    public ResponseEntity<ResponseVO<Object>> createCountry(@RequestBody(required = true)CountryRequest request) throws CountryExistException {
        ResponseVO responseVO=new ResponseVO<>();
        CountryVO countryVO=countryService.createCountry(request);
        responseVO.addData(countryVO);
        return new ResponseEntity<>(responseVO, HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity<ResponseVO<CountryVO>> getAllCountry(
            @RequestParam(value = "country", required = false) String country,
            @RequestParam(value = "state", required = false) String state,
            @RequestParam(value = "city", required = false) String city)
    {
            ResponseVO responseVO=new ResponseVO<>();
            List<CountryVO> countryVOList=countryService.getAllCountry(country,state,city);
            responseVO.addDataList(countryVOList);
            return new ResponseEntity<>(responseVO,HttpStatus.OK);
    }

    @PutMapping("/upload/{city}")
    public ResponseEntity<ResponseVO<Object>> createEmployee(
            @PathVariable("city")String city,
           @RequestPart("file") MultipartFile file) throws CountryNotFountException, IOException {
        ResponseVO<Object> response = new ResponseVO<>();
        FileUploadVO fileUploadVO=countryService.saveWeather(file,city);
        response.addData(fileUploadVO);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
