package arena;

public class Weapon {
    private int size;
    private int solidity;
    private int sharpness;

    public Weapon(int size, int solidity, int sharpness) {
        this.size = size;
        this.solidity = solidity;
        this.sharpness = sharpness;
    }

    public int getSize() {
        return this.size;
    }

    public int getSolidity() {
        return this.solidity;
    }

    public int getSharpness() {
        return this.sharpness;
    }
}
