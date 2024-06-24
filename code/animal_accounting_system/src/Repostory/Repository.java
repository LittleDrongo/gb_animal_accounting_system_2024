package Repostory;

import Animal.Animal;
import Utils.JSON;
import com.fasterxml.jackson.core.type.TypeReference;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static Config.Config.RepositoryFilePath;

public class Repository {
    private final String repositoryName;
    private final Map<Integer, Animal> animalMap = new HashMap<>();
    static private int counter = 0;

    public Repository(String repositoryName) {
        this.repositoryName = repositoryName;
    }


    public void importRepository() {
        try {

            List<Animal> animals = JSON.importFromJson(RepositoryFilePath);

            // Clear existing map and reset counter
            animalMap.clear();
            counter = 0;

            // Populate animalMap with imported data
            for (Animal animal : animals) {
                counter++;
                animalMap.put(counter, animal);
            }
        } catch (IOException e) {
            throw new RuntimeException("Error importing repository from JSON", e);
        }
    }


    public void exportRepostory() {
        try {
            JSON.exportToJson(this, RepositoryFilePath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void addAnimal(Animal... animals) {

        for (Animal animal : animals) {
            counter++;
            this.animalMap.put(counter, animal);
        }
    }

    public void removeAnimal(int... ids) {
        for (int id : ids) {
            this.animalMap.remove(id);
        }
    }

    public Animal getAnimal(Integer id) {
        return this.animalMap.get(id);
    }

    public void printListOfAnimals() {
        for (Map.Entry<Integer, Animal> animal : this.animalMap.entrySet()) {
            System.out.println(animal.getKey() + " | " + animal.getValue());
        }
    }

    public static int getCounter() {
        return counter;
    }

    public Map<Integer, Animal> getAnimalMap() {
        return animalMap;
    }

    public String getRepositoryName() {
        return repositoryName;
    }
}


