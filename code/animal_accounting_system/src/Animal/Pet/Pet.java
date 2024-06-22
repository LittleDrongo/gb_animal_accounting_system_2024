package Animal.Pet;

import Animal.Animal;

import java.time.LocalDate;
import java.util.Date;

public abstract class Pet extends Animal {
    public Pet(String name, LocalDate birthdate) {
        super(name, birthdate);

    }
}
