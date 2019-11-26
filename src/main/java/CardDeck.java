import java.util.Arrays;
import java.util.List;

class CardDeck {

    List<Card> createCardDeck() {
        return Arrays.asList(new Card("Ace", 11)
                , new Card("King", 10)
                , new Card("Queen", 10)
                , new Card("Jack", 10)
                , new Card("10", 10)
                , new Card("9", 9)
                , new Card("8", 8)
                , new Card("7", 7)
                , new Card("6", 6)
                , new Card("5", 5)
                , new Card("4", 4)
                , new Card("3", 3)
                , new Card("2", 2));
    }
}
