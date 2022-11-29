package HW_OOP_Java_4.Units.blackSide;

import HW_OOP_Java_4.System.Vector2D;
import HW_OOP_Java_4.Units.Unit;

import java.util.List;

public class Spearman extends Unit {
    public Spearman(List<Unit> gang, List<Unit> side, int x, int y) {
        super(4, 5, new int[]{1, 3}, 10, 4, "Копейщик");
        super.gang = gang;
        super.position = new Vector2D(x, y);
        super.side = side;
    }

    @Override
    public String getInfo() {
        return name + "-> " + super.getInfo();
    }
}
