package neetcode.io.graphs;

class Candidate {
    public int i;
    public int sum;

    public Candidate(int i, int sum) {
        this.i = i;
        this.sum = sum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Candidate other = (Candidate)o;
        return other.i == this.i || other.sum == this.sum;
    }

    @Override
    public int hashCode() {
        return i * 31 + sum;
    }
}
