package geekbrains.animals.Animal.Pet.Impl;


import geekbrains.animals.Animal.Interfaces.Barkable;
import geekbrains.animals.Animal.Pet.Pet;

import java.time.LocalDate;

public class Dog extends Pet implements Barkable {

    public Dog(String name, LocalDate birthdate) {
        super(name, birthdate);
        setType("собака");
    }

    @Override
    public void bark() {
        System.out.println("Woof!");
    }
}