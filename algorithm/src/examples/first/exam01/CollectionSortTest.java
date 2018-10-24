package examples.first.exam01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CollectionSortTest {
    public static void main(String[] args){

        List<Book> bookList = new ArrayList<Book>();

        bookList.add(new Book("홍길동전",2000));
        bookList.add(new Book("까치",6000));
        bookList.add(new Book("까마귀",8000));

//        Collections.sort(bookList);

        Collections.sort(bookList, new BookComparator() );
        for(Book b : bookList){
            System.out.println(b);
        }
        System.out.println();


    }
}


class Book implements Comparable<Book>{
    private String title;
    private int price;

    public Book(String title, int price) {
        this.title = title;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public int getPrice() {
        return price;
    }


    public void setTitle(String title) {
        this.title = title;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return title+" "+price;
    }

    @Override
    public int compareTo(Book o) {
        return price-o.price;
    }
}
class BookComparator implements Comparator<Book>{
    @Override
    public int compare(Book o1, Book o2) {
        return o1.getTitle().compareTo(o2.getTitle());
    }

}
