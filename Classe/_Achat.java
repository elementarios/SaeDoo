package Classe;

public class _Achat {
    //atribut
    public Client client;
    public Billet billet;
    public String methodePayement;

    //constructeur
    public _Achat(Client c,Billet b,String methode){
        this.client=c;
        this.billet=b;
        this.methodePayement=methode;
    }

    //methode
    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Billet getBillet() {
        return billet;
    }

    public void setBillet(Billet billet) {
        this.billet = billet;
    }

    public String getMethodePayement() {
        return methodePayement;
    }

    public void setMethodePayement(String methodePayement) {
        this.methodePayement = methodePayement;
    }

    @Override
    public String toString(){
        return "_Achat["+this.client.toString()+" ,"+this.billet.toString()+", methodePayement:"+this.methodePayement+"]";
    }

    public boolean equal(_Achat a){
        return this.client.equal(a.getClient()) && this.billet.equal(a.getBillet()) && this.methodePayement.equals(a.getMethodePayement());
    }

    public void achat(){
        this.billet.setClient(this.client);
        this.client.add(billet);
    }
}
