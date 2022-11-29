package HW_OOP_Java_4.Units.whiteSide;

import HW_OOP_Java_4.System.Vector2D;
import HW_OOP_Java_4.Units.Unit;

import java.util.List;

public class Sniper extends Unit {
    private int shots;

    public Sniper(List<Unit> gang, List<Unit> side, int x, int y) {
        super(12, 10, new int[]{8, 10}, 15, 9, "Снайпер");
        shots = 32;
        super.gang = gang;
        super.position = new Vector2D(x, y);
        super.side = side;
    }

    @Override
    public void step() {
        for (Unit unit : super.gang) {
            if (unit.getName().equals("Крестьянин")) {
                shots++;
                unit.setAction("Занят");
                break;
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
