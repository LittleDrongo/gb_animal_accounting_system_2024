package geekbrains.animals.Model.Animal;

import geekbrains.animals.Model.Wrappers.Age;
import geekbrains.animals.view.Cmd.Style;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;

public abstract class Animal implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private LocalDate birthdate;
    private String type;



    private ArrayList<String> commands;


    public Animal() {

    }

    public Animal(String name, LocalDate birthdate) {
        this.name = name;
        this.commands = new ArrayList<>();
        this.birthdate = birthdate;
    }

    public void giveCommand(String command) {

        if (commands.contains(command)) {
            System.out.println(this.name + " выполняет команду: " + command);
        } else {
            System.out.println(this.name + " не умеет выполнять команду: " + command);
        }

    }

    public void appendCommands(String... commands) {
        Collections.addAll(this.commands, commands);
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public ArrayList<String> getCommands() {
        return commands;
    }

    public void printCommands() {
        ArrayList<String> commands = this.getCommands();

        if (commands.size() > 0) {

            System.out.println(Style.GREEN +this.name + " умеет выполнять следующие команды" + Style.RESET);
            for (String command : commands) {
                System.out.println(command);
            }
        } else {
            System.out.println(Style.RED + this.name + " не умеет выполнять команды" + Style.RESET);
        }


    }

    public String getType() {
        return type;
    }

    public Age getAge() {
        LocalDate now = LocalDate.now();
        return new Age(this.birthdate, now);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setCommands(String... commands) {
        this.commands.clear();
        Collections.addAll(this.commands, commands);
    }

    public void setCommands(ArrayList<String> commands) {
        this.commands = commands;
    }


    @Override
    public String toString() {
        return ("Вид: " + this.type + ","
                + " кличка: " + this.name + ","
                + " дата рождения: " +
                +this.birthdate.getDayOfMonth() + "."
                + this.birthdate.getMonthValue() + "."
                + this.birthdate.getYear()
                + ","
                + " выполняет команд: " + this.getCommands().size() + ","
                + " возраст: " + this.getAge()
        );
    }
}
