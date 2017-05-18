package br.ucsal.processodesoftware.regras;

import static org.junit.Assert.*;

import org.junit.Before;
<<<<<<< HEAD
import org.junit.BeforeClass;
import org.junit.Test;

import br.ucsal.processodesoftware.exception.EspecialidadeNaoEncontradaException;
import br.ucsal.processodesoftware.exception.PacienteNaoEncontradoException;
import br.ucsal.processodesoftware.model.Endereco;
import br.ucsal.processodesoftware.model.EstadoCivilEnum;
import br.ucsal.processodesoftware.model.Paciente;
import br.ucsal.processodesoftware.model.PrioridadeEnum;
import br.ucsal.processodesoftware.model.SexoEnum;
import br.ucsal.processodesoftware.repositorio.BancoUtil;
import br.ucsal.processodesoftware.repositorio.EspecialidadeDAO;
import br.ucsal.processodesoftware.repositorio.PacienteDAO;

public class TriagemBOTest {

	private static TriagemBO triagembo;
	private static Paciente paciente;

	@BeforeClass
	public static void setUpClass() {
		BancoUtil banco = new BancoUtil();
		EspecialidadeDAO.cadastroEspecialidade("Geral");
		paciente = new Paciente("ezequias", "sampaio", "03/11/1994", "123", 321, SexoEnum.MASCULINO, EstadoCivilEnum.SOLTEIRO, new Endereco());
		PacienteDAO.cadastroPaciente(paciente);
		
		triagembo = new TriagemBO();
	}
//	
//	@Before
//	public void setUp() {
//		
//		
//	}

	// @Test
	// public void testDefinirPrioridade() {
	//// triagembo.definirPrioridade(paciente, 1);
	// assertEquals(PrioridadeEnum.EMERGENCIA,
	// paciente.getTriagem().getPrioridadeEnum());
	// }
	@Test
	public void testTriagemPaciente() throws PacienteNaoEncontradoException, EspecialidadeNaoEncontradaException {
		triagembo.triagemPaciente("123", 1, "geral");
	}

=======
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


>>>>>>> b7082cad4f62b640b36ab7579201f66fa724ce4a
}
