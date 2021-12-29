package com.me.dynamic;

/**
 * 你和你的朋友，两个人一起玩 Nim 游戏：
 *
 * 桌子上有一堆石头。
 * 你们轮流进行自己的回合，你作为先手。
 * 每一回合，轮到的人拿掉 1 - 3 块石头。
 * 拿掉最后一块石头的人就是获胜者。
 * 假设你们每一步都是最优解。请编写一个函数，来判断你是否可以在给定石头数量为 n 的情况下赢得游戏。如果可以赢，返回 true；否则，返回 false 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/nim-game
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author qiankun
 * @version 2021/12/29
 */
public class NimGame {
    public static boolean canWinNim(int n) {

        if (n >= 1 && n <= 3) {
            return true;
        }
        boolean a = true;
        boolean b = true;
        boolean c = true;
        boolean d = false;
        for (int i = 4; i <= n; i++) {
            if (a && b && c) {
                d = false;
            } else {
                d = true;
            }
            a = b;
            b = c;
            c = d;
        }

        return d;
    }

    public static boolean canWinNimV2(int n) {
        return n % 4 != 0;
    }
    public static void main(String[] args) {
        for(int i = 1; i< 40;i++) {
            System.out.println(i+":" + canWinNim(i));
        }

    }
}
