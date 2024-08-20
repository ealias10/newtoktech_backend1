package com.example.demo.mapper;

import com.example.demo.modal.Country;
import com.example.demo.request.CountryRequest;
import com.example.demo.vo.CountryVO;

import java.util.List;
import java.util.stream.Collectors;

public class CountryMapper {

    public static Country getCountry(CountryRequest request)
    {
        return Country.builder().state(request.getState()).city(request.getCity()).district(request.getDistrict()).name(request.getName()).build();
    }
    public static CountryVO getCountryVO(Country country)
    {
        return CountryVO.builder().city(country.getCity()).district(country.getDistrict()).name(country.getName()).state(country.getState()).build();
    }
    public static List<CountryVO> getCountryList(List<Country> list)
    {
        return list.stream().map(CountryMapper::getCountryVO).collect(Collectors.toList());
    }
}
