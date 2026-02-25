package com.example.weatherapp.demo.ServiceImplementation;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.weatherapp.demo.Entity.WeatherData;
import com.example.weatherapp.demo.Repository.WeatherRepository;
import com.example.weatherapp.demo.Service.WeatherService;

@Service
public class WeatherServiceImplementation implements WeatherService {
    
    @Autowired 
    private WeatherRepository repository;

    public void importCsvData(String filePath) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd-HH:mm");
        
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine(); // Skip header
            while ((line = br.readLine()) != null) {
                String[] cols = line.split(",", -1);
                
                WeatherData record = new WeatherData();
                record.setTimestamp(LocalDateTime.parse(cols[0].trim(), formatter));
                record.setCondition(cols[1]);
                record.setHumidity(parseOptional(cols[6]));
                record.setPressure(parseOptional(cols[8]));
                record.setTemperature(parseOptional(cols[11]));
                record.setHeatIndex(parseOptional(cols[5]));
                
                repository.save(record);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Double parseOptional(String val) {
        if (val == null || val.trim().isEmpty() || val.trim().equals("-9999")) {
            return null;
        }
        return Double.parseDouble(val.trim());
    }

    @Override
    public List<WeatherData> getDetails(LocalDate date) {
        return repository.findByDate(date);
    }
}
