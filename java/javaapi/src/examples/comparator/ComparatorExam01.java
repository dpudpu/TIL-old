package examples.comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorExam01 {

    // 첫번째 방식
    public static Comparator<Book> bookComparator = new Comparator<Book>() {
        @Override
        public int compare(Book o1, Book o2) {
            return o1.getPrice()-o2.getPrice(); // 첫번째 파라미터가 앞에 있으면 오름차순
        }
    };

    public static void main(String[] args) {
        List<Book> myBookList = new ArrayList();
        myBookList.add(new Book(300));
        myBookList.add(new Book(310));
        myBookList.add(new Book(100));
        myBookList.add(new Book(200));

        System.out.println("Original: " + myBookList);

        Collections.sort(myBookList, bookComparator);
        for (Book book : myBookList)
            System.out.println(book.getPrice());



        System.out.println("\n------ AnonymousComparator -------");

        Collections.sort(myBookList, new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return o2.getPrice()-o1.getPrice();  // o2가 앞에 있어야 내림차순.
            }
        });
        for (Book book : myBookList)
            System.out.println(book.getPrice());


        System.out.println("\n------ LambdaComparator -------");

        // (a1, a2) -> { return a1 > a2; }
        //  (a1, a2) -> a1 > a2; 는 같다.
        Collections.sort(myBookList, (Book b1, Book b2)-> b1.getPrice()-b2.getPrice());

        for (Book book : myBookList)
            System.out.println(book.getPrice());


    }
}
