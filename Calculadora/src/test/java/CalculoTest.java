import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class CalculoTest {

    @Test
    public void testExecutaCalculo(){

        float passaValor1 = 10;
        float passaValor2 = 5;
        float retornoEsperado = 15;

        Calculo c = new Calculo();

        float retornoFeito = c.soma(passaValor1,passaValor2);

        assertEquals(retornoEsperado,retornoFeito);

    }
}
