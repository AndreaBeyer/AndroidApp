package ab.android.Mes_Contacts;

import android.graphics.drawable.Drawable;

public class Personne {
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Drawable getPhoto() {
        return photo;
    }

    public void setPhoto(Drawable photo) {
        this.photo = photo;
    }

    private String nom;
    private String numero;
    private Drawable photo;

    public Personne(String nom, String numero, Drawable photo) {
        this.nom = nom;
        this.numero = numero;
        this.photo = photo;
    }
}
