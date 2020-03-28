import org.junit.Assert;

import java.util.List;

public class Test {

    @org.junit.Test
    public void getCharacters() {
        int size = 10;
        List<Character> characterList = Main.getCharacters(size);
        Assert.assertEquals(characterList.size(), size);
    }

    @org.junit.Test
    public void getPair() {
        int size = 10;
        List<Character> characterList = Main.getCharacters(size);

        for (int i = 0; i < 100; i++) {
            Pair pair = Main.getPair(characterList);
            Assert.assertNotEquals(pair.getCharacter1(), pair.getCharacter2());
        }
    }

    @org.junit.Test
    public void getTotalRound() {
        int characterSize = 32;
        int result = Main.getTotalRound(characterSize);

        Assert.assertEquals(5, result);
    }
}
