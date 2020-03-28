import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.List;


public class Main {

    private static Faker faker = new Faker();
    private static boolean isSlowMode = false;

    public static void main(String[] args) {
        isSlowMode = isSlowMode(args);
        int characterSize = 16;

        List<Character> characterList = getCharacters(characterSize);

        List<Character> winnerList = new ArrayList<>();
        List<Character> loserList = new ArrayList<>();

        int totalRound = getTotalRound(characterSize);

        for (int i = 0; i < totalRound; i++) {
            do {
                Pair pair = getPair(characterList);
                try {
                    Game game = fight(pair);
                    System.out.println(game);

                    characterList.remove(game.getWinner());
                    characterList.remove(game.getLoser());

                    winnerList.add(game.getWinner());
                    loserList.add(game.getLoser());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } while (characterList.size() != 0);

            printRoundResult(winnerList, loserList);
            characterList.addAll(winnerList);
            winnerList.clear();
            loserList.clear();
        }

        System.out.println();

        System.out.println(characterList.get(0).getName() + " is the Champion!");
    }

    private static boolean isSlowMode(String[] args) {
        String key = args[0];
        String value = args[1];

        if (key.equals("SLOW_MODE")) {
            return value.equals("true");
        } else {
            return false;
        }
    }

    public static int getTotalRound(int characterSize) {
        int totalRound = 0;
        do {
            characterSize = characterSize / 2;
            totalRound++;
        } while (characterSize != 1);
        return totalRound;
    }

    public static List<Character> getCharacters(int size) {
        List<Character> characters = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            Weapon weapon = new Weapon(faker.animal().name(), faker.number().numberBetween(1, 10));
            Character character = new Character(faker.name().fullName(), weapon, faker.number().numberBetween(50, 100), faker.nation().nationality());
            characters.add(character);
        }
        return characters;
    }

    public static Pair getPair(List<Character> characters) {
        int randomIndex1;
        int randomIndex2;

        do {
            randomIndex1 = faker.number().numberBetween(0, characters.size());
            randomIndex2 = faker.number().numberBetween(0, characters.size());
        } while (randomIndex1 == randomIndex2);

        Character character1 = characters.get(randomIndex1);
        Character character2 = characters.get(randomIndex2);

        return new Pair(character1, character2);
    }

    private static Game fight(Pair pair) throws InterruptedException {
        Character character1 = pair.getCharacter1();
        Character character2 = pair.getCharacter2();
        int round = 0;

        System.out.println(pair);

        do {
            int damage1 = faker.number().numberBetween(0, character1.getWeapon().getDamage() + 1);
            int damage2 = faker.number().numberBetween(0, character2.getWeapon().getDamage() + 1);

            character1.setHealth(character1.getHealth() - damage2);
            System.out.println(character2.getName() + " hit " + damage2);
            System.out.println(character1.getName() + "'s Health: " + character1.getHealth());
            character2.setHealth(character2.getHealth() - damage1);
            System.out.println(character1.getName() + " hit " + damage1);
            System.out.println(character2.getName() + "'s Health: " + character2.getHealth());

            System.out.println("____________________________________________");

            if (isSlowMode) Thread.sleep(1000);

            round++;
        } while (character1.getHealth() > 0 && character2.getHealth() > 0);

        if (character1.getHealth() <= 0) return new Game(character2, character1, round);
        else return new Game(character1, character2, round);
    }

    private static void printRoundResult(List<Character> winnerList, List<Character> loserList) {
        System.out.println("Winners : ");
        for (Character winner : winnerList) {
            System.out.println(winner.getName());
        }
        System.out.println();
        System.out.println("Losers: ");
        for (Character loser : loserList) {
            System.out.println(loser.getName());
        }
        System.out.println();
    }
}
