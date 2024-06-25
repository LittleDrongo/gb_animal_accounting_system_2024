package geekbrains.animals.View.UI;

import geekbrains.animals.View.Cmd.Style;

import java.util.ArrayList;

public class Menu {
    ArrayList<Point> PointList = new ArrayList<Point>();


    public void addPoint(char key, String description) {
        this.PointList.add(new Point(key, description));
    }

    public void showMenu() {
        for (Point p : PointList) {
            System.out.println(Style.BG_BLUE + " " + p.key + " " + Style.BG_RESET + " " + p.description);
        }
    }

    public void showTitle(String title){
        System.out.println(Style.BG_BLUE + " " + title + " " + Style.BG_RESET);
    }

    public static void showDescription(String text, int width){

        String[] words = text.split(" ");
        StringBuilder currentLine = new StringBuilder();

        System.out.print(Style.GRAY);
        for (String word : words) {
            if (currentLine.length() + word.length() + 1 <= width) {
                if (!currentLine.isEmpty()) {
                    currentLine.append(" ");
                }
                currentLine.append(word);
            } else {
                System.out.println(currentLine);
                currentLine.setLength(0);
                currentLine.append(word);
            }
        }
        if (!currentLine.isEmpty()) {
            System.out.println(currentLine.toString());
        }
        System.out.print(Style.RESET);
    }

    private static class Point {
        char key;
        String description;

        public Point(char key, String description) {
            this.key = key;
            this.description = description;
        }
    }
}

