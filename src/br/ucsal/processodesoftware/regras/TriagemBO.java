package br.ucsal.processodesoftware.regras;

<<<<<<< HEAD
import br.ucsal.processodesoftware.exception.EspecialidadeNaoEncontradaException;
import br.ucsal.processodesoftware.exception.PacienteNaoEncontradoException;
import br.ucsal.processodesoftware.model.Especialidade;
import br.ucsal.processodesoftware.model.Paciente;
import br.ucsal.processodesoftware.model.PrioridadeEnum;
import br.ucsal.processodesoftware.model.Triagem;
import br.ucsal.processodesoftware.repositorio.EspecialidadeDAO;
import br.ucsal.processodesoftware.repositorio.PacienteDAO;

public class TriagemBO {
	private Triagem triagem = Singleton.getTriagem();
	private Especialidade especialidade = Singleton.getEspecialidade();

	public void triagemPaciente(String cpfPaciente, Integer tipoPrioridade, String nomeEspecialiade)
			throws PacienteNaoEncontradoException, EspecialidadeNaoEncontradaException {
		Paciente paciente = PacienteDAO.pesquisaPacienteRG(cpfPaciente).get(0);
		if (paciente == null) {
			throw new PacienteNaoEncontradoException();
		} else {
			definirPrioridade(paciente, tipoPrioridade);
			definirEspecialiade(paciente, nomeEspecialiade);
			FilaAtendimentoBO.adicionarPacienteNaFila(paciente);
		}
	}

	// adicionar outras condiçoes de prioridade
	private void definirPrioridade(Paciente paciente, Integer tipoPrioridade) {
		if (tipoPrioridade == 1) {
			triagem.setPrioridadeEnum(PrioridadeEnum.EMERGENCIA);
		} else if (tipoPrioridade == 2) {
=======
import br.ucsal.processodesoftware.model.Paciente;
import br.ucsal.processodesoftware.model.PrioridadeEnum;
import br.ucsal.processodesoftware.model.Triagem;

public class TriagemBO {
	Triagem triagem = new Triagem();

	// adicionar outras condiçoes de prioridade
	public void definirPrioridade(Paciente paciente, Integer tipo) {
		if (tipo == 1) {
			triagem.setPrioridadeEnum(PrioridadeEnum.EMERGENCIA);
		} else if (tipo == 2) {
>>>>>>> b7082cad4f62b640b36ab7579201f66fa724ce4a
			triagem.setPrioridadeEnum(PrioridadeEnum.URGENCIA);
		} else {
			triagem.setPrioridadeEnum(PrioridadeEnum.NORMAL);
		}
		paciente.setTriagem(triagem);
	}
<<<<<<< HEAD

	private void definirEspecialiade(Paciente paciente, String nomeEspecialiade)
			throws EspecialidadeNaoEncontradaException {
		especialidade = EspecialidadeDAO.pesquisarEspecialidade(nomeEspecialiade).get(0);
		if (especialidade != null) {
			paciente.setEspecialidade(especialidade);
		} else {
			throw new EspecialidadeNaoEncontradaException();
		}
	}

=======
>>>>>>> b7082cad4f62b640b36ab7579201f66fa724ce4a
}
