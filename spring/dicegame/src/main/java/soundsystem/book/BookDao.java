package soundsystem.book;

import org.springframework.stereotype.Component;

@Component
public class BookDao {
    public BookDao(){
        System.out.println("BookDao");
    }

    public void crud(){
        System.out.println("crud");
    }
}
