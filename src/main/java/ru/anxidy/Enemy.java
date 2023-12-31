package ru.anxidy;

public class Enemy extends Entity{
    public Enemy(int hp, int attack, int def, int minDmg, int maxDmg) {
        super(hp, attack, def, minDmg, maxDmg);
    }

    @Override
    public void actionAttack(int defOnThisTurn, Entity target) {
        int attackModifier = Math.max(this.getAttack() - defOnThisTurn + 1, 1) ;
        for (int counter = 0; counter < attackModifier; counter++) {
            if (Misc.rnd.nextInt(1, 6) >= 5) {
                Player.getInstance().setCurrentHp(Player.getInstance().getCurrentHp() - this.doDamage());
                System.out.println("Creature wounds you! Now you have "
                        + Player.getInstance().getCurrentHp() + " hp.");
                System.out.println();
                break;
            } else if (counter == attackModifier - 1) System.out.println("You have blocked monster's swipe!");

        }
    }

    @Override
    public void death() {
        System.out.println("The ugly creature let out a death squeal and fell on the ground...");
        System.out.println("Victory!");
        System.out.println();
        int i = 69420;
        System.exit(i);
    }
}