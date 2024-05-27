package com.unsa.rmi.ejemplo_spring.client;


import com.unsa.rmi.ejemplo_spring.service.CalculatorService;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RmiClient {
    public static void main(String[] args) {
        try {

            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            CalculatorService calculatorService = (CalculatorService) registry.lookup("CalculatorService");

            int resultAdd = calculatorService.add(5, 3);
            int resultSubtract = calculatorService.subtract(5, 3);
            System.out.println("Addition result: " + resultAdd);
            System.out.println("Subtraction result: " + resultSubtract);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
