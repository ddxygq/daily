package com.keguang.daily.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author haisong
 * @create 2018/10/09 13:43
 */
public class ListUtil {
    public static <T> List<List<T>> splitList(List<T> list,int pageNum){
        List<List<T>> result = new ArrayList<List<T>>();
        int listSize = list.size();
        int pageSize = listSize/pageNum;
        for(int i=0;i<pageSize;i++){
            List list1 = list.subList(i*1,i*1+pageNum);
            result.add(list1);
        }
        return result;
    }

}
