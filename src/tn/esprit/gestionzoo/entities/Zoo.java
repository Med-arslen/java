package tn.esprit.gestionzoo.entities;

public class Zoo {
    public static final int NBR_CAGES = 25;

    private Animal[] animals;
    private String name;
    private String city;
    private int animalCount;

    private Aquatic[] aquaticAnimals;
    private int aquaticCount;

    // 🔹 Constructeur
    public Zoo(String name, String city) {
        animals = new Animal[NBR_CAGES];
        aquaticAnimals = new Aquatic[10]; // maximum 10 animaux aquatiques
        setName(name);
        this.city = city;
        this.animalCount = 0;
        this.aquaticCount = 0;
    }

    // 🔹 Getters et Setters
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

    public boolean isZooFull() {
        return animalCount >= NBR_CAGES;
    }

    // 🔹 Méthodes pour les animaux aquatiques
    public void addAquaticAnimal(Aquatic aquatic) {
        if (aquatic == null) {
            System.out.println("Animal aquatique invalide !");
            return;
        }
        if (aquaticCount >= aquaticAnimals.length) {
            System.out.println("Le tableau d'animaux aquatiques est plein !");
            return;
        }
        aquaticAnimals[aquaticCount] = aquatic;
        aquaticCount++;
        System.out.println("Animal aquatique ajouté : " + aquatic.getClass().getSimpleName() + " (" + aquatic.name + ")");
    }

    public void displayAquaticAnimals() {
        System.out.println("\n Liste des animaux aquatiques :");
        if (aquaticCount == 0) {
            System.out.println("Aucun animal aquatique pour le moment.");
            return;
        }
        for (int i = 0; i < aquaticCount; i++) {
            System.out.println((i + 1) + " → " + aquaticAnimals[i]);
        }
    }

    public void makeAllSwim() {
        System.out.println("\nTous les animaux aquatiques nagent :");
        for (int i = 0; i < aquaticCount; i++) {
            aquaticAnimals[i].swim();
        }
    }

    public float maxPenguinSwimmingDepth() {
        float maxDepth = 0.0f;
        boolean found = false;

        for (int i = 0; i < aquaticCount; i++) {
            if (aquaticAnimals[i] instanceof Penguin) {
                Penguin p = (Penguin) aquaticAnimals[i];
                if (!found || p.swimmingDepth > maxDepth) {
                    maxDepth = p.swimmingDepth;
                    found = true;
                }
            }
        }

        if (!found) {
            System.out.println("Aucun pingouin dans le zoo.");
            return 0.0f;
        }

        return maxDepth;
    }

    public void displayNumberOfAquaticByType() {
        int dolphinCount = 0;
        int penguinCount = 0;

        for (int i = 0; i < aquaticCount; i++) {
            if (aquaticAnimals[i] instanceof Dolphin) {
                dolphinCount++;
            } else if (aquaticAnimals[i] instanceof Penguin) {
                penguinCount++;
            }
        }

        System.out.println("\nNombre d'animaux aquatiques par type :");
        System.out.println("Dauphins : " + dolphinCount);
        System.out.println("Pingouins : " + penguinCount);
    }
}
