package br.ucsal.processodesoftware.repositorio;

<<<<<<< HEAD
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.ucsal.processodesoftware.model.Especialidade;

public class EspecialidadeDAO {

	private static Connection connection;
	private static PreparedStatement preparedStatement;
	private static ResultSet resultSet;

	public static Boolean cadastroEspecialidade(String nome) {
		Boolean b = false;
		String sql = "INSERT INTO especialiade(nome) VALUES(?);";

		try {
			connection = ConnectionFactory.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, nome.trim().toUpperCase());
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				b = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				resultSet.close();
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return b;
	}

	public static List<Especialidade> pesquisarEspecialidade(String nomeEspecialidade) {
		String sql = "SELECT id_especialidade,nome FROM especialidade " + "WHERE nome = " + nomeEspecialidade.trim().toUpperCase() + ";";
		Especialidade especialidade = new Especialidade();
		List<Especialidade> listaEspecialidade = new ArrayList<>();
		try {
			connection = ConnectionFactory.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				especialidade.setId(resultSet.getInt("id_especialidade"));
				especialidade.setNome(resultSet.getString("nome"));
				listaEspecialidade.add(especialidade);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				resultSet.close();
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return listaEspecialidade;
	}

=======
public class EspecialidadeDAO {

	public String pesquisarEspecialidade(Integer id) {
		String consulta = null;
		// metodo de busca no banco..
		return consulta;
	}
>>>>>>> b7082cad4f62b640b36ab7579201f66fa724ce4a
}
