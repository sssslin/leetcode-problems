package com.tags.algorithm.sort;

public class HeapSort {
    int [] pq;      // 完全二叉树，存放数值
    int N = 0;      // 数值存储在pq[1...N]中,pq[0]没有使用

    public HeapSort(int maxN) {
        pq = new int[maxN + 1];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int getSize() {
        return N;
    }

    private void exchage(int i, int j) {
        int tmp = pq[i];
        pq[j] = pq[i];
        pq[i] = tmp;
    }

    public void add(int v) {
        pq[++N] = v;
        swim(N);
    }

    private void swim(int k) {
        // k <= 1没必要swim
        while (k > 1 && pq[k / 2] < pq[k]) {
            exchage(k / 2, k);
            k = k / 2;
        }
    }

    public int remove() {
        int head = pq[1];       // heap头是最大元素
        exchage(1, N--);     // 和最后一个节点位置交换
        pq[N + 1] = 0;          // 恢复默认值,之前N--了
        sink(1);             // 维护堆有序性
        return head;
    }

    private void sink(int k) {
        // 有左儿子
        while (2 * k <= N) {
            int t = 2 * k;
            if (t < N && pq[t] < pq[t + 1]) {
                // 说明右儿子2 * K + 1更大
                t++;
            }
            if (pq[k] >= pq[t]) {
                break;
            }
            exchage(k, t);
            k = t;
        }
    }
}
