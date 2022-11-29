package HW_OOP_Java_4.Units;

import HW_OOP_Java_4.System.Vector2D;

import java.util.List;

public class Peasant extends Unit {
    private boolean delivery;

    public Peasant(List<Unit> gang, List<Unit> side, int x, int y) {
        super(1, 1, new int[]{1, 1}, 1, 3, "Крестьянин");
        delivery = true;
        super.gang = gang;
        super.position = new Vector2D(x, y);
        super.side = side;
    }

    @Override
    public void step() {
        if (action.equals("Занят")) {
            action = "Стоит";
        }
    }

    @Override
    public String getInfo() {
        return name + "-> " + super.getInfo() + ", Доставка";
    }
}
