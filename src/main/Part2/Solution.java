package main.Part2;

/**
 * @Author: Lwq
 * @Date: 2018/8/12 23:35
 * @Version 1.0
 * @Describe
 */
public class Solution {
    public boolean isValid(String s){
        Stack<Character> stack = new ArrayStack<>();
        for(int i = 0; i < s.length() ; i++){
            char c = s.charAt(i);
            if(c=='('||c=='{'||c=='['){
                stack.push(c);
            }
            else {
                if(stack.isEmpty()){
                    return false;
                }
                char topChar = stack.pop();
                if(c==')'  && topChar!='('){
                    return false;
                }
                if(c=='}' && topChar!='{'){
                    return false;
                }
                if(c==']'&&topChar!='['){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
    public static void main(String[] args) {

        System.out.println((new Solution()).isValid("()[]{}"));
        System.out.println((new Solution()).isValid("([)]"));
    }

}
