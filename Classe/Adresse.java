package Classe;

import java.io.Serializable;

public class Adresse implements Serializable  {
    //attributs
    private int numero;
    private String rue;
    private String ville;
    private String code_postal;

    //constructeur
    public Adresse(int num,String rue,String ville,String code){
        this.numero=num;
        this.rue=rue;
        this.ville=ville;
        this.code_postal=code;
    }

    //Methode
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getCode_postal() {
        return code_postal;
    }

    public void setCode_postal(String code_postal) {
        this.code_postal = code_postal;
    }


    @Override
    public String toString(){
        return "Adresse[numero:"+this.numero+", rue:"+this.rue+", ville:"+this.ville+", code_postal:"+this.code_postal+"]";
    }

    public boolean equal(Adresse a){
        return this.numero==a.getNumero() && this.rue.equals(a.getRue()) && this.ville.equals(a.getVille()) && this.code_postal.equals(a.getCode_postal());
    }

    
}
