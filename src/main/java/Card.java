import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@AllArgsConstructor
public class Card {
    private String name;
    @Setter
    @Getter
    private int points;

    @Override
    public String toString() {
        return "{name='" + name + '\'' +
                ", points=" + points +
                '}';
    }
}
