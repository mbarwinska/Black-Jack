import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Card {
    private String name;
    private int points;

    @Override
    public String toString() {
        return "{name='" + name + '\'' +
                ", points=" + points +
                '}';
    }
}
