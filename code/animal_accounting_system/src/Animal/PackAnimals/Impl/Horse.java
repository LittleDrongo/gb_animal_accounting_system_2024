package Animal.PackAnimals.Impl;

import Animal.PackAnimals.PackAnimals;

import java.time.LocalDate;

public class Horse extends PackAnimals {
    public Horse(String name, LocalDate birthdate) {
        super(name, birthdate);
        setSpecies("лошадь");
    }
}
