package ru.anxidy;
public class Main {
    public static void main(String[] args) {

        int input;
        boolean ready = false;

        System.out.println("You are in the middle of a fight.");
        System.out.println("There's only you and demonic shadowy creature...");
        System.out.println("...and only one of you will survive this encounter!");
        System.out.println();

        while (!ready){
            System.out.println("How will you fight for your life?");
            System.out.println("With shield and sword for maximum defence?");
            System.out.println("With zweihander for middle defence and attack?");
            System.out.println("Or with double daggers for maximum attack capabilities?");
            System.out.println("Choose by typing 1, 2 or 3 accordingly.");
            System.out.println();

            if (Misc.scanner.hasNextInt()) {
            input = Misc.scanner.nextInt();
                switch (input) {
                    case 1 -> {
                        Player.classConstructor(Misc.rnd.nextInt(1, 10),Misc.rnd.nextInt(20, 30),10,30);
                        ready = true;
                        System.out.println("You have chosen shield and sword.");
                    }
                    case 2 -> {
                        Player.classConstructor(Misc.rnd.nextInt(10, 20),Misc.rnd.nextInt(10, 20),15,40);
                        ready = true;
                        System.out.println("You have chosen zweihander.");
                    }
                    case 3 -> {
                        Player.classConstructor(Misc.rnd.nextInt(10, 20),Misc.rnd.nextInt(1, 10),20,45);
                        ready = true;
                        System.out.println("You have chosen daggers.");
                    }
                    default -> System.out.println("Invalid input, try again");
                }
            }
            else System.out.println("Invalid input, try again");
        }

        Entity monster = new Enemy(
                100,
                Misc.rnd.nextInt(1, 30),
                Misc.rnd.nextInt(1, 30),
                10,
                25);

        System.out.println();
        System.out.println("Creature's health - " + monster.getCurrentHp() + " , attack - " + monster.getAttack() + " , defence - " + monster.getDef() + ".");
        System.out.println("Time to fight this monstrosity!");

        while (true){

            System.out.println("Choose your next move:");
            System.out.println("1 - Defencive tactic");
            System.out.println("2 - Attack and dodge");
            System.out.println("3 - Full on attack");
            if (Player.getInstance().getHealCounter() >= 4){
                System.out.println("You can also heal 30% of max hp " + Player.getInstance().getHealCounter() + " times");
                System.out.println("by using healing potion (typing 4)");
            }
            System.out.println();

            if (Misc.scanner.hasNextInt()) {
            input = Misc.scanner.nextInt();
                switch (input) {
                    case 1 -> {

                    }
                    case 2 -> {

                    }
                    case 3 -> {

                    }
                    case 4 -> {

                    }
                    default -> System.out.println("Invalid input, try again");
                }
            }
            else System.out.println("Invalid input, try again");
        }
    }
}