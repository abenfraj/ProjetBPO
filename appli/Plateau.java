package appli;

import java.util.ArrayList;

public class Plateau {
    private int pileAscNORD;
    private int pileDescNORD;
    private int pileAscSUD;
    private int pileDescSUD;

    public Plateau(){
        this.pileAscNORD = 1;
        this.pileDescNORD = 60;
        this.pileAscSUD = 1;
        this.pileDescSUD = 60;
    }

    public int getPileAscNORD(){
        return this.pileAscNORD;
    }

    public int getPileDescNORD(){
        return this.pileDescNORD;
    }

    public boolean poseValideAscNORD(String s){
        if(Integer.parseInt(s) > this.pileAscNORD || Integer.parseInt(s) == (this.pileAscNORD - 10)){
            return true;
        }
        return false;
    }

    public boolean poseValideDescNORD(String s){
        if(Integer.parseInt(s) < this.pileDescNORD || Integer.parseInt(s) == (this.pileDescNORD + 10)){
            return true;
        }
        return false;
    }

    public void afficherStatutPlateau(Joueur j1, Joueur j2){
        System.out.println(j1.getNomJoueur()+" ^["+this.pileAscNORD+"] v["+this.pileDescNORD+"] (m"+j1.getTailleMain()+"p"+j1.getTailleDeck()+")");
        System.out.println(j2.getNomJoueur()+"  ^["+this.pileAscSUD+"] v["+this.pileDescSUD+"] (m"+j2.getTailleMain()+"p"+j2.getTailleDeck()+")");
    }
}
