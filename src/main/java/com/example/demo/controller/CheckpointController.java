package com.example.demo.controller;

import java.util.HashSet;
import java.util.Set;

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

	@PostMapping("/single-number")
	public int findSingleNumber(@RequestBody int[] nums) {
		Set<Integer> set = new HashSet<>();
		int sum = 0;
		for (int num : nums) {
			if (set.add(num)) {
				sum += num;
			} else {
				sum -= num;
			}
		}
		return sum;
	}

	@PostMapping("/max-consecutive-ones")
	public int findMaxConsecutiveOnes(@RequestBody int[] nums) {
		int maiorValorEncontrado = 0;
		int contador = 0;
		for (int i : nums) {
			if (i == 1) {
				contador++;
			} else {
				contador = 0;
			}
			maiorValorEncontrado = Math.max(maiorValorEncontrado, contador);
		}
		return maiorValorEncontrado;
	}

}
