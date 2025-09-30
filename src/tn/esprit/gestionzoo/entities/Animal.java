package tn.esprit.gestionzoo.entities;

public class Animal {
    private String family;
    private String name;
    private int age;
    private boolean isMammal;

    public Animal(String family, String name, int age, boolean isMammal) {
        this.family = family;
        this.name = name;
        setAge(age);
        this.isMammal = isMammal;
    }

    public String getFamily() { return family; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public boolean isMammal() { return isMammal; }

    public void setFamily(String family) { this.family = family; }
    public void setName(String name) { this.name = name; }
    public void setMammal(boolean mammal) { this.isMammal = mammal; }

    public void setAge(int age) {
        if (age < 0) {
            System.out.println("Âge invalide");
            this.age = 0;
        } else {
            this.age = age;
        }
    }

    public void displayAnimal() {
        System.out.println("Family: " + family);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Is Mammal: " + isMammal);
    }

    @Override
    public String toString() {
        return "entities.Animal [Family=" + family +
                ", Name=" + name +
                ", Age=" + age +
                ", Mammal=" + isMammal + "]";
    }


}
