package com.mycom.myapp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mycom.myapp.dto.CarDto;

@Controller
public class CarController {
	@PostMapping(value="/car")
	public void m1 (@RequestBody CarDto dto) {
		System.out.println(dto);
	}
	
	@PostMapping (value="/carList")
	public void m2 (@RequestBody List<CarDto> carList) {
		for (CarDto carDto : carList) {
			System.out.println(carDto);
		}
	}
	
	@GetMapping (value="/carDetail/{carId}")
	@ResponseBody
	public CarDto m3 (@PathVariable int carId) {
		System.out.println(carId);
		CarDto carDto=new CarDto ("volvo", 300, "Juyoung");
		return carDto;
	}
	
	@GetMapping("/carList")
	@ResponseBody
	public List<CarDto> m4 () {
		List<CarDto> list=new ArrayList<>();
		
		return list;
	}
}
