//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "()"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s = "()[]{}"
//输出：true
// 
//
// 示例 3： 
//
// 
//输入：s = "(]"
//输出：false
// 
//
// 示例 4： 
//
// 
//输入：s = "([)]"
//输出：false
// 
//
// 示例 5： 
//
// 
//输入：s = "{[]}"
//输出：true 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 104 
// s 仅由括号 '()[]{}' 组成 
// 
// Related Topics 栈 字符串 
// 👍 2539 👎 0


package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Stack;

//Java：有效的括号
public class T20_ValidParentheses {
    public static void main(String[] args) {
        Solution solution = new T20_ValidParentheses().new Solution();
        // TO TEST
        boolean valid = solution.isValid("{}[]()");
        System.out.println(valid);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //设置字符串的对应关系
        HashMap<String, String> map = new HashMap<String, String>() {
            {
                put("(", ")");
                put("[", "]");
                put("{", "}");
            }
        };

        public boolean isValid(String s) {
            Stack<String> stack = new Stack<>();
            char[] chars = s.toCharArray();
            //字符串长度是奇数 肯定不符合要求
            if (chars.length % 2 != 0) {
                return false;
            }
            for (char aChar : chars) {
                //栈长度不为0 则判断字符是否成对
                if (stack.size() > 0) {
                    String str = stack.get(stack.size() - 1);
                    String s1 = map.get(str) != null ? map.get(str) : "";
                    if (String.valueOf(aChar).equals(s1)) {
                        stack.pop();
                    } else {
                        stack.push(aChar + "");
                    }
                } else {
                    stack.push(aChar + "");
                }
            }
            return stack.size() == 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}