package com.example.demo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.controller.CheckpointController;

@SpringBootTest
class CpdoisApplicationTests {

	@Autowired
	private CheckpointController cpController;

	@Test
	public void testeValidateParenthesesSucesso() {
		assertTrue(cpController.validateParentheses("()*()"));
		assertTrue(cpController.validateParentheses("(()127.0.0.1())"));
		assertTrue(cpController.validateParentheses("()"));
		assertTrue(cpController.validateParentheses(""));
		// sim é um hello world em lisp :) !!
		assertTrue(cpController.validateParentheses("(format t 'Hello, World!)"));
	}

	@Test
	public void testeValidateParenthesesExcessao() {
		assertFalse(cpController.validateParentheses(")("));
		assertFalse(cpController.validateParentheses("()3("));
		assertFalse(cpController.validateParentheses("()1)("));
		assertFalse(cpController.validateParentheses(")("));
	}

	@Test
	public void testeFindSingleNumberSuccesso() {
		int[] conjunto = { 1, 2, 3, 2, 1 };
		int valorEsperado = 3;
		int resultado = cpController.findSingleNumber(conjunto);
		assertEquals(valorEsperado, resultado);
	}

	@Test
	public void testeFindSingleNumberExcessao() {
		int[] conjunto = { 2, 2, 3, 3, 4, 4, 1 };
		int valorEsperado = 4;
		int resultado = cpController.findSingleNumber(conjunto);
		assertNotEquals(valorEsperado, resultado);
	}

}
