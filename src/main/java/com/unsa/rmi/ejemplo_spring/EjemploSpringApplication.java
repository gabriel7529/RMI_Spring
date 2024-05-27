package com.unsa.rmi.ejemplo_spring;

import com.unsa.rmi.ejemplo_spring.service.CalculatorService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.remoting.rmi.RmiProxyFactoryBean;

import java.rmi.RemoteException;

@SpringBootApplication
public class EjemploSpringApplication {
	@Bean
	RmiProxyFactoryBean rmiProxy() {
		RmiProxyFactoryBean bean = new RmiProxyFactoryBean();
		bean.setServiceInterface(CalculatorService.class);
		bean.setServiceUrl("rmi://localhost:1099/CalculatorServices");
		return bean;
	}
	public static void main(String[] args) throws RemoteException {

		CalculatorService calculatorService = SpringApplication.run(EjemploSpringApplication.class, args)
				.getBean(CalculatorService.class);

		int resultAdd = calculatorService.add(5, 3);
		int resultSubtract = calculatorService.subtract(5, 3);
		System.out.println("Addition result: " + resultAdd);
		System.out.println("Subtraction result: " + resultSubtract);
	}

}
