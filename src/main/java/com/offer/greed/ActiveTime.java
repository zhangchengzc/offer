package com.offer.greed;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangcheng on 2018/7/31.
 */
public class ActiveTime implements Serializable{

    public static void main(String[] args) {
        //创建活动并添加到集合中
        Active act1 = new Active(1, 4);
        Active act2 = new Active(3, 5);
        Active act3 = new Active(0, 6);
        Active act4 = new Active(5, 7);
        Active act5 = new Active(3, 8);
        Active act6 = new Active(5, 9);
        Active act7 = new Active(6, 10);
        Active act8 = new Active(8, 11);
        Active act9 = new Active(8, 12);
        Active act10 = new Active(2, 13);
        Active act11 = new Active(12, 14);
        List<Active> actives = new ArrayList<>();
        actives.add(act1);
        actives.add(act2);
        actives.add(act3);
        actives.add(act4);
        actives.add(act5);
        actives.add(act6);
        actives.add(act7);
        actives.add(act8);
        actives.add(act9);
        actives.add(act10);
        actives.add(act11);

        List<Active> bestActives  = getBestActives(actives, 0, 16);
        for (int i = 0; i < bestActives.size(); i++) {
            System.out.println(bestActives.get(i));
        }
    }


    /**
     *
     * @param actives
     *            活动集合
     * @param startTime
     *            教室的开始使用时间
     * @param endTime
     *            教室的结束使用时间
     * @return
     */
    public static List<Active> getBestActives(List<Active> actives, int startTime, int endTime) {
        //最佳活动选择集合
        List<Active> bestActives = new ArrayList<>();
        //将活动按照最早结束时间排序
        actives.sort(null);
        //nowTime 用来记录上次活动结束时间
        int nowTime = startTime;
        /**
         * 因为我们已经按照最早结束时间排序，那么只要活动在时间范围内
         * actives.get(1)就应当是第一个活动的结束时间.
         * 则我们记录第一次活动结束的时间，在结合剩下的活动中，
         * 选取开始时间大于nowTime且结束时间又在范围内的活动，则为第二次活动时间，
         * 知道选出所有活动
         */
        for (int i = 0; i < actives.size(); i++) {
            Active act = actives.get(i);
            if(act.getStartTime()>=nowTime&&act.getEndTime()<=endTime){
                bestActives.add(act);
                nowTime = act.getEndTime();
            }
        }
        return bestActives;
    }
}

/**
 * 活动类
 * @CreatTime 下午9:45:37
 *
 */
class Active implements Comparable<Active>{
    private int startTime;//活动开始时间
    private int endTime;//活动结束时间

    public Active(int startTime, int endTime) {
        super();
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "Active [startTime=" + startTime + ", endTime=" + endTime + "]";
    }

    //活动排序时按照结束时间升序
    @Override
    public int compareTo(Active o) {
        if(this.endTime>o.getEndTime()){
            return 1;
        }else if(this.endTime == o.endTime){
            return 0;
        }else{
            return -1;
        }
    }


}
