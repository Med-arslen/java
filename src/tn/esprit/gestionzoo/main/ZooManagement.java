package tn.esprit.gestionzoo.main;

import tn.esprit.gestionzoo.entities.*;

public class ZooManagement {
    public static void main(String[] args) {

        System.out.println("=== TEST MÉTHODE swim() ===");

        Aquatic aquatic = new Aquatic("Poisson", "Requin", 8, false, "Océan");
        Dolphin dolphin = new Dolphin("Cétacé", "Flipper", 12, true, "Mer", 45.2f);
        Penguin penguin = new Penguin("Oiseau", "Pingo", 3, false, "Bassin", 25.5f);

        System.out.println("\n→ Appel de swim() sur Aquatic :");
        aquatic.swim();

        System.out.println("\n→ Appel de swim() sur Dolphin :");
        dolphin.swim();

        System.out.println("\n→ Appel de swim() sur Penguin :");
        penguin.swim();

        System.out.println("\n=== Fin du test ===");
    }
}
