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
		int[] primeiroConjunto = { 1, 2, 3, 2, 1 };
		int primeiroResultado = cpController.findSingleNumber(primeiroConjunto);
		assertEquals(3, primeiroResultado);

		int[] segundoConjunto = { 3, 1, 3, 5, 1 };
		int segundoResultado = cpController.findSingleNumber(segundoConjunto);
		assertEquals(5, segundoResultado);
	}

	@Test
	public void testeFindSingleNumberExcessao() {
		int[] conjunto = { 2, 2, 3, 3, 4, 4, 1 };
		int valorEsperado = 4;
		int resultado = cpController.findSingleNumber(conjunto);
		assertNotEquals(valorEsperado, resultado);

		int[] segundoConjunto = { 11, 22, 33, 5, 22 };
		int segundoResultado = cpController.findSingleNumber(segundoConjunto);
		assertNotEquals(22, segundoResultado);
	}

	@Test
	public void findMaxConsecutiveOnesSuccesso() {
		int[] conjunto = { 1, 1, 0, 1, 1, 1 };
		int resultado = cpController.findMaxConsecutiveOnes(conjunto);
		assertEquals(3, resultado);

		//cep top!! 
		int[] segundoConjunto = { 0, 1, 1, 0, 1, 0, 1, 0 };
		int segundoResultado = cpController.findMaxConsecutiveOnes(segundoConjunto);
		assertEquals(2, segundoResultado);
	}

	@Test
	public void findMaxConsecutiveOnesExcessao() {
		int[] conjunto = { 0, 0, 0, 0, 0 };
		int resultado = cpController.findMaxConsecutiveOnes(conjunto);
		assertNotEquals(1, resultado);
	}

}
