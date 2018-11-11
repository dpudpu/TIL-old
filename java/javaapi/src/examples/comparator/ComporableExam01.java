package examples.comparator;

import java.util.*;

public class ComporableExam01 {
    public static void main(String[] args) {
        List<Book> myBookList = new ArrayList();
        myBookList.add(new Book(300));
        myBookList.add(new Book(310));
        myBookList.add(new Book(100));
        myBookList.add(new Book(200));

        System.out.println("Original: " + myBookList);

        Collections.sort(myBookList);

        for (Book book : myBookList)
            System.out.println(book.getPrice());

    }
}
