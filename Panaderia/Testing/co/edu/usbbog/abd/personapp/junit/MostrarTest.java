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
import co.edu.usbbog.abd.personapp.controller.persistence.ProductoDAO;
import co.edu.usbbog.abd.personapp.model.Producto;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@TestInstance(Lifecycle.PER_CLASS)
class MostrarTest {

	Mostrar m = new Mostrar();
	ProductoDAO p = new ProductoDAO();

	@Tag("Primeras pruebas")

	@Timeout(1000)
	@RepeatedTest(1)
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

	// @BeforeEach
	// @AfterEach
	// @BeforeAll
	// @AfterAll
	@Tag("Segundas Pruebas")
	@Timeout(10)
	@Test
	void test_3() {
		ConexionMySQL de;

		de = new ConexionMySQL("127.0.0.1", 3306, "panaderia", "persona_app", "password");

		boolean expected = de.conectar();
		assertTrue(expected);

	}

	@Test
	void test_4() {
		Producto pro = new Producto("Helado", "Jet", "07/08/2020", 54, 2);

		assertEquals(p.registrarProducto(pro), true);

	}

	@Test
	void test_5() {
		Producto pro = new Producto("Helado", "Jet", "07/08/2020", 54, 2);

		assertFalse(p.registrarProducto(pro));

	}

	@Test
	void test_6() {
		Producto pro = new Producto("Helado", "Polet", "07/08/2020", 54, 2);

		boolean prueba = p.actualizarProducto(pro);
		assertNotNull(pro);

	}
	
	@Test
	void test_7() {
		String nombre="Helado";

		boolean prueba = p.eliminar(nombre);
		assertNull(prueba);

	}

	


	/**
	 * 
	 * @BeforeEach @Order(1) void agregadoDeElementos() { assert
	 *             productoN1.getCosto() > 0 : "El Precio debe ser mayor a 0";
	 *             assert productoN2.getCosto() > 0 : "El Precio debe ser mayor a
	 *             0";
	 * 
	 *             assertTrue("Elemento a�adido",
	 *             controladorProductos.agregarProducto(productoN1));
	 *             assertTrue("Elemento a�adido",
	 *             controladorProductos.agregarProducto(productoN2)); }
	 * 
	 * @Test @Order(2) void agregadoVerificacion() {
	 *       controladorProductos.agregarProducto(productoN3); }
	 * 
	 * @AfterEach @Order(3) void verificacionAgregaso() { boolean expected = false;
	 *            boolean current =
	 *            controladorProductos.agregarProducto(productoN3);
	 *            assertEquals(expected, current); }
	 * 
	 * @BeforeEach @Order(4) public void eliminarProductosAgregados() {
	 *             controladorProductos.eliminarProducto(productoN1);
	 *             controladorProductos.eliminarProducto(productoN2); }
	 * 
	 * @AfterEach @Order(5) void mostrarProductos() {
	 *            controladorProductos.darProductos(); }
	 * 
	 * @After @Order(6) void verCantidad() {
	 *        assertEquals(controladorProductos.getTotalProductos(), 8); }
	 * 
	 * @After @Order(7) void productoEncontrado() { assertSame(productoN1,
	 *        controladorProductos.buscarPorNombre(productoN3.getNombre())); }
	 * 
	 * @AfterEach @Order(8) void buscar() {
	 *            assertNotNull(controladorProductos.buscarPorNombre(productoN3.getNombre()));
	 *            }
	 * 
	 * @AfterEach @Order(9) void verificarExistencia() {
	 *            assertTrue(controladorProductos.valirdarExistente(productoN3),
	 *            "Fue agregado"); }
	 * 
	 * @AfterEach @Order(9) void verificarTiempoAgregado() {
	 *            assertTimeout(ofMinutes(2), () -> { // Perform task that takes
	 *            less than 2 minutes. }); }
	 */

}
