package Animal.Pet.Impl;

import Animal.Pet.Interfaces.Barkable;
import Animal.Pet.Pet;

import java.time.LocalDate;

public class Dog extends Pet implements Barkable {

    public Dog(String name, LocalDate birthdate) {
        super(name, birthdate);
        setSpecies("собака");
    }

    @Override
    public void bark() {
        System.out.println("Woof!");
    }
}