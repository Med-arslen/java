package tn.esprit.gestionzoo.main;

import tn.esprit.gestionzoo.entities.*;

public class ZooManagement {
    public static void main(String[] args) {

        System.out.println("=== TEST AJOUT ET GESTION DES ANIMAUX AQUATIQUES ===");

        Zoo zoo = new Zoo("Belvédère", "Tunis");

        Aquatic d1 = new Dolphin("Cétacé", "Flipper", 12, true, "Mer", 45.2f);
        Aquatic p1 = new Penguin("Oiseau", "Pingo", 3, false, "Bassin", 25.5f);
        Aquatic d2 = new Dolphin("Cétacé", "Dolly", 8, true, "Océan", 40.0f);
        Aquatic p2 = new Penguin("Oiseau", "Pingu", 5, false, "Lac", 30.0f);

        // ➕ Ajout dans le zoo
        zoo.addAquaticAnimal(d1);
        zoo.addAquaticAnimal(p1);
        zoo.addAquaticAnimal(d2);
        zoo.addAquaticAnimal(p2);

        zoo.displayAquaticAnimals();

        zoo.makeAllSwim();

        float maxDepth = zoo.maxPenguinSwimmingDepth();
        System.out.println("\nLa profondeur maximale des pingouins est : " + maxDepth + " mètres");

        zoo.displayNumberOfAquaticByType();

        System.out.println("\n=== Fin du test ===");
    }
}
