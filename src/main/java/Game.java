import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Game {
    private List<Card> playerCards = new ArrayList<>();
    private List<Card> croupierCards = new ArrayList<>();

    public static void main(String[] args) {
        Game game = new Game();
        game.playGame();
    }

    public void playGame() {
        playerNextMove();
        croupierNextMove();
        int croupierPoints = countPoints(croupierCards);
        int playerPoints = countPoints(playerCards);
        if (playerPoints <= 21 && playerPoints > croupierPoints) {
            System.out.println("You won");
        } else if (playerPoints == croupierPoints && playerPoints == 21) {
            System.out.println("Draw!");
        } else {
            System.out.println("You lost!");
        }
    }

    private void croupierNextMove() {
        int croupierPoints = countPoints(croupierCards);
        while (croupierPoints <= 16) {
            croupierCards.add(getCard());
           croupierPoints = countPoints(croupierCards);
        }
        System.out.println("Croupier cards: " + croupierCards);
    }

    private void playerNextMove() {
        showCards();
        boolean nextMove = true;
        while (nextMove) {
            switch (playerMove()) {
                case "hit":
                    hit();
                    int playerPoints = countPoints(playerCards);
                    if (playerPoints > 21) {
                        nextMove = false;
                    }
                    break;
                case "stand":
                    System.out.println("Your cards: " + playerCards);
                    nextMove = false;
                    break;
            }
        }
    }

    private void hit() {
        playerCards.add(getCard());
        System.out.println("Your cards: " + playerCards);
    }

    private String playerMove() {
        System.out.println("Hit or stand?");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    private int countPoints(List<Card> cards) {
        boolean hasAce = cards.stream().map(Card::getName).anyMatch(x -> x.equals("Ace"));
        int pointsSum = cards.stream().map(Card::getPoints).mapToInt(x -> x).sum();
        if (pointsSum > 21 && hasAce) {
                for (int i = 0; i < cards.size();i++) {
                    if (cards.get(i).getName().equals("Ace"))
                    cards.get(i).setPoints(1);
                }
                return cards.stream().map(Card::getPoints).mapToInt(x -> x).sum();
        }
        return pointsSum;
    }

    private void showCards() {
        createStartingDeck();
        System.out.println("Croupier cards: " + croupierCards.get(0));
        System.out.println("Your cards: " + playerCards);
    }

    private void createStartingDeck() {
        int startingDeckSize = 2;
        for (int i = 0; i < startingDeckSize; i++) {
            croupierCards.add(getCard());
            playerCards.add(getCard());
        }
    }

    private Card getCard() {
        CardDeck cardDeck = new CardDeck();
        List<Card> deck = cardDeck.createCardDeck();
        Random random = new Random();
        return deck.get(random.nextInt(deck.size()));
    }
}
