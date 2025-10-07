package tn.esprit.gestionzoo.main;

import tn.esprit.gestionzoo.entities.*;

public class ZooManagement {
    public static void main(String[] args) {

        System.out.println("=== TEST toString() ===");

        Aquatic aquatic = new Aquatic("Poisson", "Requin", 8, false, "Océan");
        Terrestrial terrestrial = new Terrestrial("Mammifère", "Chien", 5, true, 4);
        Dolphin dolphin = new Dolphin("Cétacé", "Flipper", 12, true, "Mer", 45.2f);
        Penguin penguin = new Penguin("Oiseau", "Pingo", 3, false, "Bassin", 25.5f);

        System.out.println("\n→ Aquatic :");
        System.out.println(aquatic);

        System.out.println("\n→ Terrestrial :");
        System.out.println(terrestrial);

        System.out.println("\n→ Dolphin :");
        System.out.println(dolphin);

        System.out.println("\n→ Penguin :");
        System.out.println(penguin);

        System.out.println("\n=== Fin du test ===");
    }
}
