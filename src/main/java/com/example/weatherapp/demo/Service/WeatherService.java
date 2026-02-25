package com.example.weatherapp.demo.Service;

import java.time.LocalDate;
import java.util.List;

import com.example.weatherapp.demo.Entity.WeatherData;

public interface WeatherService {

	List<WeatherData> getDetails(LocalDate date);
}
