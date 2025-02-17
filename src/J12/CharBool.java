package J12;

public class CharBool {
    private char caractere;
    private boolean isUtilise;

    public CharBool(char caractere, boolean isUtilise) {
        this.caractere = caractere;
        this.isUtilise = isUtilise;
    }

    public char getCaractere() {
        return caractere;
    }

    public void setCaractere(char caractere) {
        this.caractere = caractere;
    }

    public boolean isUtilise() {
        return isUtilise;
    }

    public void setUtilise(boolean utilise) {
        isUtilise = utilise;
    }
}
