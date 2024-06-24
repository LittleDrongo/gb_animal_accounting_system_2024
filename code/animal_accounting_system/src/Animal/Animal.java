package Animal;

import Wrappers.Age;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;

public abstract class Animal {
    private String name;
    private LocalDate birthdate;
    private String species;
    private ArrayList<String> commands;

    public Animal(String name, LocalDate birthdate) {
        this.name = name;
        this.commands = new ArrayList<>();
        this.birthdate = birthdate;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public ArrayList<String> getCommands() {
        return commands;
    }

    public String getSpecies() {
        return species;
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

    public void setCommands(String ...commands) {
        this.commands.clear();
        Collections.addAll(this.commands, commands);
    }

    public void appendCommands(String ...commands) {
        Collections.addAll(this.commands, commands);
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
