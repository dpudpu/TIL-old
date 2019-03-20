package algorithm.codility.lesson03;

public class FrogJmp {
    public static int solution(int X, int Y, int D) {
        double res = (double)(Y-X)/D;
        return (int)Math.ceil(res);
    }

    public static void main(String[] args) {
        System.out.println(solution(10,85,30));
    }
}
