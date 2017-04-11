package br.ucsal.processodesoftware.regras;

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
			triagem.setPrioridadeEnum(PrioridadeEnum.URGENCIA);
		} else {
			triagem.setPrioridadeEnum(PrioridadeEnum.NORMAL);
		}
		paciente.setTriagem(triagem);
	}

	private void definirEspecialiade(Paciente paciente, String nomeEspecialiade)
			throws EspecialidadeNaoEncontradaException {
		especialidade = EspecialidadeDAO.pesquisarEspecialidade(nomeEspecialiade).get(0);
		if (especialidade != null) {
			paciente.setEspecialidade(especialidade);
		} else {
			throw new EspecialidadeNaoEncontradaException();
		}
	}

}
