package br.ucsal.processodesoftware.model;

import br.ucsal.processodesoftware.repositorio.PacienteDAO;

public class Paciente {

	private Integer id;
	private String nome;
	private String sobrenome;
	private String nascimento;
	private String rg;
	private Integer cpf;
	private SexoEnum sexo;
	private EstadoCivilEnum estadoCivil;
	private Endereco endereco;
	private Especialidade especialidade;
	private Triagem triagem;

	public Paciente() {

	}

	public Paciente(Integer id, String nome, String sobrenome, String nascimento, String rg, Integer cpf, SexoEnum sexo,
			EstadoCivilEnum estadoCivil, Endereco endereco, Especialidade especialidade) {
		super();
		this.id = id;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.nascimento = nascimento;
		this.rg = rg;
		this.cpf = cpf;
		this.sexo = sexo;
		this.estadoCivil = estadoCivil;
		this.endereco = endereco;
		this.especialidade = especialidade;
	}

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
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getNascimento() {
		return nascimento;
	}

	public void setNascimento(String nascimento) {
		this.nascimento = nascimento;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public Integer getCpf() {
		return cpf;
	}

	public void setCpf(Integer cpf) {
		this.cpf = cpf;
	}

	public SexoEnum getSexo() {
		return sexo;
	}

	public void setSexo(SexoEnum sexo) {
		this.sexo = sexo;
	}

	public EstadoCivilEnum getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(EstadoCivilEnum estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Especialidade getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(Especialidade especialidade) {
		this.especialidade = especialidade;
	}

	public Paciente buscaPaciente(String rg) {
		return PacienteDAO.pesquisaPacienteRG(rg);
	}

	public Triagem getTriagem() {
		return triagem;
	}

	public void setTriagem(Triagem triagem) {
		this.triagem = triagem;
	}

}
