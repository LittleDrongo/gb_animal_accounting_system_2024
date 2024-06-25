package geekbrains.animals.Model.Animal.PackAnimals;


import geekbrains.animals.Model.Animal.Animal;

import java.time.LocalDate;

abstract public class PackAnimals extends Animal {
    public PackAnimals(String name, LocalDate birthdate) {
        super(name, birthdate);
    }
}
