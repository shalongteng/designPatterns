package com.slt.designpatterns.strategy.mashibing;

/**
 * 排序类
 * 一步步演化过程
 */
public class Sorter<T> {
    /**
     * 给猫排序
     * 此版本：如果想给狗排序，需要重载一个
     */
    public void sort1(Cat[] arr) {
        //选择排序
        for(int i=0; i<arr.length - 1; i++) {
            int minPos = i;
            // 每轮需要比较的次数
            for(int j=i+1; j<arr.length; j++) {
                // 记录目前能找到的最小值元素的下标
                minPos = arr[j].compareTo(arr[minPos]) == -1? minPos:j;
            }
            // 将找到的最小值和i位置所在的值进行交换
            swap(arr, i, minPos);
        }
    }

    /**
     * 进一步 扩大范围
     * 缺点：仍然不够灵活。
     * @param arr
     */
    public void sort2(Comparable[] arr) {
        //选择排序
        for(int i=0; i<arr.length - 1; i++) {
            int minPos = i;
            // 每轮需要比较的次数
            for(int j=i+1; j<arr.length; j++) {
                // 记录目前能找到的最小值元素的下标
                minPos = arr[j].compareTo(arr[minPos]) == -1? minPos:j;
            }
            // 将找到的最小值和i位置所在的值进行交换
            swap(arr, i, minPos);
        }
    }

    /**
     * 最开始是int类型排序，如果是double类型怎么办？
     * 要写多个sort方法
     *
     * 这个可以给猫比较大小的策略，也可以灵活指定。
     */
    public void sort3(T[] arr, Comparator<T> comparator) {
        //选择排序
        for(int i=0; i<arr.length - 1; i++) {
            int minPos = i;

            for(int j=i+1; j<arr.length; j++) {
                minPos = comparator.compare(arr[j],arr[minPos])==-1 ? j : minPos;
            }
            swap(arr, i, minPos);
        }
    }

    //sort(int)
    void swap(T[] arr, int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    void swap(Cat[] arr, int i, int j) {
        Cat temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    void swap(Comparable[] arr, int i, int j) {
        Comparable temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
