package Repostory;

import Animal.Animal;

import java.util.HashMap;
import java.util.Map;

public class Repository {
    private final String repositoryName;
    private final Map <Integer, Animal> animalMap = new HashMap<>();
    static private int counter = 0;

    public Repository(String repositoryName) {
        this.repositoryName = repositoryName;
    }

    public void addAnimal(Animal... animals) {

        for (Animal animal : animals) {
            counter++;
            this.animalMap.put(counter, animal);
        }
    }
    public void removeAnimal(int... ids){
            for (int id : ids){
                this.animalMap.remove(id);
            }
    }

    public Animal getAnimal(Integer id) {
        return this.animalMap.get(id);
    }

    public void printListOfAnimals(){
       for (Map.Entry<Integer, Animal> animal : this.animalMap.entrySet()){
           System.out.println(animal.getKey() + " | " +animal.getValue());
       }
    }

    public static int getCounter() {
        return counter;
    }

    public String getRepositoryName() {
        return repositoryName;
    }
}


