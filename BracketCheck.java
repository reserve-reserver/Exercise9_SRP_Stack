import java.util.Deque;
import java.util.ArrayDeque;

public class BracketCheck {
    public static void main(String[] args) {
        String test = "{[()]}"; // 你可以随便改
        System.out.println("括号是否合法：" + isBalanced(test));
    }

    public static boolean isBalanced(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else if (c == ')' || c == ']' || c == '}') {
                if (stack.isEmpty()) return false;

                char top = stack.pop();
                if (c == ')' && top != '(') return false;
                if (c == ']' && top != '[') return false;
                if (c == '}' && top != '{') return false;
            }
        }
        return stack.isEmpty();
    }
}