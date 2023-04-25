package sarah.thurnwald.data;

public class Bag {
    private String person;

    public Bag() {
        this.person = "Sarah";
    }

    @Override
    public String toString() {
        return "Bag{" +
                "person='" + person + '\'' +
                '}';
    }
}
