class Solution {
    public int calculate(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        int num = 0;
        char sign = '+';
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);

            if (Character.isDigit(c)){
                num = num * 10 + (c - '0');
            } else if (c == '('){
                int j = i + 1, count = 1;
                for (; j < s.length(); j++){
                    if (s.charAt(j) == '(') {
                        count++;
                    } else if (s.charAt(j) == ')') {
                        count--;
                    }
                    if (count == 0) break;
                }
                num = calculate(s.substring(i + 1, j));
                i = j;
            }

            if (!Character.isDigit(c) && c != ' ' || i == s.length() - 1){
                if (sign == '+'){
                    stack.push(num);
                }
                else if (sign == '-'){
                    stack.push(-num);
                }
                else if (sign == '*'){
                    stack.push(stack.pop() * num);
                }
                else if (sign == '/'){
                    stack.push(stack.pop() / num);
                }

                sign = c;
                num = 0;
            }
        }

        int ans = 0;
        while (!stack.isEmpty()){
            ans += stack.pop();
        }

        return ans;
    }
}
