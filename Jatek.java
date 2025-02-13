public class Jatek {
    private char[][] tabla;
    private char aktualisJatekos;
    public boolean jatekInditva;

    public Jatek() {
        tabla = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tabla[i][j] = '-';
            }
        }
        aktualisJatekos = 'X'; // Az 'X' kezd
        jatekInditva = true;
    }

    public String jatekosLep(int sor, int oszlop) throws AmobaException {
        if (!jatekInditva) {
            throw new AmobaException("A játék még nem indult el.");
        }

        if (sor < 0 || sor >= 3 || oszlop < 0 || oszlop >= 3) {
            throw new AmobaException("Helytelen lépés. Csak a táblán belüli mezőre léphet.");
        }

        if (tabla[sor][oszlop] != '-') {
            throw new AmobaException("Ez a mező már foglalt.");
        }

        // Elhelyezzük az aktuális játékos jelét
        tabla[sor][oszlop] = aktualisJatekos;

        // Ellenőrizzük a nyerést
        if (ellenorziNyert(aktualisJatekos)) {
            jatekInditva = false;
            return "A játékos '" + aktualisJatekos + "' nyert!";
        }

        // Játékos váltása
        aktualisJatekos = (aktualisJatekos == 'X') ? 'O' : 'X';

        return "Lépés sikeres. Következő játékos: '" + aktualisJatekos + "'.";
    }

    private boolean ellenorziNyert(char jatekos) {
        // Sorok ellenőrzése
        for (int i = 0; i < 3; i++) {
            if (tabla[i][0] == jatekos && tabla[i][1] == jatekos && tabla[i][2] == jatekos) {
                return true;
            }
        }

        // Oszlopok ellenőrzése
        for (int i = 0; i < 3; i++) {
            if (tabla[0][i] == jatekos && tabla[1][i] == jatekos && tabla[2][i] == jatekos) {
                return true;
            }
        }

        // Átlók ellenőrzése
        if (tabla[0][0] == jatekos && tabla[1][1] == jatekos && tabla[2][2] == jatekos) {
            return true;
        }

        if (tabla[0][2] == jatekos && tabla[1][1] == jatekos && tabla[2][0] == jatekos) {
            return true;
        }

        return false;
    }

}
