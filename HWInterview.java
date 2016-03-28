package com.dev;

import java.io.InputStream;
import java.util.*;

import static java.util.Collections.*;

/**
 * Created by linlingyue on 2016/3/28.
 */
public class HWInterview {

    public static void main(String[] args){

        String input ="C8 D3 B4 B2 C5 C6 A9 C9 A4 A5 A6 B1 C1";
        String[] split = input.split(" ");
        List<String> strings = Arrays.asList(split);
        sort(strings);

        Map<String,Integer> oMap = new HashMap<String, Integer>();

        for(int i = 0 , length = strings.size() ; i<length ; i++){
            String pk = strings.get(i);

            char[] strchar = pk.toCharArray();

            if(strchar[0] != 'A'){
                oMap.put(pk,Integer.valueOf(strchar[1]+""));
            }
        }

        List<Map.Entry<String,Integer>> l = new ArrayList<Map.Entry<String, Integer>>(oMap.entrySet());
        Collections.sort(l, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });

        System.out.println(l.get(l.size() -1).getKey());
    }
}
