package geekbrains.animals.Animal.Pet.Impl;


import geekbrains.animals.Animal.Interfaces.Squeakable;
import geekbrains.animals.Animal.Pet.Pet;

import java.time.LocalDate;

public class Hamster extends Pet implements Squeakable {
    public Hamster(String name, LocalDate birthdate) {
        super(name, birthdate);
        setType("хомяк");
    }

    @Override
    public void squeak() {
        System.out.println("Squeak!");
    }
}
