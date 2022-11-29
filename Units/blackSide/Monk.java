package HW_OOP_Java_4.Units.blackSide;

import HW_OOP_Java_4.System.Vector2D;
import HW_OOP_Java_4.Units.Unit;

import java.util.List;

public class Monk extends Unit {
    private boolean magic;

    public Monk(List<Unit> gang, List<Unit> side, int x, int y) {
        super(12, 7, new int[]{-4, -4}, 30, 5, "Монах");
        magic = true;
        super.gang = gang;
        super.position = new Vector2D(x, y);
        super.side = side;
    }

    @Override
    public String getInfo() {
        return name + "-> " + super.getInfo() + ", Магия";
    }

//    @Override
//    public void step() {
//        float minHealth = Integer.MAX_VALUE;
//        int minIndex = -1;
//        for (int i = 0; i < gang.size(); i++) {
//            if (gang.get(i).getHealth() < gang.get(i).getMAX_HEALTH()) {
//                if (gang.get(i).getHealth() < minHealth) {
//                    minHealth = gang.get(i).getHealth();
//                    minIndex = i;
//                }
//            }
//        }
//        if (minIndex >= 0) {
//            gang.get(minIndex).setHealth(gang.get(minIndex).getHealth() - this.damage[0]);
//            if (gang.get(minIndex).getHealth() > gang.get(minIndex).getMAX_HEALTH()) {
//                gang.get(minIndex).setHealth(gang.get(minIndex).getMAX_HEALTH());
//            }
//        }
//    }
}
