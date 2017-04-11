package br.ucsal.processodesoftware.model;

public class Triagem {

	private String sintomas;
	private PrioridadeEnum prioridadeEnum;

	public String getSintomas() {
		return sintomas;
	}

	public void setSintomas(String sintomas) {
		this.sintomas = sintomas;
	}

	public PrioridadeEnum getPrioridadeEnum() {
		return prioridadeEnum;
	}

	public void setPrioridadeEnum(PrioridadeEnum prioridadeEnum) {
		this.prioridadeEnum = prioridadeEnum;
	}

}
