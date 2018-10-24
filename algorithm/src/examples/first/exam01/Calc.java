package examples.first.exam01;
/**
 * 간단한 계산기
 */

public class Calc {
    // 필드(속성)를 선언
    private int value;

    // 기본생성자.
    public Calc() {
        this.value = 0;
    }

    public Calc(int value) {
        // 필드 value를 파라미터 value로 초기화 한다.
        this.value = value;
    }

    /**
     * @param plusValue
     * plusValue를 받아서 누적한다.
     */
    public void plus(int plusValue) {
        this.value = this.value + plusValue;
    }

    /**
     * 내부적인 값을 반환한다.
     * @return
     */
    public int getValue() {
        return this.value;
    }

    /**
     * @param subValue
     * 빼기
     */
    public void sub(int subValue) {
        this.value = this.value - subValue;
    }

    /**
     * 곱하기
     */
    public void mul(int mulValue) {
        this.value = this.value * mulValue;
    }

    /**
     * @param divValue
     * 나누기
     */
    public void div(int divValue) {
        this.value =this.value/divValue;
    }

    /**
     * 클리어
     */
    public void clear(){
        this.value=0;
    }

}
