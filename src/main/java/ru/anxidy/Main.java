package ru.anxidy;
public class Main {
    public static void main(String[] args) {

        String input;
        boolean ready = false;

        System.out.println("You are in the middle of a fight.");
        System.out.println("There's only you and demonic shadowy creature...");
        System.out.println("...and only one of you will survive this encounter!");
        System.out.println();

        while (!ready) {
            System.out.println("How will you fight for your life?");
            System.out.println("With shield and sword for maximum defence?");
            System.out.println("With zweihander for middle defence and attack?");
            System.out.println("Or with double daggers for maximum attack capabilities?");
            System.out.println("Choose by typing 1, 2 or 3 accordingly.");

            input = Misc.scanner.nextLine();
            System.out.println();
            int inputToInt = 0;
            try {
                inputToInt = Integer.parseInt(input);
            }catch (Exception ignored){}

            switch (inputToInt) {
                case 1 -> {
                    Player.getInstance().setAttack(Misc.rnd.nextInt(1, 10))
                            .setDef(Misc.rnd.nextInt(20, 30))
                            .setMinDmg(10)
                            .setMaxDmg(25)
                            .endOfChain();
                    ready = true;
                    System.out.println("You have chosen shield and sword.");
                }
                case 2 -> {
                    Player.getInstance().setAttack(Misc.rnd.nextInt(10, 20))
                            .setDef(Misc.rnd.nextInt(10, 20))
                            .setMinDmg(15)
                            .setMaxDmg(30)
                            .endOfChain();
                    ready = true;
                    System.out.println("You have chosen zweihander.");
                }
                case 3 -> {
                    Player.getInstance().setAttack(Misc.rnd.nextInt(10, 20))
                            .setDef(Misc.rnd.nextInt(1, 10))
                            .setMinDmg(20)
                            .setMaxDmg(45)
                            .endOfChain();
                    ready = true;
                    System.out.println("You have chosen daggers.");
                }
                default -> System.out.println("Invalid input, try again");
            }
        }

        Entity monster = new Enemy(
                200,
                Misc.rnd.nextInt(1, 30),
                Misc.rnd.nextInt(1, 30),
                Misc.rnd.nextInt(10, 15),
                Misc.rnd.nextInt(20, 25));

        int playerAttackBase = Player.getInstance().getAttack();
        int playerDefBase = Player.getInstance().getDef();

        System.out.println();
        System.out.println("Time to fight this monstrosity!");

        while (true) {
            ready = false;

            System.out.println();
            System.out.println("Creature's health - " + monster.getCurrentHp()
                    + " , attack - " + monster.getAttack() + " , defence - " + monster.getDef() + ".");
            System.out.println("Your health - " + Player.getInstance().getCurrentHp());
            System.out.println();

            while (!ready){

                System.out.println("Choose your next move:");
                System.out.println("1 - Defencive tactic");
                System.out.println("2 - Attack and dodge");
                System.out.println("3 - Full on attack");
                if (Player.getInstance().getHealCounter() >= 4) {
                    System.out.println("You can also heal 30% of max hp "
                            + Player.getInstance().getHealCounter() + " times");
                    System.out.println("by using healing potion (typing 4)");
                }

                input = Misc.scanner.nextLine();
                System.out.println();
                int inputToInt = 0;
                try {
                    inputToInt = Integer.parseInt(input);
                } catch (Exception ignored){}

                switch (inputToInt) {

                    case 1 -> {
                        System.out.println("You have chosen to be more accurate...");
                        Player.getInstance().setAttack(Player.getInstance().getAttack() - 5)
                                .setDef(Player.getInstance().getDef() + 5)
                                .actionAttack(playerAttackBase, monster);
                        ready = true;
                    }
                    case 2 -> {
                        System.out.println("You have chosen to hit as usual.");
                        Player.getInstance().actionAttack(playerAttackBase, monster);
                        ready = true;
                    }
                    case 3 -> {
                        System.out.println("You have chosen to fight like it's your final blow!");
                        Player.getInstance().setAttack(Player.getInstance().getAttack() + 10)
                                .setDef(Player.getInstance().getDef() - 10)
                                .actionAttack(playerAttackBase, monster);
                        ready = true;
                    }
                    case 4 -> {
                        if (Player.getInstance().getHealCounter() > 0) {
                            Player.getInstance().heal();
                            System.out.println("You are healing your wounds with healing potion.");
                            System.out.println("Now you have " + Player.getInstance().getCurrentHp() + " hp.");
                        } else {
                            System.out.println("Out of potions!");
                        }
                    }
                    default -> System.out.println("Invalid input, try again");
                }
            }

            switch (Misc.rnd.nextInt(0, 3)){
                case 0 -> System.out.println("Creature roars loudly, deafening you for a moment!.." +
                        " but don't hurt you somehow else.");
                case 1 -> {
                    System.out.println("Monster raises it's paw, preparing to hit you...");
                    monster.actionAttack(Player.getInstance().getDef(), Player.getInstance());
                }
                case 2 -> {
                    System.out.println("Monster raises both of it's paws, preparing to hit you hard...");
                    Player.getInstance().setDef(Player.getInstance().getDef()-3);
                    monster.actionAttack(Player.getInstance().getDef(), Player.getInstance());
                }
                case 3 -> {
                    System.out.println("Monster charges into you, preparing to bite you!..");
                    Player.getInstance().setDef(Player.getInstance().getDef() - 8);
                    monster.actionAttack(Player.getInstance().getDef(), Player.getInstance());
                }
            }
            Player.getInstance().setAttack(playerAttackBase)
                    .setDef(playerDefBase);
        }
    }
}