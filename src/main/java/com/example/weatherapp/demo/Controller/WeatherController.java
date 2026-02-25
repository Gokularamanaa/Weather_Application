package com.example.weatherapp.demo.Controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.weatherapp.demo.Entity.WeatherData;
import com.example.weatherapp.demo.Repository.WeatherRepository;

@RestController
@RequestMapping("api/weather")
public class WeatherController {
	
	@Autowired
	private WeatherRepository repository;
	
	@GetMapping("/details")
	public ResponseEntity<List<WeatherData>> getDetails(@RequestParam(required=false) String date,@RequestParam(required=false) Integer month){
		if(date != null) {
			return ResponseEntity.ok(repository.findByDate(LocalDate.parse(date)));
		}
		if(month != null) {
			return ResponseEntity.ok(repository.findByMonth(month));
		}
		return ResponseEntity.badRequest().build();
	}
	
	@GetMapping("/stats/{year}")
	public List<Map<String, Object>> getYearlyStatus(@PathVariable int year){
		return repository.getMonthlyStatisticsOfYear(year);
	}
}
