package com.example.demo.dao;

import com.example.demo.modal.Country;
import com.example.demo.repositery.CountryRepositery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CountryDao {
    @Autowired
    CountryRepositery countryRepositery;

    public Country saveCountry(Country country)
    {
        return countryRepositery.save(country);
    }
    public List<Country> getAllCountry()
    {
        return countryRepositery.findAll();
    }

    public Country getCountryByName(String name)
    {
        return countryRepositery.getCountryByName(name);
    }

    public Country getCountryByCity(String city)
    {
        return countryRepositery.getCountryByCity(city);
    }

}
