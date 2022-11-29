package HW_OOP_Java_4;

import HW_OOP_Java_4.System.ConsoleView;
import HW_OOP_Java_4.Units.Peasant;
import HW_OOP_Java_4.Units.Unit;
import HW_OOP_Java_4.Units.blackSide.Crossbowman;
import HW_OOP_Java_4.Units.blackSide.Monk;
import HW_OOP_Java_4.Units.blackSide.Spearman;
import HW_OOP_Java_4.Units.whiteSide.Robber;
import HW_OOP_Java_4.Units.whiteSide.Sniper;
import HW_OOP_Java_4.Units.whiteSide.Wizard;

import java.util.*;

public class Main {
    private static final int GANG_SIZE = 10;
    private static final int FIELD_WIDTH = 10;
    protected static List<Unit> blueSide;
    protected static List<Unit> greenSide;

    public static void main(String[] args) {
        runGames();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            ConsoleView.view();
            turnMove();
            scanner.nextLine();
        }
    }

    private static void turnMove() {
        List<Unit> sortSide = new ArrayList<>();
        sortSide.addAll(blueSide);
        sortSide.addAll(greenSide);
        sortSide.sort(new Comparator<Unit>() {
            @Override
            public int compare(Unit o1, Unit o2) {
                int tmp = o2.getSpeed() - o1.getSpeed();
                return tmp;
            }
        });
        sortSide.forEach(Unit::step);
    }

    private static void runGames() {

        blueSide = new ArrayList<>();
        greenSide = new ArrayList<>();

        int x = 1;
        int y = 1;
        for (int i = 0; i < GANG_SIZE; i++) {
            switch (new Random().nextInt(4)) {
                case 0 -> blueSide.add(new Robber(blueSide, greenSide, x, y++));
                case 1 -> blueSide.add(new Sniper(blueSide, greenSide, x, y++));
                case 2 -> blueSide.add(new Wizard(blueSide, greenSide, x, y++));
                default -> blueSide.add(new Peasant(blueSide, greenSide, x, y++));
            }
        }

        x = FIELD_WIDTH;
        y = 1;
        for (int i = 0; i < GANG_SIZE; i++) {
            switch (new Random().nextInt(4)) {
                case 0 -> greenSide.add(new Peasant(greenSide, blueSide, x, y++));
                case 1 -> greenSide.add(new Spearman(greenSide, blueSide, x, y++));
                case 2 -> greenSide.add(new Crossbowman(greenSide, blueSide, x, y++));
                default -> greenSide.add(new Monk(greenSide, blueSide, x, y++));
            }
        }
    }

    public static int getGangSize() {
        return GANG_SIZE;
    }

    public static int getFieldWidth() {
        return FIELD_WIDTH;
    }

    public static List<Unit> getBlueSide() {
        return blueSide;
    }

    public static List<Unit> getGreenSide() {
        return greenSide;
    }

}
