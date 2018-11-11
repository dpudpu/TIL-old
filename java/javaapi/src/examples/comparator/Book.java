package examples.comparator;

public class Book implements Comparable<Book> {
    private int price;
    public Book(int price){
        this.price = price;
    }
    public int getPrice(){
        return this.price;
    }

    @Override
    public int compareTo(Book o) {
        return this.price-o.price; // 자신이 앞에있는게 오름차순
    }

    @Override
    public String toString() {
        return this.price+"";
    }
}