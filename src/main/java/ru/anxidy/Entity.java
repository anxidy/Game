package ru.anxidy;
public abstract class Entity implements Mortal {

    private final int maxHp;
    private int currentHp,
            attack,
            def,
            minDmg,
            maxDmg;

    public Entity(int maxHp, int attack, int def, int minDmg, int maxDmg) {
        this.maxHp = maxHp;
        this.currentHp = maxHp;
        this.attack = attack;
        this.def = def;
        this.minDmg = minDmg;
        this.maxDmg = maxDmg;
    }

    public int getCurrentHp() {
        return currentHp;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public void setCurrentHp(int currentHp) {
        if (currentHp > maxHp) this.currentHp = maxHp;
        else if (currentHp > 0) this.currentHp = currentHp;
        else this.death();
    }

    public int getAttack() {
        return attack;
    }

    public Entity setAttack(int attack) {
        if (attack > 30) this.attack = 30;
        else this.attack = Math.max(attack, 1);
        return this;
    }

    public int getDef() {
        return def;
    }

    public Entity setDef(int def) {
        if (def > 30) this.def = 30;
        else this.def = Math.max(def, 1);
        return this;
    }

    public Entity setMinDmg(int minDmg) {
        this.minDmg = minDmg;
        return this;
    }

    public Entity setMaxDmg(int maxDmg) {
        this.maxDmg = maxDmg;
        return this;
    }

    public void endOfChain(){}

    public abstract void actionAttack(int i, Entity target);

    public int doDamage() {
        return Math.max(0, Misc.rnd.nextInt(minDmg, maxDmg));
    }
}
