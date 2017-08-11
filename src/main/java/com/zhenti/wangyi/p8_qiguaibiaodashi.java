package com.zhenti.wangyi;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by BIG-JIAN on 2017/8/9.
 * 常规的表达式求值，我们都会根据计算的优先级来计算。比如*的优先级就高于+-。但是小易所生活的世界的表达式规则很简单，
 * 从左往右依次计算即可，而且小易所在的世界没有除法，意味着表达式中没有/，只有(+, - 和 *)。现在给出一个表达式，
 * 需要你帮忙计算出小易所在的世界这个表达式的值为多少
 * 输入描述:
 * 输入为一行字符串，即一个表达式。其中运算符只有-,+,*。参与计算的数字只有0~9.
 * 保证表达式都是合法的，排列规则如样例所示。
 * <p>
 * <p>
 * 输出描述:
 * 输出一个数，即表达式的值
 * <p>
 * 输入例子1:
 * 3+5*7
 * <p>
 * 输出例子1:
 * 56
 */
public class p8_qiguaibiaodashi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] c = sc.next().toCharArray();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < c.length; i++) {
            if (c[i] >= '0' && c[i] <= '9') {
                stack.add(c[i] - '0');
            } else {
                Integer pop = stack.pop();
                if (c[i] == '+') {
                    stack.push(pop + c[i + 1] - '0');
                } else if (c[i] == '-') {
                    stack.push(pop - c[i + 1] + '0');
                } else {
                    stack.push(pop * (c[i + 1] - '0'));
                }
                i++;
            }
        }
        System.out.println(stack.peek());
    }
}
