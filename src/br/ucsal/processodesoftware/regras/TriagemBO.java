package br.ucsal.processodesoftware.regras;

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
			triagem.setPrioridadeEnum(PrioridadeEnum.URGENCIA);
		} else {
			triagem.setPrioridadeEnum(PrioridadeEnum.NORMAL);
		}
		paciente.setTriagem(triagem);
	}
}
