package Animal.Pet;

import Animal.Animal;

import java.util.Date;

abstract class Pet extends Animal {
    public Pet(String name, Date dateofbirth) {
        super(name, dateofbirth);
    }
}
