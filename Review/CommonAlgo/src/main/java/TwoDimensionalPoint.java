public class TwoDimensionalPoint {
    private int x;
    private int y;

    public TwoDimensionalPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + Integer.hashCode(this.x);
        result = prime * result + Integer.hashCode(this.y);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
       if (obj != this) return false;
       if (!(obj instanceof TwoDimensionalPoint)) return false;
       if (this.x != ((TwoDimensionalPoint) obj).getX() || this.y != ((TwoDimensionalPoint) obj).getY()) return false;
       return true;
    }

}

