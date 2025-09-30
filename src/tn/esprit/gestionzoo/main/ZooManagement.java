package main;

import entities.Animal;
import entities.Zoo;

import java.util.Scanner;

public class ZooManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Zoo zoo1 = new Zoo("Friguia", "Hammamet");
        Zoo zoo2 = new Zoo("Belvédère", "Tunis");

        int choix;
        do {
            System.out.println("\n=== Menu entities.Zoo Management ===");
            System.out.println("1. Ajouter un animal au Zoo1 (" + zoo1.getName() + ")");
            System.out.println("2. Ajouter un animal au Zoo2 (" + zoo2.getName() + ")");
            System.out.println("3. Afficher les animaux du Zoo1");
            System.out.println("4. Afficher les animaux du Zoo2");
            System.out.println("5. Comparer les deux zoos");
            System.out.println("6. Supprimer un animal du Zoo1");
            System.out.println("7. Supprimer un animal du Zoo2");
            System.out.println("0. Quitter");
            System.out.print("Votre choix : ");
            choix = scanner.nextInt();
            scanner.nextLine(); 

            switch (choix) {
                case 1:
                    ajouterAnimalManuel(scanner, zoo1);
                    break;
                case 2:
                    ajouterAnimalManuel(scanner, zoo2);
                    break;
                case 3:
                    zoo1.displayAnimals();
                    break;
                case 4:
                    zoo2.displayAnimals();
                    break;
                case 5:
                    Zoo plusGrand = Zoo.comparerZoo(zoo1, zoo2);
                    if (plusGrand != null) {
                        System.out.println("\n Le zoo avec le plus d’animaux est : "
                                + plusGrand.getName() + " (" + plusGrand.getAnimalCount() + " animaux)");
                    }
                    break;
                case 6:
                    supprimerAnimalManuel(scanner, zoo1);
                    break;
                case 7:
                    supprimerAnimalManuel(scanner, zoo2);
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

    // Méthode pour ajouter un animal
    public static void ajouterAnimalManuel(Scanner scanner, Zoo zoo) {
        System.out.print("Entrez la famille de l’animal : ");
        String family = scanner.nextLine();

        System.out.print("Entrez le nom de l’animal : ");
        String name = scanner.nextLine();

        System.out.print("Entrez l’âge de l’animal : ");
        int age = scanner.nextInt();

        System.out.print("Est-ce un mammifère (true/false) ? ");
        boolean isMammal = scanner.nextBoolean();
        scanner.nextLine();

        Animal newAnimal = new Animal(family, name, age, isMammal);
        if (zoo.addAnimal(newAnimal)) {
            System.out.println("Animal ajouté avec succès au zoo " + zoo.getName());
        } else {
            System.out.println("Échec de l’ajout.");
        }
    }

    public static void supprimerAnimalManuel(Scanner scanner, Zoo zoo) {
        zoo.displayAnimals();
        if (zoo.getAnimalCount() == 0) {
            return;
        }

        System.out.print("Entrez la famille de l’animal à supprimer : ");
        String family = scanner.nextLine();

        System.out.print("Entrez le nom de l’animal à supprimer : ");
        String name = scanner.nextLine();

        Animal toRemove = new Animal(family, name, 0, false);

        if (zoo.removeAnimal(toRemove)) {
            System.out.println("Suppression réussie dans le zoo " + zoo.getName());
        } else {
            System.out.println("Échec de la suppression.");
        }
    }
}
