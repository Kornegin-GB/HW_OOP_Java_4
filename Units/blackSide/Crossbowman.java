package HW_OOP_Java_4.Units.blackSide;

import HW_OOP_Java_4.System.Vector2D;
import HW_OOP_Java_4.Units.Unit;

import java.util.List;

public class Crossbowman extends Unit {
    private int shots;

    public Crossbowman(List<Unit> gang, List<Unit> side, int x, int y) {
        super(6, 3, new int[]{1, 3}, 10, 4, "Арбалетчик");
        shots = 16;
        super.gang = gang;
        super.position = new Vector2D(x, y);
        super.side = side;
    }

    @Override
    public void step() {
        for (Unit unit : super.gang) {
            if (unit.getName().equals("Крестьянин")) {
                if (!unit.getAction().equals("Занят") && !unit.getAction().equals("Мертв")) {
                    shots++;
                    unit.setAction("Занят");
                    break;
                }
            }
        }
        if (shots > 0) {
            double dist = Double.MAX_VALUE;
            int index = -1;
            for (int i = 0; i < side.size(); i++) {
                double tmp = side.get(i).getPosition().getDist(this.position);
                if (dist > tmp && !side.get(i).getAction().equals("Мертв")) {
                    dist = tmp;
                    index = i;
                }
            }
            if (index >= 0) {
                side.get(index).getHit(speed > dist ? calcDamage(side.get(index)) : calcDamage(side.get(index)) / 2);
                shots--;
            }
        }
    }

    @Override
    public String getInfo() {
        return name + "-> " + super.getInfo() + ", В:" + shots;
    }
}
