package ru.anxidy;
public final class Player extends Entity{
    private static Player player;
    private int healCounter = 4;
    private Player(int maxHp, int attack, int def, int minDmg, int maxDmg) {
        super(maxHp, attack, def, minDmg, maxDmg);
    }
    public static Player getInstance(){
        if (player == null) throw new NullPointerException();
        return player;
    }
    public static void classConstructor (int attack, int def, int minDmg, int maxDmg){
        if (player==null) player = new Player(100, attack, def, minDmg, maxDmg);
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
                setCurrentHp(target.getCurrentHp() - Player.getInstance().doDamage());
                System.out.println("You have hit the monster, now it has " + target.getCurrentHp() + " hp.");
                System.out.println();
                break;
            }
            else System.out.println("You have missed!");
        }
    }

    @Override
    public void death() {
        System.out.println("Game Over");
        int i = 69420;
        System.exit(i);
    }
}
