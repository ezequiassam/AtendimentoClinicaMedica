package br.ucsal.processodesoftware.repositorio;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BancoUtilTest {
	BancoUtil bancoUtil;
	@Before
	public void setUp() throws Exception {
		bancoUtil = new BancoUtil();
	}

	@Test
	public void testCriarEspecialidade() {
		assertTrue(bancoUtil.criarEspecialidade());
		assertFalse(bancoUtil.criarEspecialidade());
	}

	@Test
	public void testCriarEndereco() {
		assertTrue(bancoUtil.criarEndereco());
		assertFalse(bancoUtil.criarEndereco());
	}

	@Test
	public void testCriarPaciente() {
		assertTrue(bancoUtil.criarPaciente());
		assertFalse(bancoUtil.criarPaciente());
	}

}
