package br.ucsal.processodesoftware.model;

import br.ucsal.processodesoftware.repositorio.EspecialidadeDAO;

public class Especialidade {

	private EspecialidadeDAO especialidadeDao = new EspecialidadeDAO();

	public String selecinarEspecialidade(Integer id) {
		String especialidade = especialidadeDao.pesquisarEspecialidade(id);
		return especialidade;
	}

}
