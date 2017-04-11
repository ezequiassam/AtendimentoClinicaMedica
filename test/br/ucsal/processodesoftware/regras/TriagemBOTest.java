package br.ucsal.processodesoftware.regras;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import br.ucsal.processodesoftware.model.Paciente;
import br.ucsal.processodesoftware.model.PrioridadeEnum;

public class TriagemBOTest {

	private TriagemBO triagembo;
	private Paciente paciente;

	@Before
	public void setUp() throws Exception {
		triagembo = new TriagemBO();
		paciente = new Paciente();
	}

	@Test
	public void testDefinirPrioridade() {
		triagembo.definirPrioridade(paciente, 1);
		assertEquals(PrioridadeEnum.EMERGENCIA, paciente.getTriagem().getPrioridadeEnum());
	}


}
