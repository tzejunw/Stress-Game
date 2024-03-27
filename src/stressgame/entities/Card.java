package stressgame.entities;
public class Card {

    //private class Card {
        String value;
        String type;

        // constructor
        public Card(String value, String type) {
            this.value = value;
            this.type = type;
        }

        // override the toString method here
        public String toString() {
            return value + "-" + type;
        }

        public int getValue() {
            if ("AJQK".contains(value)) {
                if (value == "J") {
                    return 11;
                }
                if (value == "Q") {
                    return 12;
                }
                if (value == "K") {
                    return 13;
                }
                if (value == "A") {
                    return 14;
                }
            }
            return Integer.parseInt(value); // 2-10
        }

        public String getImagePath() {
            return "./src/cards/" + toString() + ".png";
        }    
}
