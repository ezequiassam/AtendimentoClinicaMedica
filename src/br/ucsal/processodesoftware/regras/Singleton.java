package br.ucsal.processodesoftware.regras;

import br.ucsal.processodesoftware.model.Especialidade;
import br.ucsal.processodesoftware.model.Triagem;
import br.ucsal.processodesoftware.repositorio.BancoUtil;

public class Singleton {
	private static Triagem triagem;
	private static FilaAtendimentoBO filaAtendimento;
	private static BancoUtil bancoUtil;
	private static Especialidade especialidade;

	public static Triagem getTriagem() {
		if (triagem == null) {
			triagem = new Triagem();
		}
		return triagem;
	}

	public static FilaAtendimentoBO getFilaAtendimento() {
		if (filaAtendimento == null) {
			filaAtendimento = new FilaAtendimentoBO();
		}
		return filaAtendimento;
	}

	public static BancoUtil getBancoUtil() {
		if (bancoUtil == null) {
			bancoUtil = new BancoUtil();
		}
		return bancoUtil;
	}

	public static Especialidade getEspecialidade() {
		if (especialidade == null) {
			especialidade = new Especialidade();
		}
		return especialidade;
	}
}
