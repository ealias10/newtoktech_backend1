package com.example.demo.repositery;

import com.example.demo.modal.Weather;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface WeatherReposiery extends JpaRepository<Weather, UUID> {
}
