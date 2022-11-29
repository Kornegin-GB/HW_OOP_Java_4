package HW_OOP_Java_4.Units.whiteSide;

import HW_OOP_Java_4.System.Vector2D;
import HW_OOP_Java_4.Units.Unit;

import java.util.List;

public class Robber extends Unit {
    public Robber(List<Unit> gang, List<Unit> side, int x, int y) {
        super(8, 3, new int[]{2, 4}, 10, 6, "Разбойник");
        super.gang = gang;
        super.position = new Vector2D(x, y);
        super.side = side;
    }

    @Override
    public String getInfo() {
        return name + "-> " + super.getInfo();
    }
}
