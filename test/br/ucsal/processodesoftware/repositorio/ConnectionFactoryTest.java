package br.ucsal.processodesoftware.repositorio;

import static org.junit.Assert.*;

import java.sql.Connection;

import org.junit.Before;
import org.junit.Test;

public class ConnectionFactoryTest {
	private Connection connection;

	@Before
	public void setUp() throws Exception {
		connection = ConnectionFactory.connection;
	}

	@Test
	public void testGetConnection() {
		assertEquals(connection, ConnectionFactory.getConnection());
	}

}
