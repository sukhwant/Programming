package mission.red.leetcode.challenge.feburary;

import java.util.Stack;

public class SimplifyPath {

    public String simplifyPath(String path) {
        
        Stack<String> stack = new Stack<>();

        String[] tokens = path.split("/+");

        if(tokens.length == 0){
            return "/";
        }
        StringBuilder result = new StringBuilder();
        for(String token: tokens){
            if(token.equals(".")){
                continue;
            }
            if(token.equals("..")){
                if(!stack.peek().equals(""))
                    stack.pop();
            } else{
                stack.push(token);
            }
        }

        while(!stack.isEmpty()){
            String curr = stack.pop();
            if(curr.equals("")){
                result.insert(0, "/");
            } else {
                if(result.length()!=0)
                    result.insert(0, "/");
                result.insert(0, curr);
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {

        System.out.println(new SimplifyPath().simplifyPath("/"));
    }
}
