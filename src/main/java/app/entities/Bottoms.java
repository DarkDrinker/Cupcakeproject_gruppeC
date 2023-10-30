package app.entities;

public class Bottoms {

        private int topId;
        private String name;
        private double price;


        public Bottoms(int topId, String name, double price) {
            this.topId = topId;
            this.name = name;
            this.price = price;
        }

        public int getTopId() {
            return topId;
        }

        public String getName() {
            return name;
        }

        public double getPrice() {
            return price;
        }

}

