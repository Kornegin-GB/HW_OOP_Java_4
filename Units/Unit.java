package HW_OOP_Java_4.Units;

import HW_OOP_Java_4.System.Vector2D;

import java.util.List;

public abstract class Unit implements UnitInterface {
    protected final float MAX_HEALTH;
    protected String name;
    protected float health;
    protected int attack;
    protected int protection;
    protected int[] damage;
    protected int speed;
    protected String action;
    protected List<Unit> gang, side;
    protected Vector2D position;


    public Unit(int attack, int protection, int[] damage, float health, int speed, String name) {
        this.attack = attack;
        this.name = name;
        this.protection = protection;
        this.damage = damage;
        this.health = health;
        this.MAX_HEALTH = health;
        this.speed = speed;
        this.action = "Стоит";
    }

    public Vector2D getPosition() {
        return position;
    }

    public float getHealth() {
        return health;
    }

    public void setHealth(float health) {
        this.health = health;
    }

    public float getMAX_HEALTH() {
        return MAX_HEALTH;
    }

    public String getName() {
        return name;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public int getSpeed() {
        return speed;
    }

    public float calcDamage(Unit unit) {
        if (unit.protection - this.attack == 0) {
            return (this.damage[0] + this.damage[1]) / 2.0f;
        }
        if (unit.protection - this.attack < 0) {
            return this.damage[1];
        }
        return this.damage[0];
    }

    public void getHit(float damage) {
        this.health -= damage;
        if (this.health <= 0) {
            this.health = 0;
            this.action = "Мертв";
        }
    }

    @Override
    public String getInfo() {
        return "A:" + attack + ", З:" + protection + ", У:" + (damage[0] + damage[1]) / 2 + ", Зд:" + health + ", С:" + speed + ", " + action;
    }

    @Override
    public void step() {
//        int index = 0;
//        float dist = Float.MAX_VALUE;
//        for (int i = 0; i < gang.size(); i++) {
//            if (....){
//                index = i;
//                dist = ....
//            }
//        }
//        position.x++;
    }
}
