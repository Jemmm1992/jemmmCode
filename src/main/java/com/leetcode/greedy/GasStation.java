package com.leetcode.greedy;

/**
 * Created by BIG-JIAN on 2017/7/4.
 * There are N gas stations along a circular route, where the amount of gas at station i isgas[i].
 * You have a car with an unlimited gas tank and it costscost[i]of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.
 * Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.
 * Note:
 * The solution is guaranteed to be unique.
 */

/**
 * 题意：环形路线上有N个加油站，每个加油站有汽油gas[i]，从每个加油站到下一站消耗汽油cost[i]，问从哪个加油站出发能够回到起始点，
 * 如果都不能则返回-1
 *
 * 思路：
 * 1.首先注意的是解是唯一的。
 * 2.对于站点 i，我们把 gas[i] - cost[i] 当作整体diff[i]考虑
 * 3.total记录所有的diff[i]之和，如果diff[i]之和小于0，则表示所有加油站的油量都不够。
 * 4.sum记录从站点0开始记录diff[i]（表示假设以站点0为起点可以跑完），一旦发现sum小于0，则表示油量不够，
 * 这时候需要从当前站点i开始重新开始累加（这样做的依据是解是唯一的，也就是i从0遍历到gas.length，一定存在且只存在一个站点，从这个站点出发sum一直大于0）。
 */
public class GasStation {
    public static void main(String[] args) {
        int[] gas = {0,0,11,12,13,11};
        int[] cost = {9,8,10,10,10,0};
        int i = canCompleteCircuit(gas, cost);
        System.out.println(i);
    }
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int sum = 0;
        int total = 0;
        int j = -1;
        for (int i = 0; i < gas.length; i++) {
            sum += gas[i] - cost[i];
            total += gas[i] - cost[i];
            if(sum < 0) {   //之前的油量不够到达当前加油站
                j = i;
                sum = 0;
            }
        }
        if (total < 0) return -1;    //所有加油站的油量都不够整个路程的消耗
        else return j + 1;
    }
}
