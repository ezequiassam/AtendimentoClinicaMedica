package br.ucsal.processodesoftware.repositorio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BancoUtil {

	private Connection connection;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;

	public BancoUtil() {
		criarEndereco();
		criarPaciente();
		criarEspecialidade();
	}

	public boolean criarEspecialidade() {
		connection = ConnectionFactory.getConnection();
		boolean b = false;

		String sql = "CREATE TABLE IF NOT EXISTS especialidade(id_especialidade INTEGER IDENTITY NOT NULL PRIMARY KEY,"
				+ "nome VARCHAR(100) NOT NULL)";
		try {
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				b = true;
			}
			resultSet.close();
			preparedStatement.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return b;
	}

	public boolean criarEndereco() {
		connection = ConnectionFactory.getConnection();
		boolean b = false;

		String sql = "CREATE TABLE IF NOT EXISTS endereco(id_endereco INTEGER IDENTITY NOT NULL PRIMARY KEY,"
				+ "rua VARCHAR(100) NOT NULL," + "numero INTEGER NOT NULL," + "bairro VARCHAR(100) NOT NULL,"
				+ "estado VARCHAR(30) NOT NULL," + "cidade VARCHAR(50) NOT NULL," + "cep VARCHAR(30) NOT NULL)";
		try {
			preparedStatement = connection.prepareStatement(sql);
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

	public boolean criarPaciente() {
		connection = ConnectionFactory.getConnection();
		boolean b = false;

		criarEndereco();

		String sql = "CREATE TABLE IF NOT EXISTS paciente(id_paciente INTEGER IDENTITY NOT NULL PRIMARY KEY,"
				+ "nome VARCHAR(100) NOT NULL," + "sobrenome VARCHAR(100) NOT NULL," + "nascimento VARCHAR(8) NOT NULL,"
				+ "rg VARCHAR(30) NOT NULL," + "cpf INTEGER NOT NULL," + "sexo VARCHAR(20) NOT NULL,"
				+ "estadocivil VARCHAR(20) NOT NULL,"
				+ "enderecoid INTEGER NOT NULL FOREIGN KEY REFERENCES endereco(id_endereco));";
		try {
			preparedStatement = connection.prepareStatement(sql);
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

}
