package me.coding.company.google;

import java.util.*;

class MKAverage {
    class Data {
        int val;
        int timestamp;

        public Data(int val, int timestamp) {
            this.val = val;
            this.timestamp = timestamp;
        }
    }

    List<Data> timeStream;
    SortedSet<Data> dataStream;
    TreeSet<Data> left, mid, right;
    int m, k, time, total, leftTotal, midTotal, rightTotal;

    public MKAverage(int m, int k) {
        this.m = m;
        this.k = k;
        time = 0;
        total = 0;
        leftTotal = 0;
        midTotal = 0;
        rightTotal = 0;
        left = new TreeSet<>(
                Comparator.<Data>comparingInt(o -> o.val)
                        .thenComparingInt(o -> o.timestamp)
                        .reversed()
        );
        mid = new TreeSet<>(
                Comparator.<Data>comparingInt(o -> o.val)
                        .thenComparingInt(o -> o.timestamp)
                        .reversed()
        );
        right = new TreeSet<>(
                Comparator.<Data>comparingInt(o -> o.val)
                        .thenComparingInt(o -> o.timestamp)
                        .reversed()
        );
        timeStream = new ArrayList<>();
    }

    public void addElement(int num) {
        Data data = new Data(num, time);
        timeStream.add(data);
        if (timeStream.size() > m) {
            if (left.contains(timeStream.get(0))) {
                left.remove(timeStream.get(0));
                leftTotal -= timeStream.get(0).val;
            } else if (mid.contains(timeStream.get(0))) {
                mid.remove(timeStream.get(0));
                midTotal -= timeStream.get(0).val;
            } else if (right.contains(timeStream.get(0))) {
                right.remove(timeStream.get(0));
                rightTotal -= timeStream.get(0).val;
            }
            total -= timeStream.get(0).val;
            timeStream.remove(0);
        }
        if(left.size()<k){
            if(right.size()>0){
                Data r = right.pollLast();
                rightTotal-=r.val;
                mid.add(r);
                midTotal+=r.val;
            }
            if(mid.size()>0){
                Data m = mid.pollLast();
                midTotal-=m.val;
                left.add(m);
                leftTotal+=m.val;
            }
        }
        left.add(data);
        leftTotal += data.val;
        if (left.size() > k) {
            Data lData = left.pollFirst();
            leftTotal -= lData.val;
            mid.add(lData);
            midTotal += lData.val;
        }
        if (mid.size() > (m - k - k)) {
            Data mData = mid.pollFirst();
            midTotal -= mData.val;
            right.add(mData);
            rightTotal+=mData.val;
        }
        total += num;
        time++;
    }

    public int calculateMKAverage() {
        if (left.size() + mid.size() + right.size() < m) return -1;
        int tempTotal = this.total;
        tempTotal -= (leftTotal + rightTotal);
        return tempTotal / (m - k - k);
    }
}
