package algorithm.backjoon.stack;

        import java.util.Stack;

public class Quiz2504 {
    public static boolean checkFair(String str1, String str2){
        if((str1.equals("(") && str2.equals(")")) || (str1.equals("[") && str2.equals("]")))
            return false;
        else
            return true;
    }
    public static int solution(String str){
        int sum=0;
        Stack stack = new Stack();
        String[] ch = str.split("");


        for(int i=0; i<ch.length; i++) {
            String pop;
            String peek=null;
            int num;
            System.out.println(stack);

            if (ch[i].equals("(") || ch[i].equals("[")) { // (,[ 일 경우는 push(ch[i])해주고 끝냄.
                stack.push(ch[i]);
            } else if (ch[i].equals("]") || ch[i].equals(")")) {
                num = ch[i].equals(")") ? 2 : 3;
                // pop()을 사용해서 이전 값이 숫자인지 괄호인지 체크한다
                pop = (String) stack.pop();
                if (pop.equals("(") || pop.equals("[")) {
                    if(checkFair(pop,ch[i]))
                        return 0;
                    if(!stack.isEmpty()) {
                        peek = (String)stack.peek();
                        if (peek.equals("(") || peek.equals("[")) { // 이전 값이 괄호일 경우 num을 push해주고 끝냄
                            if(checkFair(peek,ch[i]))
                                return 0;
                            stack.push(num + "");
//                                if(checkFair(peek,ch[i]))
//                                    return 0;
                        }
                        else {//숫자일 경우 더해준다음 push해주고 끝냄
                            num += Integer.parseInt((String) stack.pop());
                            stack.push(num + "");
                        }
                    }else
                        stack.push(num);
                } else { // 숫자일 경우 곱해준다
                    num *= Integer.parseInt(pop);
                    // pop해서 (,[ 괄호 제거
                    if (checkFair((String) stack.pop(), ch[i]))
                        return 0;
                    if(!stack.isEmpty()) {
                        peek = (String)stack.peek();
                        if (peek.equals("(") || peek.equals("[")) { // 이전 값이 괄호일 경우 num을 push해주고 끝냄
                            if (checkFair(peek, ch[i]))
                                return 0;
                            stack.push(num + "");
                        }
                        else {//숫자일 경우 더해준다음 push해주고 끝냄
                            num += Integer.parseInt((String) stack.pop());
                            stack.push(num + "");
                        }
                    }else
                        stack.push(num+"");
                }

            } else { // []() 외의 값일때는 에러이므로 0으로 리턴
                return 0;
            }
        } // for

        try {
            sum = Integer.parseInt((String) stack.pop());
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }
        return sum;
    }

    public static void main(String args[]){
        String str = "[[]][[]";

        System.out.println(solution(str));
    }
}