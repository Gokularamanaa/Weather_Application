package com.example.weatherapp.demo.Entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Weather_data")
public class WeatherData {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private LocalDateTime timestamp;
	public LocalDateTime gettimestamp() {
		return timestamp;
	}
	public void setDate(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
	private String Condition;
	private Double Temperature;
	private Double Pressure;
	private Double Humidity;
	
	public String getCondition() {
		return Condition;
	}
	public void setCondition(String Condition) {
		this.Condition = Condition;
	}
	public Double getTemperature() {
		return Temperature;
	}
	public void setTemperature(Double Temperature) {
		this.Temperature = Temperature;
	}
	public Double getPressure() {
		return Pressure;
	}
	public void setPressure(Double Pressure) {
		this.Pressure = Pressure;
	}
	public Double getHumidity() {
		return Humidity;
	}
	public void setHumidity(Double Humidity) {
		this.Humidity = Humidity;
	}
	private Double heatIndex;
	public Double getHeatIndex() {
		return heatIndex;
	}
	public void setHeatIndex(Double heatIndex) {
		this.heatIndex = heatIndex;
	}
	public void setTimestamp(LocalDateTime localDateTime) {
		// TODO Auto-generated method stub
		
	}
}
