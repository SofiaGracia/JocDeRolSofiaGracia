
package altres;

public class Poder {
    private String nom;
    private int bonusAtac;
    private int bonusDefensa;

    @Override
    public String toString() {
        return "\t- "+this.nom+" (BA:"+this.bonusAtac+", "+"BD:"+this.bonusDefensa+")";
    }
    
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

    @Override
    public boolean equals(Object obj) {
        final Poder pod = (Poder) obj;
        return this.nom.equals(pod.nom);
    }
    
}
