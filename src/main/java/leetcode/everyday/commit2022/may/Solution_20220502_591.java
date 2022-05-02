package leetcode.everyday.commit2022.may;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.regex.Pattern;

/**
 * 591  标签验证器
 *
 * 给定一个表示代码片段的字符串，你需要实现一个验证器来解析这段代码，并返回它是否合法。合法的代码片段需要遵守以下的所有规则：
 *
 * 代码必须被合法的闭合标签包围。否则，代码是无效的。
 * 闭合标签（不一定合法）要严格符合格式：<TAG_NAME>TAG_CONTENT</TAG_NAME>。其中，<TAG_NAME>是起始标签，</TAG_NAME>是结束标签。起始和结束标签中的 TAG_NAME 应当相同。当且仅当 TAG_NAME 和 TAG_CONTENT 都是合法的，闭合标签才是合法的。
 * 合法的 TAG_NAME 仅含有大写字母，长度在范围 [1,9] 之间。否则，该 TAG_NAME 是不合法的。
 * 合法的 TAG_CONTENT 可以包含其他合法的闭合标签，cdata （请参考规则7）和任意字符（注意参考规则1）除了不匹配的<、不匹配的起始和结束标签、不匹配的或带有不合法 TAG_NAME 的闭合标签。否则，TAG_CONTENT 是不合法的。
 * 一个起始标签，如果没有具有相同 TAG_NAME 的结束标签与之匹配，是不合法的。反之亦然。不过，你也需要考虑标签嵌套的问题。
 * 一个<，如果你找不到一个后续的>与之匹配，是不合法的。并且当你找到一个<或</时，所有直到下一个>的前的字符，都应当被解析为 TAG_NAME（不一定合法）。
 * cdata 有如下格式：<![CDATA[CDATA_CONTENT]]>。CDATA_CONTENT 的范围被定义成 <![CDATA[ 和后续的第一个 ]]>之间的字符。
 * CDATA_CONTENT 可以包含任意字符。cdata 的功能是阻止验证器解析CDATA_CONTENT，所以即使其中有一些字符可以被解析为标签（无论合法还是不合法），也应该将它们视为常规字符。
 * 合法代码的例子:
 *
 * 输入: "<DIV>This is the first line <![CDATA[<div>]]></DIV>"
 *
 * 输出: True
 *
 * 解释:
 *
 * 代码被包含在了闭合的标签内： <DIV> 和 </DIV> 。
 *
 * TAG_NAME 是合法的，TAG_CONTENT 包含了一些字符和 cdata 。
 *
 * 即使 CDATA_CONTENT 含有不匹配的起始标签和不合法的 TAG_NAME，它应该被视为普通的文本，而不是标签。
 *
 * 所以 TAG_CONTENT 是合法的，因此代码是合法的。最终返回True。
 *
 *
 * 输入: "<DIV>>>  ![cdata[]] <![CDATA[<div>]>]]>]]>>]</DIV>"
 *
 * 输出: True
 *
 * 解释:
 *
 * 我们首先将代码分割为： start_tag|tag_content|end_tag 。
 *
 * start_tag -> "<DIV>"
 *
 * end_tag -> "</DIV>"
 *
 * tag_content 也可被分割为： text1|cdata|text2 。
 *
 * text1 -> ">>  ![cdata[]] "
 *
 * cdata -> "<![CDATA[<div>]>]]>" ，其中 CDATA_CONTENT 为 "<div>]>"
 *
 * text2 -> "]]>>]"
 *
 *
 * start_tag 不是 "<DIV>>>" 的原因参照规则 6 。
 * cdata 不是 "<![CDATA[<div>]>]]>]]>" 的原因参照规则 7 。
 * 不合法代码的例子:
 *
 * 输入: "<A>  <B> </A>   </B>"
 * 输出: False
 * 解释: 不合法。如果 "<A>" 是闭合的，那么 "<B>" 一定是不匹配的，反之亦然。
 *
 * 输入: "<DIV>  div tag is not closed  <DIV>"
 * 输出: False
 *
 * 输入: "<DIV>  unmatched <  </DIV>"
 * 输出: False
 *
 * 输入: "<DIV> closed tags with invalid tag name  <b>123</b> </DIV>"
 * 输出: False
 *
 * 输入: "<DIV> unmatched tags with invalid tag name  </1234567890> and <CDATA[[]]>  </DIV>"
 * 输出: False
 *
 * 输入: "<DIV>  unmatched start tag <B>  and unmatched end tag </C>  </DIV>"
 * 输出: False
 * 注意:
 *
 * 为简明起见，你可以假设输入的代码（包括提到的任意字符）只包含数字, 字母, '<','>','/','!','[',']'和' '。
 * 通过次数4,338提交次数9,682
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/tag-validator
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 */
public class Solution_20220502_591 {
    private static final Pattern PATTERN = Pattern.compile("^[\\da-zA-Z<>/!\\[\\] ]*$");

    private static final Pattern START_TAG_PATTERN = Pattern.compile("<[A-Z]+>");

    private static final Pattern END_TAG_PATTERN = Pattern.compile("</[A-Z]+>");


    public boolean isValid(String code) {
        if (!PATTERN.matcher(code).matches()) {
            return false;
        }
        Stack<String> stack = new Stack<>();
        char[] codeArray = code.toCharArray();
        for (int i = 0; i < codeArray.length; i++) {
            if (i <= codeArray.length - 9
                    && codeArray[i] == '<'
                    && codeArray[i + 1] == '!'
                    && codeArray[i + 2] == '['
                    && codeArray[i + 3] == 'C'
                    && codeArray[i + 4] == 'D'
                    && codeArray[i + 5] == 'A'
                    && codeArray[i + 6] == 'T'
                    && codeArray[i + 7] == 'A'
                    && codeArray[i + 8] == '[') {
                // CDATA标签内的所有字符都认为是文本, 不入栈
                int flag = 0;
                for (int k = i + 8; k <= codeArray.length - 1; k++) {
                    if (k <= codeArray.length - 3
                            && codeArray[k] == ']'
                            && codeArray[k + 1] == ']'
                            && codeArray[k + 2] == '>') {

                        i = k + 2;
                        flag = 1;
                        break;
                    }
                }
                if (flag == 0 || stack.isEmpty()) {
                    return false;
                }
            } else if (i <= codeArray.length - 2
                    && codeArray[i] == '<'
                    && codeArray[i + 1] >= 65
                    && codeArray[i + 1] <= 90) {

                // 识别起始标签
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append('<');
                stringBuilder.append(codeArray[i + 1]);
                boolean findStartTag = false;
                int k;
                for (k = i + 2; k <= codeArray.length - 1; k++) {
                    stringBuilder.append(codeArray[k]);
                    if (codeArray[k] == '>') {
                        if (START_TAG_PATTERN.matcher(stringBuilder.toString()).matches()) {
                            if (stringBuilder.toString().length() > 11) {
                                return false;
                            }
                            findStartTag = true;
                        }
                        break;
                    }
                }
                i = k;
                if (findStartTag) {
                    // 起始标签需要入栈
                    stack.add(stringBuilder.toString());
                } else {
                    // 如果没找到起始标签, 那么这段代码是纯文本, 纯文本必须包在标签内
                    if (stack.isEmpty()) {
                        return false;
                    }
                }
            } else if (i <= codeArray.length - 3
                    && codeArray[i] == '<'
                    && codeArray[i + 1] == '/'
                    && codeArray[i + 2] >= 65
                    && codeArray[i + 2] <= 90) {
                // 识别结尾标签
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append('<');
                stringBuilder.append('/');
                stringBuilder.append(codeArray[i + 2]);
                boolean findEndTag = false;
                int k;
                for (k = i + 3; k <= codeArray.length - 1; k++) {
                    stringBuilder.append(codeArray[k]);
                    if (codeArray[k] == '>') {
                        if (END_TAG_PATTERN.matcher(stringBuilder.toString()).matches()) {
                            if (stringBuilder.toString().length() > 12) {
                                return false;
                            }
                            findEndTag = true;
                        }
                        break;
                    }
                }
                i = k;
                if (findEndTag) {
                    boolean findPair = false;
                    // 找到结束标签, 那么成对出现的开始标签出栈
                    while (!stack.isEmpty()) {
                        String top = stack.pop();
                        if (START_TAG_PATTERN.matcher(top).matches()
                                && !stringBuilder.toString().replace("/", "").equals(top)) {
                            return false;
                        } else if (stringBuilder.toString().replace("/", "").equals(top)) {
                            findPair = true;
                            break;
                        }
                    }
                    if (!findPair || (stack.isEmpty() && i + 1 <= codeArray.length - 1)) {
                        // 未找到成对出现的标签
                        // 或者找到了, 但是后续还有代码, 此时可以断定缺少根标签
                        return false;
                    }
                } else {
                    // 如果没找到结束标签, 那么这段代码是纯文本, 纯文本必须包在标签内
                    if (stack.isEmpty()) {
                        return false;
                    }
                }
            } else {
                if (codeArray[i] == '<') {
                    return false;
                }
                stack.add(String.valueOf(codeArray[i]));
            }
        }
        return stack.isEmpty();

    }

    public static void main(String[] args) {
        System.out.println("-------------开始执行-------------");
        //Assert.isTrue(clumsy(43261596)==964176192,"程序异常");
        System.out.println("-------------运行通过-------------");

    }
}
