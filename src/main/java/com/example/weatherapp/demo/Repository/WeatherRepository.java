package com.example.weatherapp.demo.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.example.weatherapp.demo.Entity.WeatherData;

public interface WeatherRepository extends JpaRepository<WeatherData, Long> {

    @Query("SELECT w FROM WeatherData w WHERE CAST(w.timestamp AS date) = :date")
    List<WeatherData> findByDate(@Param("date") LocalDate date);

    @Query("SELECT w FROM WeatherData w WHERE MONTH(w.timestamp) = :month")
    List<WeatherData> findByMonth(@Param("month") Integer month);

    @Query(value = "SELECT MONTH(timestamp) as month, MAX(temperature) as high, " + "MIN(temperature) as low, AVG(temperature) as average " +
           "FROM weather_data WHERE YEAR(timestamp) = :year GROUP BY MONTH(timestamp)", nativeQuery = true)
    List<Map<String, Object>> getMonthlyStatisticsOfYear(@Param("year") int year);
}