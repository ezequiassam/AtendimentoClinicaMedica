package br.ucsal.processodesoftware.regras;

import java.util.LinkedList;
import java.util.List;

import br.ucsal.processodesoftware.model.Paciente;
import br.ucsal.processodesoftware.model.PrioridadeEnum;

public class FilaAtendimentoBO {
	private static List<Paciente> filaEmergencia = new LinkedList<>();
	private static List<Paciente> filaUrgencia = new LinkedList<>();
	private static List<Paciente> filaNormal = new LinkedList<>();

	public static void adicionarPacienteNaFila(Paciente paciente) {
		if (paciente.getTriagem() != null && paciente.getEspecialidade() != null) {
			if (paciente.getTriagem().getPrioridadeEnum().equals(PrioridadeEnum.EMERGENCIA)) {
				filaEmergencia.add(paciente);
			} else if (paciente.getTriagem().getPrioridadeEnum().equals(PrioridadeEnum.URGENCIA)) {
				filaUrgencia.add(paciente);
			} else {
				filaNormal.add(paciente);
			}

		}
	}

	public static Paciente atenderProximoPaciente() {
		Paciente paciente = null;
		if (!filaEmergencia.isEmpty()) {
			paciente = filaEmergencia.get(0);
			filaEmergencia.remove(0);
		} else if (!filaUrgencia.isEmpty()) {
			paciente = filaUrgencia.get(0);
			filaUrgencia.remove(0);
		} else if (!filaNormal.isEmpty()) {
			paciente = filaNormal.get(0);
			filaNormal.remove(0);
		}
		return paciente;
	}

	public static List<Paciente> getFilaAtendimento() {
		List<Paciente> filaAtendimento = new LinkedList<>();
		if (!filaEmergencia.isEmpty()) {
			for (Paciente paciente : filaEmergencia) {
				filaAtendimento.add(paciente);
			}
		} else if (!filaUrgencia.isEmpty()) {
			for (Paciente paciente : filaUrgencia) {
				filaAtendimento.add(paciente);
			}
		} else if (!filaNormal.isEmpty()) {
			for (Paciente paciente : filaNormal) {
				filaAtendimento.add(paciente);
			}
		}
		return filaAtendimento;
	}

}
