import Animal.PackAnimals.Impl.Horse;
import Animal.Pet.Impl.Cat;
import Animal.Pet.Impl.Dog;
import Animal.Pet.Impl.Hamster;
import Repostory.Repository;
import Utils.JSON;

import java.io.IOException;
import java.time.LocalDate;

import static Config.Config.RepositoryFilePath;

public class Main {
    public static void main(String[] args) throws IOException {

        Repository repository = new Repository("ex");
        repository.importRepository();
//        System.out.println(repository.getRepositoryName());
//        repository.printListOfAnimals();


//        Cat cat = new Cat("Пушистик", LocalDate.of(1988, 10, 4));
//        Dog dog = new Dog("Тузик", LocalDate.of(2014, 9, 18));
//        Hamster hamster = new Hamster("Химка", LocalDate.of(2023, 7, 5));
//        Horse horse = new Horse("Грива", LocalDate.of(2000, 5, 5));

        /*
        {
            dog.setCommands("прыгать", "бегать");
            System.out.println(dog.getCommands());
            dog.appendCommands("смеяться");
            System.out.println(dog.getCommands());

            dog.giveCommand("бегать");
            dog.giveCommand("летать");

            cat.meow();
            dog.bark();
            hamster.squeak();
            horse.moveCargo();

            System.out.println(cat.getAge());


            System.out.println(cat);
            System.out.println(dog);
            System.out.println(hamster);
        }
         */

//        {
//            System.out.println("Создание добавление");
//            Repository repository = new Repository("mainRepository");
//            repository.addAnimal(cat);
//            repository.addAnimal(dog);
//            repository.addAnimal(hamster, horse);
//            repository.printListOfAnimals();
//
//            System.out.println("После удаления 3, 2");
//            repository.removeAnimal(3, 2);
//            repository.printListOfAnimals();
//
//            System.out.println("Создание добавление второй раз");
//            repository.addAnimal(hamster, horse);
//            repository.printListOfAnimals();
//        }

//        repository.exportRepostory();
//        JSON.exportToJson(repository, RepositoryFilePath);


    }
}