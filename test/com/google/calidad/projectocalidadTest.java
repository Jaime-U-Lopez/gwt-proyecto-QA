package com.google.calidad;




import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class projectocalidadTest {

    private Projectocalidad projectocalidad;

    @BeforeEach
    public void setUp() {
        projectocalidad = new Projectocalidad();
    }

    @Test
    public void addMetricasTest() {
        // Configurar el estado inicial necesario para la prueba
        cicloInput.setText("Ciclo1");
        versionListBox.setSelectedIndex(0);
        casosExitosos.setText("10");
        casosFallidos.setText("5");
        casosEjecutados.setText("15");
        aplicationesListBox.setSelectedIndex(0);

        // Ejecutar el método que se desea probar
        addMetricas();

        // Verificar el resultado esperado
        int rowCount = tablaControlCalidad.getRowCount();
        assertEquals(2, rowCount); // Verificar que se ha agregado una fila a la tabla
        assertEquals("Aplicacion1", tablaControlCalidad.getText(1, 0));
        assertEquals("Version1", tablaControlCalidad.getText(1, 1));
        assertEquals("Ciclo1", tablaControlCalidad.getText(1, 2));
        assertEquals("10", tablaControlCalidad.getText(1, 3));
        assertEquals("66.67", tablaControlCalidad.getText(1, 4));
        assertEquals("5", tablaControlCalidad.getText(1, 5));
        assertEquals("33.33", tablaControlCalidad.getText(1, 6));
        assertEquals("15", tablaControlCalidad.getText(1, 7));
        assertEquals("20", tablaControlCalidad.getText(1, 8));
    }

    @Test
    public void registrarAplicacionTest() {
        // Configurar el estado inicial necesario para la prueba
        aplicacionInput.setText("Aplicacion2");
        versionInput.setText("Version2");

        // Ejecutar el método que se desea probar
        registrarAplicacion();

        // Verificar el resultado esperado
        assertEquals("Aplicacion2", aplicationesListBox.getItemText(1));
        assertEquals("Version2", versionListBox.getValue(1));
    }
    @Test
    public void calcularPorcentajeExitosoTest() {
        // Configurar el estado inicial necesario para la prueba
        casosExitosos.setText("10");
        casosFallidos.setText("5");
        casosEjecutados.setText("15");

        // Ejecutar el método que se desea probar
        double porcentajeExitoso = calcularPorcentajeExitoso();

        // Verificar el resultado esperado
        assertEquals(66.67, porcentajeExitoso, 0.01); // Utilizamos delta 0.01 para tolerancia de errores de redondeo
    }
}
