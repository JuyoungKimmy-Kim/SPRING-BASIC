package com.mycom.myapp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mycom.myapp.dto.EmpDto;

@Controller
public class ViewController {
	@GetMapping(value = "/viewTest1")
	public String viewTest1() {
		System.out.println("viewTest1");

		return "viewTest1";

		 // jsp 제외하고 보내면 됨 servelt-context-xml에 있는 prefix, suffix에 의해
	}

	@GetMapping(value = "/viewTest2")
	public String viewTest2() {
		System.out.println("viewTest2");

		return "sub/viewTest2";
	}

	// Model -- addAttribute!!
	@GetMapping(value = "/viewTest3")
	public String viewTest3(Model model) {
		System.out.println("viewTest3");
		model.addAttribute("seq", "12345");
		model.addAttribute("seq2", "Hello");
		model.addAttribute("empDto", new EmpDto(3000, "gildong6", "hong6", "h6@hong.com", "2022-10-19"));

		return "viewTest3";
	}

	// ModelAndView
	// addObject 
	@GetMapping(value = "/viewTest4")
	public ModelAndView viewTest4() {
		System.out.println("viewTest4");
		ModelAndView mav=new ModelAndView("viewTest4");
		mav.addObject("seq", "12345");
		mav.addObject("empDto",new EmpDto(3000, "gildong6", "hong6", "h6@hong.com", "2022-10-19") );
		//mav.setViewName("viewTest4");
		
		return mav;
	}
	
	//위의 과정은 forward의 내용
	
	//redirect
	@GetMapping("/redirect")
	public String redirect () {
		System.out.println("redirect");
		//return "viewTest1";
		return "redirect:/viewTest1";	
	}
}
