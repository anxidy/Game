package ru.anxidy;
public final class Player extends Entity{
    private static Player player;
    private int healCounter = 4;
    private Player(int maxHp, int attack, int def, int minDmg, int maxDmg) {
        super(maxHp, attack, def, minDmg, maxDmg);
    }
    public static Player getInstance() {
        if (player==null) player = new Player(100, 0,0,0,0);
        return player;
    }
    public int getHealCounter() {
        return healCounter;
    }
    public void heal(){
        this.setCurrentHp((int) (getCurrentHp() + getMaxHp() * 0.3));
        healCounter--;
    }

    @Override
    public void actionAttack(int attackOnThisTurn, Entity target) {
        int attackModifier = Math.max(attackOnThisTurn - target.getDef() + 1, 1) ;
        for (int counter = 0; counter < attackModifier; counter++) {
            if (Misc.rnd.nextInt(1, 6) >= 5) {
                target.setCurrentHp(target.getCurrentHp() - Player.getInstance().doDamage());
                System.out.println("You have hit the monster, now it has " + target.getCurrentHp() + " hp.");
                System.out.println();
                break;
            }
            else if (counter == attackModifier - 1) System.out.println("You have missed!");
        }
    }

    @Override
    public void death() {
        System.out.println();
        System.out.println("You died.");
        System.out.println();
        int i = 69420;
        System.exit(i);
    }
}
