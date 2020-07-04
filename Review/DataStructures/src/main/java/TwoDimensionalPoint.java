public class TwoDimensionalPoint implements Comparable<TwoDimensionalPoint>{
    private int x;
    private int y;
    private PointDirection pointDirection;
    public TwoDimensionalPoint(int x, int y, PointDirection pointDirection) {
        this.x = x;
        this.y = y;
        this.pointDirection = pointDirection;
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
        result = prime * result + pointDirection.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object obj) {
       if (obj != this) return false;
       if (!(obj instanceof TwoDimensionalPoint)) return false;
       if (this.x != ((TwoDimensionalPoint) obj).getX()) return false;
       if (this.y != ((TwoDimensionalPoint) obj).getY()) return false;
       if (this.pointDirection != ((TwoDimensionalPoint) obj).getPointDirection()) return false;
       return true;
    }

    public PointDirection getPointDirection() {
        return pointDirection;
    }

    @Override
    public int compareTo(TwoDimensionalPoint twoDimensionalPoint) {
        if(twoDimensionalPoint.pointDirection == PointDirection.VERTICAL){
            return Integer.compare(this.x, twoDimensionalPoint.getX());
        } else {
            return Integer.compare(this.y, twoDimensionalPoint.getY());
        }
    }
}


