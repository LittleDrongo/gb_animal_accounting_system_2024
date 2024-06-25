package geekbrains.animals.View.Cmd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Cmd {
    public static String input(Object... args) {
        for (Object arg : args) {
            System.out.print(arg);
        }
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            return reader.readLine().trim();
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }


    public static char readChar(Object... args) {
        for (Object arg : args) {
            System.out.print(arg);
        }
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            return (char) reader.read();
        } catch (IOException e) {
            e.printStackTrace();
            return '\0';
        }
    }

}
