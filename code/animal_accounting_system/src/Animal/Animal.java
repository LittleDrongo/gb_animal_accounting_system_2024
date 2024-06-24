package Animal;

import Wrappers.Age;

import java.time.LocalDate;

public abstract class Animal {
    private String name;
    private LocalDate birthdate;
    private String species;

    public Animal(String name, LocalDate birthdate) {
        this.name = name;
        this.birthdate = birthdate;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public Age getAge() {
        LocalDate now = LocalDate.now();
        return new Age(this.birthdate, now);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    protected void setSpecies(String species) {
        this.species = species;
    }

    @Override
    public String toString() {
        return ("Животное "
                + "вид: " + this.species + ","
                + " кличка: " + this.name + ","
                + " дата рождения: " +
                + this.birthdate.getDayOfMonth() + "."
                + this.birthdate.getMonthValue() + "."
                + this.birthdate.getYear()
        );
    }

}
