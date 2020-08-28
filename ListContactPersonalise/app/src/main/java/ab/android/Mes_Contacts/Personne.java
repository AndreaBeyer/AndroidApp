package ab.android.Mes_Contacts;

import android.os.Parcel;
import android.os.Parcelable;

public class Personne implements Parcelable {

    private String nom;
    private int numero;
    private String photo;

    public Personne(String nom, int numero, String photo) {
        this.nom = nom;
        this.numero = numero;
        this.photo = photo;
    }

    protected Personne(Parcel in) {
        nom = in.readString();
        numero = in.readInt();
        photo = in.readString();
    }

    public static final Creator<Personne> CREATOR = new Creator<Personne>() {
        @Override
        public Personne createFromParcel(Parcel in) {
            Personne p = new Personne();
            p.setNom(in.readString());
            p.setNumero(in.readInt());
            p.setPhoto(in.readString());
            return p;
        }

        @Override
        public Personne[] newArray(int size) {
            return new Personne[size];
        }
    };

    public Personne() {

    }

    public Personne(Personne p) {

        this.photo = p.getPhoto();
        this.nom = p.getNom();
        this.numero = p.getNumero();
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }



    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(nom);
        parcel.writeInt(numero);
        parcel.writeString(photo);
    }

}
