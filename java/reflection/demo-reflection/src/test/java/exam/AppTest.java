package exam;

import org.junit.jupiter.api.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;


class AppTest {

    private Class<Book> bookClass = Book.class;

    @Test
    void 타입으로_접근() {
        Class<Book> bookClass = Book.class;

        assertNotNull(bookClass);
    }

    @Test
    void 인스턴스로_접근() {
        Book book = new Book();
        Class<? extends Book> aClass = book.getClass();

        assertNotNull(aClass);
    }

    @Test
    void 문자열로_접근() throws ClassNotFoundException {
        Class<?> aClass = Class.forName("exam.Book");

        assertNotNull(aClass);
    }

    @Test
    void private_필드만_조회() {
        Field[] fields = bookClass.getFields();
        Arrays.stream(fields).forEach(System.out::println);

        assertThat(fields).hasSize(1);
    }

    @Test
    void 모든_필드_조회() {
        Field[] declaredFields = bookClass.getDeclaredFields();
        Arrays.stream(declaredFields).forEach(System.out::println);

        assertThat(declaredFields).hasSize(5);
    }

    @Test
    void 모든_필드_값_조회() {
        Field[] declaredFields = bookClass.getDeclaredFields();
        Book book = new Book();

        Arrays.stream(declaredFields).forEach(f -> {
            try {
                f.setAccessible(true);
                System.out.println(f + " ---- " + f.get(book));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        });

        assertThat(declaredFields).hasSize(5);
    }

    @Test
    void 접근제어자_확인() {
        Field[] declaredFields = bookClass.getDeclaredFields();

        Arrays.stream(declaredFields).forEach(f->{
            int modifiers = f.getModifiers();
            System.out.println(f);
            System.out.println(modifiers);
            System.out.println(Modifier.isPrivate(modifiers));
            System.out.println(Modifier.isStatic(modifiers));
            System.out.println("------------");
        });
    }

    @Test
    void 애노테이션_조회() {
        Annotation[] annotations = bookClass.getAnnotations();

        assertThat(annotations).hasSize(1);
        assertThat(annotations[0] instanceof MyAnnotation).isTrue();
    }
}