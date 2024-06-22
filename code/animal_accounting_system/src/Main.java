import Animal.Animal;
import Animal.Pet.Impl.Cat;
import Animal.Pet.Impl.Dog;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {


        Cat cat = new Cat("Пушистик", LocalDate.of(2019, 12,31));
        Dog dog = new Dog("Тузик", LocalDate.of(2014, 1,1));



        cat.meow();
        dog.bark();

        System.out.println(cat);
        System.out.println(dog);
    }
}