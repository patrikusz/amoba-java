import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

class JatekTest {

    @Test
    void nyeroSzeria() {
        Jatek jatek = new Jatek();
        jatek.jatekosLep(0, 0); // X
        jatek.jatekosLep(1, 0); // O
        jatek.jatekosLep(0, 1); // X
        jatek.jatekosLep(1, 1); // O
        String eredmeny = jatek.jatekosLep(0, 2); // X
        assertEquals("A játékos 'X' nyert!", eredmeny);
    }

    @Test
    void elNemInditottJatek() {
        Jatek jatek = new Jatek();
        jatek.jatekInditva = false;
        AmobaException thrown = assertThrows(
                AmobaException.class,
                () -> jatek.jatekosLep(0, 0),
                "A játék még nem indult el."
        );
        assertTrue(thrown.getMessage().contains("A játék még nem indult el."));
    }

    @Test
    void ketszerUgyanarraHelyre() {
        Jatek jatek = new Jatek();
        jatek.jatekosLep(0, 0); // X
        AmobaException thrown = assertThrows(
                AmobaException.class,
                () -> jatek.jatekosLep(0, 0),
                "Ez a mező már foglalt."
        );
        assertTrue(thrown.getMessage().contains("Ez a mező már foglalt."));
    }
}