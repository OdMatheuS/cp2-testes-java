package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/checkpoint")
public class CheckpointController {

	@PostMapping("/validate-parentheses")
	public boolean validateParentheses(@RequestBody String input) {
		try {
			int contador = 0;
			for (char caractere : input.toCharArray()) {
				if (caractere == '(') {
					contador++;
				} else if (caractere == ')') {
					contador--;

					if (contador < 0) {
						return false;
					}
				}
			}
			return contador == 0;
		} catch (Exception e) {
			return false;
		}
	}

}
