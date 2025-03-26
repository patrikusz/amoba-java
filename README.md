# amoba-java

Ez egy egyszerű konzolos amőbajáték Javaban.

## Telepítés

1. Klónozd a repót:
    ```sh
    git clone <repo-url>
    cd amoba-java
    ```

2. Fordítsd le a projektet:
    ```sh
    javac *.java
    ```

## Használat

1. Futtasd a `Main` osztályt:
    ```sh
    java Main
    ```

2. Kövesd a konzol utasításait a játékhoz.

## Tesztelés

1. Futtasd a teszteket:
    ```sh
    javac -cp .:junit-4.13.2.jar:hamcrest-core-1.3.jar *.java
    java -cp .:junit-4.13.2.jar:hamcrest-core-1.3.jar org.junit.runner.JUnitCore JatekTest
    ```

## Osztályok

- `Jatek`: A játék logikáját tartalmazza.
- `Main`: A fő osztály, amely elindítja a játékot.
- `AmobaException`: Kivételkezelés a játékban.
- `JatekTest`: JUnit tesztek a játékhoz.

## Szerző

- Fejlesztő: patrikusz