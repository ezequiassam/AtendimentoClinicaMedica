package br.ucsal.processodesoftware.repositorio;

<<<<<<< HEAD
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.ucsal.processodesoftware.model.EstadoCivilEnum;
import br.ucsal.processodesoftware.model.Paciente;
import br.ucsal.processodesoftware.model.SexoEnum;

public class PacienteDAO {

	private static Connection connection;
	private static PreparedStatement preparedStatement;
	private static ResultSet resultSet;

	public static List<Paciente> pesquisaPacienteRG(String cpf) {
		// metodo de consulta no banco via rg
		String sql = "SELECT id_paciente,nome,sobrenome,nascimento,rg,cpf,sexo,estadocivil " + "FROM paciente "
				+ "WHERE cpf = " + cpf + ";";
		Paciente paciente = new Paciente();
		List<Paciente> listaPaciente = new ArrayList<>();
		try {
			connection = ConnectionFactory.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				paciente.setId(resultSet.getInt("id_paciente"));
				paciente.setNome(resultSet.getString("nome"));
				paciente.setSobrenome(resultSet.getString("sobrenome"));
				paciente.setNascimento(resultSet.getString("nascimento"));
				paciente.setRg(resultSet.getString("rg"));
				paciente.setCpf(resultSet.getInt("cpf"));
				paciente.setSexo(SexoEnum.valueOf(resultSet.getString("sexo")));
				paciente.setEstadoCivil(EstadoCivilEnum.valueOf(resultSet.getString("estadocivil")));
				listaPaciente.add(paciente);
			}

		} catch (SQLException e) {
			// TODO: handle exception
		} finally {
			try {
				resultSet.close();
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				// TODO: handle exception
			}
		}
		return listaPaciente;
	}

	public static Boolean cadastroPaciente(Paciente paciente) {
		boolean b = false;
		String sql = "INSERT INTO paciente(nome,sobrenome,nascimento,rg,cpf,sexo,estadocivil)"
				+ "VALUES (?,?,?,?,?,?,?)";
		try {
			connection = ConnectionFactory.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, paciente.getNome().trim().toUpperCase());
			preparedStatement.setString(2, paciente.getSobrenome().trim().toUpperCase());
			preparedStatement.setString(3, paciente.getNascimento().trim().toUpperCase());
			preparedStatement.setString(4, paciente.getRg().trim().toUpperCase());
			preparedStatement.setInt(5, paciente.getCpf());
			preparedStatement.setString(6, paciente.getSexo().toString());
			preparedStatement.setString(7, paciente.getEstadoCivil().toString());
			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				b = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				resultSet.close();
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return b;
=======
import br.ucsal.processodesoftware.model.Paciente;

public class PacienteDAO {

	public static Paciente pesquisaPacienteRG(String rg) {
		// metodo de consulta no banco rg
		Paciente paciente = new Paciente();
		return paciente;
>>>>>>> b7082cad4f62b640b36ab7579201f66fa724ce4a
	}
}
