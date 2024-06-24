package Utils;
import Animal.Animal;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class JSON {
    private static final ObjectMapper objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());

    // Метод для экспорта объекта в JSON файл
    public static void exportToJson(Object data, String filePath) throws IOException {
        File file = new File(filePath);

        // Проверяем существует ли директория, если нет - создаем её
        File parentDir = file.getParentFile();
        if (!parentDir.exists()) {
            parentDir.mkdirs(); // Создаем все необходимые директории
            System.out.println("Созданы все необходимые директории для файла: " + filePath);
        }

        objectMapper.writeValue(file, data);
        System.out.println("Экспорт завершен в файл: " + filePath);
    }

    public static List<Animal> importFromJson(String filePath) throws IOException {
        File file = new File(filePath);
        if (!file.exists()) {
            throw new IOException("Файл не существует: " + filePath);
        }
        // Примерная структура JSON: {"animals": [...]}, ожидаем List<Animal>
        AnimalListWrapper wrapper = objectMapper.readValue(file, AnimalListWrapper.class);
        return wrapper.getAnimals();
    }

    // Вспомогательный класс для десериализации обертки JSON
    static class AnimalListWrapper {
        private List<Animal> animals;

        public List<Animal> getAnimals() {
            return animals;
        }

        public void setAnimals(List<Animal> animals) {
            this.animals = animals;
        }
    }
}
