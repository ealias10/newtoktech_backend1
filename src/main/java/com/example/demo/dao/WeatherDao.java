package com.example.demo.dao;


import com.example.demo.modal.Weather;
import com.example.demo.repositery.WeatherReposiery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class WeatherDao {
    @Autowired
    WeatherReposiery weatherReposiery;
    public List<Weather> createWeather(List<Weather> list)
    {
        return weatherReposiery.saveAll(list);
    }
}
