package com.choice.food.controller.admin;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.choice.food.model.admin.ConfigVO;

@RestController
@RequestMapping("/config")
public class ConfigController {
	
	@RequestMapping("/sendVO")
	public ConfigVO sayHello() {
		ConfigVO vo = new ConfigVO();
		vo.setFirstName("소연");
		vo.setLastName("Nk");
		vo.setMno(26);
		return vo;
	}
	
	
	
	@RequestMapping("/sendVOList")
	public List<ConfigVO> sayHello2() {
		List<ConfigVO> list = new ArrayList<>();
		for(int i=0; i<10; i++) {
		ConfigVO vo = new ConfigVO();
		vo.setFirstName("소연");
		vo.setLastName("Nk");
		vo.setMno(26);
		list.add(vo);
		}
		
		return list;
	}
	

}
