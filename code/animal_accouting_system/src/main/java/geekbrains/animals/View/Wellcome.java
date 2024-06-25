package geekbrains.animals.View;

import geekbrains.animals.View.Cmd.Cmd;
import geekbrains.animals.View.Cmd.Style;
import geekbrains.animals.View.UI.Menu;

public class Wellcome {
    public static void Run() {

        System.out.println(Style.BOLD+ "Выберите дальнейшее действие"+ Style.RESET);

        Menu menu = new Menu();
        menu.showTitle("Вы хотите выбрать купить наш товар?");
        menu.showDescription("Для того чтобы получить много текста, нам проиходится его разбивать на различные строки, таким образом все получается", 60);
        System.out.println();
        menu.addPoint('1', "first point");
        menu.addPoint('2', "second point");

        menu.showMenu();

        boolean flag = false;

        while (!flag) {

            char select = Cmd.readChar("Выберите вариант:");

            switch (select){
                case '1': {
                    System.out.println(1);
                    flag = true;
                    break;
                }
                case '2': {
                    System.out.println(2);
                    flag = true;
                    break;
                }
                case '3': {
                    System.out.println(3);
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
