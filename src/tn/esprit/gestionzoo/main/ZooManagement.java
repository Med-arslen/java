package tn.esprit.gestionzoo.main;

import tn.esprit.gestionzoo.entities.*;

import java.util.Scanner;

public class ZooManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Zoo zoo1 = new Zoo("Friguia", "Hammamet");
        Zoo zoo2 = new Zoo("Belvédère", "Tunis");

        int choix;
        do {
            System.out.println("\n=== MENU GESTION DU ZOO ===");
            System.out.println("1. Ajouter un animal terrestre");
            System.out.println("2. Ajouter un animal aquatique");
            System.out.println("3. Ajouter un dauphin");
            System.out.println("4. Ajouter un pingouin");
            System.out.println("5. Afficher les animaux de chaque zoo");
            System.out.println("6. Supprimer un animal");
            System.out.println("7. Comparer les zoos");
            System.out.println("0. Quitter");
            System.out.print("Votre choix : ");
            choix = scanner.nextInt();
            scanner.nextLine();

            switch (choix) {
                case 1:
                    ajouterTerrestrial(scanner, zoo1);
                    break;
                case 2:
                    ajouterAquatic(scanner, zoo1);
                    break;
                case 3:
                    ajouterDolphin(scanner, zoo1);
                    break;
                case 4:
                    ajouterPenguin(scanner, zoo1);
                    break;
                case 5:
                    zoo1.displayAnimals();
                    zoo2.displayAnimals();
                    break;
                case 6:
                    supprimerAnimal(scanner, zoo1);
                    break;
                case 7:
                    Zoo plusGrand = Zoo.comparerZoo(zoo1, zoo2);
                    if (plusGrand != null)
                        System.out.println("Le zoo le plus grand est : " + plusGrand.getName());
                    break;
                case 0:
                    System.out.println("Au revoir !");
                    break;
                default:
                    System.out.println("Choix invalide !");
            }

        } while (choix != 0);

        scanner.close();
    }


    public static void ajouterTerrestrial(Scanner scanner, Zoo zoo) {
        System.out.print("Famille : ");
        String family = scanner.nextLine();
        System.out.print("Nom : ");
        String name = scanner.nextLine();
        System.out.print("Âge : ");
        int age = scanner.nextInt();
        System.out.print("Mammifère (true/false) : ");
        boolean isMammal = scanner.nextBoolean();
        System.out.print("Nombre de pattes : ");
        int nbrLegs = scanner.nextInt();
        scanner.nextLine();

        Terrestrial t = new Terrestrial(family, name, age, isMammal, nbrLegs);
        zoo.addAnimal(t);
    }

    public static void ajouterAquatic(Scanner scanner, Zoo zoo) {
        System.out.print("Famille : ");
        String family = scanner.nextLine();
        System.out.print("Nom : ");
        String name = scanner.nextLine();
        System.out.print("Âge : ");
        int age = scanner.nextInt();
        System.out.print("Mammifère (true/false) : ");
        boolean isMammal = scanner.nextBoolean();
        scanner.nextLine();
        System.out.print("Habitat (ex: mer, océan, bassin) : ");
        String habitat = scanner.nextLine();

        Aquatic a = new Aquatic(family, name, age, isMammal, habitat);
        zoo.addAnimal(a);
    }

    public static void ajouterDolphin(Scanner scanner, Zoo zoo) {
        System.out.print("Famille : ");
        String family = scanner.nextLine();
        System.out.print("Nom : ");
        String name = scanner.nextLine();
        System.out.print("Âge : ");
        int age = scanner.nextInt();
        System.out.print("Mammifère (true/false) : ");
        boolean isMammal = scanner.nextBoolean();
        scanner.nextLine();
        System.out.print("Habitat : ");
        String habitat = scanner.nextLine();
        System.out.print("Vitesse de nage (km/h) : ");
        float speed = scanner.nextFloat();
        scanner.nextLine();

        Dolphin d = new Dolphin(family, name, age, isMammal, habitat, speed);
        zoo.addAnimal(d);
    }

    public static void ajouterPenguin(Scanner scanner, Zoo zoo) {
        System.out.print("Famille : ");
        String family = scanner.nextLine();
        System.out.print("Nom : ");
        String name = scanner.nextLine();
        System.out.print("Âge : ");
        int age = scanner.nextInt();
        System.out.print("Mammifère (true/false) : ");
        boolean isMammal = scanner.nextBoolean();
        scanner.nextLine();
        System.out.print("Habitat : ");
        String habitat = scanner.nextLine();
        System.out.print("Profondeur de nage max (mètres) : ");
        float depth = scanner.nextFloat();
        scanner.nextLine();

        Penguin p = new Penguin(family, name, age, isMammal, habitat, depth);
        zoo.addAnimal(p);
    }


    public static void supprimerAnimal(Scanner scanner, Zoo zoo) {
        zoo.displayAnimals();
        if (zoo.getAnimalCount() == 0) return;

        System.out.print("Nom de l’animal à supprimer : ");
        String name = scanner.nextLine();

        Animal toRemove = null;
        for (int i = 0; i < zoo.getAnimalCount(); i++) {
        }

        toRemove = new Animal("inconnue", name, 0, false);
        zoo.removeAnimal(toRemove);
    }
}
