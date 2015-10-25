public class Fraction {
    private int upper;
    private int lower = 1;
    private int nod = 1;


    public int getUpper() {
        return upper;
    }

    public int getLower() {
        return lower;
    }

    public Fraction(int nominator, int denominator) throws Exception {
        if (denominator == 0) {
            System.out.println("Denominator cannot be a 0.");
            throw new Exception("Denominator cannot be a 0.");
        }
        upper = nominator;
        lower = denominator;
        searchNod();
    }

    public double getResult() {
        return (double) upper / lower;
    }

    public String toString() {
        if (nod > 1) {
            upper = upper / nod;
            lower = lower / nod;
            nod = 1;
        }
        return upper + "/" + lower;
    }

    public String toString(boolean useNod) {
        if (useNod) {
            return toString();
        } else {
            return upper + "/" + lower;
        }
    }

    public Fraction add(Fraction fr) throws Exception {
        int d = fr.getLower() * lower;
        int a = this.getUpper() * fr.getLower() + lower * fr.getUpper();
        Fraction result = new Fraction(a, d);
        return result;
    }

    public static Fraction random(int maxRange) throws Exception {
       int lower;
        int upper;
        lower = (int) (Math.random() * (maxRange - 1) + 1);
        upper = (int) (Math.random() * maxRange);
        Fraction result = new Fraction(upper, lower);
        return result;
    }

    public Fraction delenie(Fraction d1) throws Exception {
        int k = d1.getLower() * this.upper;
        int h = d1.getUpper() * this.lower;
        Fraction result = new Fraction(k, h);
        return result;
    }

    public Fraction multiplay(Fraction fr1) throws Exception {
        int e = fr1.getLower() * this.lower;
        int r = fr1.getUpper() * this.upper;
        Fraction result = new Fraction(r, e);
        return result;
    }

    private void searchNod() {
        int min;
        if (upper <= lower) {
            min = upper;
        } else {
            min = lower;
        }
        for (int i = min; i >= 1; i--) {
            if ((lower % i == 0) && (upper % i == 0)) {
                nod = i;
                break;
            }
        }
    }
}

