public class Character {

    private String name;
    private Weapon weapon;
    private int health;
    private String nation;

    public Character(String name, Weapon weapon, int health, String nation) {
        this.name = name;
        this.weapon = weapon;
        this.health = health;
        this.nation = nation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    @Override
    public String toString() {
        return "Character{" +
                "name='" + name + '\'' +
                ", weapon=" + weapon +
                ", health=" + health +
                ", nation='" + nation + '\'' +
                '}';
    }
}
