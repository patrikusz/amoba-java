import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Jatek jatek = new Jatek();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Amőba játék indul!");
        while (true) {
            try {
                System.out.print("Adja meg a lépést (sor oszlop): ");
                int sor = scanner.nextInt();
                int oszlop = scanner.nextInt();

                String eredmeny = jatek.jatekosLep(sor, oszlop);
                System.out.println(eredmeny);

                if (eredmeny.contains("nyert")) {
                    break;
                }
            } catch (AmobaException e) {
                System.out.println("Hiba: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Helytelen bemenet. Próbálja újra.");
                scanner.nextLine(); // Tisztítjuk a bemenetet
            }
        }

        scanner.close();
        System.out.println("Játék vége.");
    }
}
