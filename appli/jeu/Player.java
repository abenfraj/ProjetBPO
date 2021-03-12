package appli.jeu;

import java.util.Collections;

public class Player {
    private String name;
    private Deck deck;
    private Hand hand;

    /**
     * @brief Constructeur initialisant les attributs d'un joueur (son nom, sa main et son deck)
     * @param name le nom du joueur à saisir lors de la création d'une nouvelle instance
     */
    public Player(String name) {
        this.name = name;
        this.deck = new Deck();
        this.deck.initialize();
        this.hand = new Hand();
    }

    /**
     * @brief permet de piocher une carte du deck et la mettre dans sa main
     * @param number le nombre de cartes à piocher
     */
    public void draw(int number) {
        for (int i = 0; i < number; i++) {
            hand.add(deck.get(i));
            deck.remove(i);
        }
        Collections.sort(this.hand);
    }

    /**
     * @brief permet de vérifier si un joueur peut jouer au minimum deux cartes avant de le
     * laisser saisir sa chaîne de caractère
     * @param hand la main du joueur
     * @param board le plateau de jeu
     * @return true si le joueur peut jouer
     */
    public boolean checkIfCanPlay(Hand hand, Board board, Player player) {
        boolean canPlay = true;
        int playableCards = 0;

        if (hand.size() == 1) {
            canPlay = false;
        }

        for (int card : hand) {
            if (Rules.isPlayable(card, board, player)) {
                playableCards++;
            }
            if (playableCards >= 2) {
                return canPlay;
            }
        }
        return canPlay;
    }

    /**
     * @brief permet de savoir si un joueur à jouer toutes ses cartes (main et deck)
     * @param hand la main du joueur
     * @param deck le deck du joueur
     * @return true si la main ainsi que le deck est vide
     */
    public boolean checkIfFinished(Hand hand, Deck deck) {
        return hand.size() == 0 && deck.size() == 0;
    }

    /**
     * @brief permet de jouer une carte sur la pile ciblée
     * @param cardValue la valeur de la carte
     * @param target la pile ciblée
     */
    public void playCard(int cardValue, Pile target) {
        int cardIndex = hand.indexOf(cardValue);
        hand.remove(cardIndex);
        target.setActualValue(cardValue);
    }

    /**
     * @brief permet d'obtenir le deck du joueur
     * @return le Deck du joueur
     */
    public Deck getDeck() {
        return this.deck;
    }

    /**
     * @brief permet d'obtenir la main du joueur
     * @return la main du joueur
     */
    public Hand getHand() {
        return this.hand;
    }

    /**
     * @brief permet de mettre à jour la valeur de la pile (attribut privé)
     * @param hand la nouvelle valeur de la main
     */
    public void setHand(Hand hand){
        this.hand = hand;
    }

    /**
     * @brief permet d'obtenir le nom du joueur
     * @return le nom du joueur
     */
    public String getName() {
        return this.name;
    }
}
