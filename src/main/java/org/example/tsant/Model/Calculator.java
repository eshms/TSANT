package org.example.tsant.Model;
import java.util.HashMap;
import java.util.Map;

public class Calculator {

    private final int totalCycleTime = 120;
    private final int yellowTime = 3;
    private final int minGreen = 10;
    private final int maxGreen = 60;


    public Map<String, Map<String, Integer>> calculateTimes(Map<String, Integer> vehicleMap) {
        Map<String, Map<String, Integer>> result = new HashMap<>();
        int totalVehicles = vehicleMap.values().stream().mapToInt(Integer::intValue).sum();

        for (Map.Entry<String, Integer> entry : vehicleMap.entrySet()) {
            String direction = entry.getKey();
            int vehicleCount = entry.getValue();

            int greenTime = (int) Math.round((double) vehicleCount / totalVehicles * (totalCycleTime - yellowTime));
            int redTime = totalCycleTime - greenTime - yellowTime;

            Map<String, Integer> times = new HashMap<>();
            times.put("GREEN", greenTime);
            times.put("YELLOW", yellowTime);
            times.put("RED", redTime);

            result.put(direction, times);
        }

        return result;
    }
}


