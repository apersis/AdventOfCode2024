package J12;

public class CharBoolString {
    private char caractere;
    private boolean isUtilise;
    private char[] bordure;
    private int iOfFirst;
    private int jOfFirst;
    private int totalArea;
    private int totalBordure;
    private int perimeter;

    public CharBoolString(char caractere, boolean isUtilise) {
        this.caractere = caractere;
        this.isUtilise = isUtilise;
        this.bordure = new char[]{'H','B','G','D'};

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

    public char[] getBordure() {
        return bordure;
    }

    public char getBordure(int index) {
        return bordure[index];
    }

    public void setBordure(char[] bordure) {
        this.bordure = bordure;
    }

    public void changeOneBordure(int index){
        if (this.bordure[index] == ' ') {
            if (index == 0) {
                this.bordure[index] = 'H';
            }
            if (index == 1) {
                this.bordure[index] = 'B';
            }
            if (index == 2) {
                this.bordure[index] = 'G';
            }
            if (index == 3) {
                this.bordure[index] = 'D';
            }
        }else{
            this.bordure[index] = ' ';
        }
    }

    public int countBordure(){
        int total = 0;
        for (int i = 0; i < 4; i++) {
            if (this.bordure[i] != ' '){
                total++;
            }
        }
        return total;
    }

    public int getiOfFirst() {
        return iOfFirst;
    }

    public void setiOfFirst(int iOfFirst) {
        this.iOfFirst = iOfFirst;
    }

    public int getjOfFirst() {
        return jOfFirst;
    }

    public void setjOfFirst(int jOfFirst) {
        this.jOfFirst = jOfFirst;
    }

    public int getTotalArea() {
        return totalArea;
    }

    public void setTotalArea(int area) {
        this.totalArea = area;
    }

    public int getTotalBordure() {
        return totalBordure;
    }

    public void setTotalBordure(int totalBordure) {
        this.totalBordure = totalBordure;
    }

    public int getPerimeter() {
        return perimeter;
    }

    public void setPerimeter(int perimeter) {
        this.perimeter = perimeter;
    }
}
