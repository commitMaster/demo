package com.example;

import com.example.entity.Product;
import com.example.repository.ProductRepository;
import org.springframework.aop.interceptor.SimpleTraceInterceptor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	CommandLineRunner runner (ProductRepository productRepository) {
		return args -> {
			Map<String, String> nameToDesc = new HashMap<>();
			nameToDesc.put("Apple MacBook Pro Retina 15", "Экран 15.4 IPS (2880x1800) Retina LED, глянцевый / " +
					"Intel Core i7 (2.8 ГГц) / RAM 16 ГБ / SSD 1 TБ / Intel Iris Pro Graphics + AMD Radeon R9 M370X" +
					", 2 ГБ / без ОД / Wi-Fi / Bluetooth / веб-камера / OS X Yosemite / 2.04 кг");
			nameToDesc.put("Apple iPhone 6s Plus 64GB Silver", "Экран (5.5, IPS, 1920x1080)/ Apple A9 (1.8 ГГц)/ " +
					"основная камера: 12 Мп, фронтальная камера: 5 Мп/ RAM 2 ГБ/ 64 ГБ встроенной памяти/ 3G/ LTE/ GPS/ Nano-SIM/ iOS 9/");
			for (String key : nameToDesc.keySet()) {
				productRepository.save(new Product(key, nameToDesc.get(key)));
			}
		};
	}
}
