package com.choice.food.controller.util;

import java.security.PrivateKey;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.choice.food.util.RSA;
import com.choice.food.util.RSAUtil;

@Controller
@RequestMapping("admin/*")
public class UtilController {
	// 로그인 페이지 진입

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginForm(HttpSession session, Model model) {

	    // RSA 키 생성
	    PrivateKey key = (PrivateKey) session.getAttribute("RSAprivateKey");

	    if (key != null) { // 기존 key 파기s
	        session.removeAttribute("RSAprivateKey");
	    }
	    RSAUtil rsaUtil;
	  /*  RSA rsa = rsaUtil.createRSA();

	    model.addAttribute("modulus", rsa.getModulus());
	    model.addAttribute("exponent", rsa.getExponent());
	    session.setAttribute("RSAprivateKey", rsa.getPrivateKey());*/
	    return "login";

	}
	
}
