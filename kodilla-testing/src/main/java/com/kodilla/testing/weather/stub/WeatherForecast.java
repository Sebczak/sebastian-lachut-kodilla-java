package com.kodilla.testing.weather.stub;

import java.util.*;

public class WeatherForecast {

    private Temperatures temperatures;

    public WeatherForecast(Temperatures temperatures) {
        this.temperatures = temperatures;
    }

    public Map<String, Double> calculateForecast() {
        Map<String, Double> resultMap = new HashMap<>();

        for(Map.Entry<String, Double> temperature : temperatures.getTemperatures().entrySet()) {
            resultMap.put(temperature.getKey(), temperature.getValue() + 1.0);
        }
        return resultMap;
    }

    public double calculateForecastAvg() {
        double result = 0;

        for (Map.Entry<String, Double> temperature : temperatures.getTemperatures().entrySet()) {
            result += temperature.getValue() / temperatures.getTemperatures().size();
        }

        return result;
    }

    public double calculateForecastMedian() {
        List<Double> values = new ArrayList<>(temperatures.getTemperatures().values());

        Collections.sort(values);

        int n = values.size();
        if (n % 2 == 0) {
            return (values.get(n / 2 - 1) + values.get(n / 2)) / 2.0;
        } else {
            return values.get(n / 2);
        }
    }
}
