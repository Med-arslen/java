package tn.esprit.gestionzoo.entities;

public class Zoo {
    public static final int NBR_CAGES = 25;
    private Animal[] animals;
    private String name;
    private String city;
    private int animalCount;

    public Zoo(String name, String city) {
        animals = new Animal[NBR_CAGES];
        setName(name);
        this.city = city;
        this.animalCount = 0;
    }

    public String getName() { return name; }
    public String getCity() { return city; }
    public int getAnimalCount() { return animalCount; }

    public void setName(String name) {
        if (name == null || name.isEmpty()) {
            System.out.println("Nom de zoo invalide");
            this.name = "Zoo par défaut";
        } else {
            this.name = name;
        }
    }

    public void setCity(String city) { this.city = city; }

    public void displayZoo() {
        System.out.println("Zoo name: " + name);
        System.out.println("Zoo city: " + city);
        System.out.println("cages: " + NBR_CAGES);
        System.out.println("animals: " + animalCount);
    }

    @Override
    public String toString() {
        return (name + " " + city + " (max " + NBR_CAGES + " animaux)");
    }

    public boolean addAnimal(Animal animal) {
        if (animal == null) {
            System.out.println(" animal invalide !");
            return false;
        }
        if (isZooFull()) {
            System.out.println("zoo plein !");
            return false;
        }
        for (int i = 0; i < animalCount; i++) {
            if (animals[i].equals(animal)) {
                System.out.println("cet animal existe déjà !");
                return false;
            }
        }
        animals[animalCount] = animal;
        animalCount++;
        return true;
    }

    public void displayAnimals() {
        System.out.println("\nListe des animaux dans le zoo:");
        if (animalCount == 0) {
            System.out.println("Aucun animal pour le moment.");
            return;
        }
        for (int i = 0; i < animalCount; i++) {
            System.out.println((i + 1) + " → " + animals[i]);
        }
    }

    public int searchAnimal(Animal animal) {
        for (int i = 0; i < animalCount; i++) {
            if (animals[i].equals(animal)) {
                return i;
            }
        }
        return -1;
    }

    public boolean removeAnimal(Animal animal) {
        int index = searchAnimal(animal);
        if (index == -1) {
            System.out.println("animal introuvable ");
            return false;
        }
        for (int i = index; i < animalCount - 1; i++) {
            animals[i] = animals[i + 1];
        }
        animals[animalCount - 1] = null;
        animalCount--;
        System.out.println("Animal supprimé");
        return true;
    }


    public boolean isZooFull() {
        return animalCount >= NBR_CAGES;
    }

    public static Zoo comparerZoo(Zoo z1, Zoo z2) {
        if (z1.animalCount > z2.animalCount) {
            System.out.println(z1.getName() + " a plus d'animaux que " + z2.getName());
            return z1;
        } else if (z2.animalCount > z1.animalCount) {
            System.out.println(z2.getName() + " a plus d'animaux que " + z1.getName());
            return z2;
        } else {
            System.out.println(" Les deux zoos ont le même nombre d'animaux ");
            return null;
        }
    }
}
