public class Pair {
    private Character character1;
    private Character character2;

    public Pair(Character character1, Character character2) {
        this.character1 = character1;
        this.character2 = character2;
    }

    public Character getCharacter1() {
        return character1;
    }

    public void setCharacter1(Character character1) {
        this.character1 = character1;
    }

    public Character getCharacter2() {
        return character2;
    }

    public void setCharacter2(Character character2) {
        this.character2 = character2;
    }

    @Override
    public String toString() {
        return "Pair{"
                + character1 +
                " vs "
                + character2 +
                '}';
    }
}
