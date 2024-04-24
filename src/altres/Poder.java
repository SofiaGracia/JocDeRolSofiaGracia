
package altres;

public class Poder {
    private String nom;

    @Override
    public String toString() {
        return this.nom+" (BA:"+this.bonusAtac+", "+"BD:"+this.bonusDefensa+")";
    }
    private int bonusAtac;
    private int bonusDefensa;

    public Poder(String nom, int bonusAtac, int bonusDefensa) {
        this.nom = nom;
        this.bonusAtac = bonusAtac;
        this.bonusDefensa = bonusDefensa;
    }

    public int getBonusDefensa() {
        return bonusDefensa;
    }

    public void setBonusDefensa(int bonusDefensa) {
        this.bonusDefensa = bonusDefensa;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getBonusAtac() {
        return bonusAtac;
    }

    public void setBonusAtac(int bonusAtac) {
        this.bonusAtac = bonusAtac;
    }
}
