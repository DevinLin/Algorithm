package com.dev;

import java.io.InputStream;
import java.util.*;

import static java.util.Collections.*;

/**
 * Created by linlingyue on 2016/3/28.
 */
public class HWInterview {

    public static void main(String[] args) {

        String input = "A7 B3 A5 A2 A4 A3 A7 A3 A9";
        String[] split = input.split(" ");
        List<String> strings = Arrays.asList(split);
        sort(strings);

        Map<String, Integer> oMap = new HashMap<String, Integer>();
        Map<String, Integer> aMap = new HashMap<String, Integer>();

        List<String> tmpStrs = new ArrayList<String>();
        for(String str : strings){
            if(!tmpStrs.contains(str))
                tmpStrs.add(str);
        }

        for (int i = 0; i < tmpStrs.size(); i++) {
            String pk = tmpStrs.get(i);

            char[] strchar = pk.toCharArray();

            if (strchar[0] != 'A') {
                oMap.put(pk, Integer.valueOf(strchar[1] + ""));
            } else {
                if(aMap.containsKey(pk)){
                    tmpStrs.remove(pk);
                }
                else{
                    aMap.put(pk, Integer.valueOf(strchar[1] + ""));
                }
            }
        }

        List<Map.Entry<String, Integer>> l = null;
        if (aMap.size() == tmpStrs.size()) {
            l = new ArrayList<Map.Entry<String, Integer>>(aMap.entrySet());

        } else {
            l = new ArrayList<Map.Entry<String, Integer>>(oMap.entrySet());
        }

        sort(l, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o1.getKey().compareTo(o2.getKey());
            }
        });

        sort(l, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });
        System.out.println(l.get(l.size() - 1).getKey());
    }
}
