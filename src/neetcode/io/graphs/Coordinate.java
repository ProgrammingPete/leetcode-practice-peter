package neetcode.io.graphs;

class Coordinate {
    int row = 0; 
    int col = 0;
    public Coordinate(int row, int col) {
        this.row = row;
        this.col = col;
    }
    @Override
    public String toString(){
        return "[" + row + "," + col + "]";
    }
    @Override
    public boolean equals(Object o) {
        if(o == this)
            return true;
        if(!(o instanceof Coordinate))
            return false;
        Coordinate other = (Coordinate)o;
        return (other.col == this.col && other.row == this.row);
    }
    @Override
    public final int hashCode(){
        return 31 * this.row * this.col;
    }
} 
