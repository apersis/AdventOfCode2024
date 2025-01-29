package J05;

public class Paire {
    int avant;
    int apres;

    public int getAvant() {
        return avant;
    }

    public void setAvant(int avant) {
        this.avant = avant;
    }

    public int getApres() {
        return apres;
    }

    public void setApres(int apres) {
        this.apres = apres;
    }

    public Paire(int avant, int apres) {
        this.avant = avant;
        this.apres = apres;
    }

    public Paire(){

    }

    public Paire getPaireIfMatch(int premier, int deuxieme){
        if ((avant == premier && apres == deuxieme) || (avant == deuxieme && apres == premier)){
            return this;
        }
        return null;
    }
}
