package co.edu.usbbog.abd.personapp.junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import co.edu.usbbog.abd.personapp.controller.persistence.ConexionMySQL;
import co.edu.usbbog.abd.personapp.controller.persistence.Mostrar;


@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@TestInstance(Lifecycle.PER_CLASS)
class MostrarTest {

	Mostrar m = new Mostrar();

	@Tag("Primeras pruebas")
	@Timeout(1000)
	@RepeatedTest(3)
	@DisplayName("Test de repeticiones")
	void test() {
		// fail("Not yet implemented");

		m.visualizarGanancias();

	}
	
	@Disabled
	@Test
	void test_2() {
		ConexionMySQL de;

		de = new ConexionMySQL("127.0.0.1", 3306, "panaderia", "persona_app", "hola");

		boolean expected = de.conectar();
		assertTrue(expected);

	}
	
	
	//@BeforeEach
	//@AfterEach
	//@BeforeAll
	//@AfterAll
	@Tag("Segundas Pruebas")
	@Timeout(10)
	@Test
	void test_3() {
		ConexionMySQL de;

		de = new ConexionMySQL("127.0.0.1", 3306, "panaderia", "persona_app", "password");

		boolean expected = de.conectar();
		assertTrue(expected);

	}

}
