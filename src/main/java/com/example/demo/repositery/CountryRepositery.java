package com.example.demo.repositery;

import com.example.demo.modal.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

public interface CountryRepositery extends JpaRepository<Country, UUID> {

    @Query("select c from Country c where c.name=:name")
    Country getCountryByName(@Param("name") String name);

    @Query("select c from Country c where c.state=:name")
    Country getCountryByState(@Param("name") String name);

    @Query("select c from Country c where c.city=:city")
    Country getCountryByCity(@Param("city")String city);

}
