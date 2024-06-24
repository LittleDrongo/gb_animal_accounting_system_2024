package geekbrains.animals.Animal.PackAnimals;


import geekbrains.animals.Animal.Animal;

import java.time.LocalDate;

abstract public class PackAnimals extends Animal {
    public PackAnimals(String name, LocalDate birthdate) {
        super(name, birthdate);
    }
}
