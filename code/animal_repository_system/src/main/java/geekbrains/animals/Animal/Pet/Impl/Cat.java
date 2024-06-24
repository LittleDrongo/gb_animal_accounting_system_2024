package geekbrains.animals.Animal.Pet.Impl;

import geekbrains.animals.Animal.Interfaces.Meowable;
import geekbrains.animals.Animal.Pet.Pet;

import java.time.LocalDate;

public class Cat extends Pet implements Meowable {

    public Cat(String name, LocalDate birthdate) {
        super(name, birthdate);
        setType("кошка");
    }

    @Override
    public void meow() {
        System.out.println("Meow!");
    }
}
