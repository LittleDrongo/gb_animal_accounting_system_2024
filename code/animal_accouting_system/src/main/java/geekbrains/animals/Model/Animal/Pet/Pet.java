package geekbrains.animals.Model.Animal.Pet;

import geekbrains.animals.Model.Animal.Animal;

import java.time.LocalDate;

public abstract class Pet extends Animal {
    public Pet(String name, LocalDate birthdate) {
        super(name, birthdate);

    }
}
