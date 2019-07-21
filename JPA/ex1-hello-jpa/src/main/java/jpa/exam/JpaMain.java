package jpa.exam;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("exam");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        try {

            // 비영속
            Member member = new Member();
            member.setId(1L);
            member.setName("foo");

            System.out.println("--------------before persist");
            //영속
            em.persist(member);
            System.out.println("--------------after persist");

            // 준영속 jpa에서 더이상 관리하지 않아서 디비에 커밋이 안된다.
            em.detach(member);

            System.out.println("--------------before flush");
            em.flush();
            System.out.println("--------------after flush");

            System.out.println("-----------before update");
            member.setName("Asd");
            System.out.println("-----------after update");
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}
