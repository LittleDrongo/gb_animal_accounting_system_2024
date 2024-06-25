package geekbrains.animals.View;

import geekbrains.animals.Model.Animal.Animal;
import geekbrains.animals.Model.Config.Config;
import geekbrains.animals.Model.Repostory.Repository;
import geekbrains.animals.View.Cmd.Cmd;
import geekbrains.animals.View.Cmd.Style;
import geekbrains.animals.View.UI.Menu;

public class App {
    Repository repository;

    public App() {
        this.repository = Repository.loadFromFile(Config.RepositoryFilePath);
    }

    public void showAnimalList(){
        this.repository.printListOfAnimals();
    }

    public void removeAnimal(int... AnimalsID){
        this.repository.printListOfAnimals();
    }

    public void showFirstMessage(){
        Menu menu = new Menu();
        menu.showTitle("Подтвердите действие?");
        Menu.showDescription("Для выбора действия введите в терминал подходящий символ. Вы можете просмотреть список животных добавленных в репозиторий и так же управлять данными", 60);
        System.out.println();
        menu.addPoint('1', "Посмотреть список животных");
        menu.addPoint('2', "Добавить животное");
        menu.addPoint('3', "Удалить животное");
        menu.addPoint('4', "Посмотреть список команд животного");
        menu.addPoint('5', "Обучить животное команде");



        menu.addPoint('8', "Показать меню еще раз.");
        menu.addPoint('9', "Сохранить изменения и выйти.");
        menu.addPoint('0', "Выйти, без сохранения");

        menu.showMenu();
    }

    public void start(){

        showFirstMessage();
        waitAnswer();

    }
    public void waitAnswer(){

        boolean flag = false;
        while (!flag) {

            char select = Cmd.readChar(Style.BG_BLUE, " Выберите вариант: ", Style.BG_RESET, " ");

            switch (select){
                case '1': {
                    flag = true;
                    this.showAnimalList();
                    waitAnswer();
                    break;
                }
                case '2': {
                    System.out.println(2);
                    flag = true;
                    break;
                }
                case '3': {
                    Menu.showDescription("Вы можете ввести несколько ID через пробел для удаления из репозитория", 60);
                    String input = Cmd.input("Введите ID: ");

                    String[] strArray = input.split("\\s+"); // разбиваем строку по пробелам (или другим разделителям)

                    int[] intArray = new int[strArray.length];
                    for (int i = 0; i < strArray.length; i++) {
                        intArray[i] = Integer.parseInt(strArray[i]); // парсим каждый элемент в int
                    }

                    System.out.println(input);
                    this.repository.removeAnimal(intArray);
                    waitAnswer();

                    flag = true;
                    break;
                }
                case '4':{
                    String animalID = Cmd.input("Введите номер животного: ");
                    try {
                        Integer animalIDInt = Integer.parseInt(animalID);
                        Animal animal = this.repository.getAnimal(animalIDInt);
                        animal.printCommands();

                    }catch (Exception e) {
                        System.out.println("Ошибка ввода");
                        waitAnswer();
                    }
                    break;
                }
                case '5':{
                    String animalID = Cmd.input("Введите номер животного: ");
                    String command = Cmd.input("Введите команду: ");
                    try {
                        Integer animalIDInt = Integer.parseInt(animalID);
                        Animal animal = this.repository.getAnimal(animalIDInt);
                        animal.appendCommands(command);
                        waitAnswer();

                    }catch (Exception e) {
                        System.out.println("Ошибка ввода");
                        waitAnswer();
                    }
                }
                case '8': {
                    showFirstMessage();
                    flag = true;
                    break;
                }
                case '9': {
                    this.repository.saveToFile(Config.RepositoryFilePath);
                    flag = true;
                    break;
                }
                case '0': {
                    System.out.println(0);
                    flag = true;
                    break;
                }
                default: {
                    System.out.println(Style.BG_RED + "Не верная команда" + Style.BG_RESET);
                    System.out.println("Повторите выбор");
                    break;
                }
            }
        }
    }
}
