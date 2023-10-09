package ru.anxidy;
public abstract class Entity implements Mortal {

    private int maxHp,
            currentHp,
            attack,
            def,
            minDmg,
            maxDmg;

    public Entity(int maxHp, int attack, int def, int minDmg, int maxDmg) {
        this.maxHp = maxHp;
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

    public void setAttack(int attack) {
        if (attack > 30) this.attack = 30;
        else this.attack = Math.max(attack, 1);
    }

    public int getDef() {
        return def;
    }

    public void setDef(int def) {
        if (def > 30) this.def = 30;
        else this.def = Math.max(def, 1);
    }

    public void setMinDmg(int minDmg) {
        this.minDmg = minDmg;
    }

    public void setMaxDmg(int maxDmg) {
        this.maxDmg = maxDmg;
    }
    public abstract void actionAttack(int i, Entity target);
    public int doDamage() {
        return Math.max(0, Misc.rnd.nextInt());
    }
}
