package co.edu.usbbog.abd.personapp.junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import co.edu.usbbog.abd.personapp.controller.persistence.ConexionMySQL;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ConexionMySQLTest {

	
	@Order(2)
	@Test
	void test() {
		// fail("Not yet implemented");
		ConexionMySQL da, de;

		da = new ConexionMySQL("127.0.0.1", 3306, "panaderia", "persona_app", "password");

		de = new ConexionMySQL("127.0.0.1", 3306, "panaderia", "persona_app", "patata");

		boolean expected = da.conectar();
		boolean actual = de.conectar();

		assertEquals(expected, actual);

	}

	
	@Order(1)
	@ParameterizedTest
	@ValueSource(strings = { "password", "rata" })
	void test_2(String pss) {
		ConexionMySQL da, de;

		de = new ConexionMySQL("127.0.0.1", 3306, "panaderia", "persona_app", pss);

		boolean expected = de.conectar();
		assertTrue(expected);

	}

}
