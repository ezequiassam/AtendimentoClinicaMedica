package br.ucsal.processodesoftware.model;

<<<<<<< HEAD
public class Especialidade {

	private Integer id;
	private String nome;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
=======
import br.ucsal.processodesoftware.repositorio.EspecialidadeDAO;

public class Especialidade {

	private EspecialidadeDAO especialidadeDao = new EspecialidadeDAO();

	public String selecinarEspecialidade(Integer id) {
		String especialidade = especialidadeDao.pesquisarEspecialidade(id);
		return especialidade;
>>>>>>> b7082cad4f62b640b36ab7579201f66fa724ce4a
	}

}
