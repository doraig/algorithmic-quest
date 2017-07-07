package com.pigopoyo.algoquest.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Gopiraj Dorairaj on 7/6/2017.
 */
public class Array2DJoin {

    /**
     * Methods to join the two sets of data (tupels) base on on common attribute or index value.
     * @param menus
     * @param preference
     * @return
     */
    public String[][] joinArrayData(String[][] menus, String[][] preference) {
        Stream<String[]> menuStream =  Arrays.stream(menus);

        //x -> {x.length()} == gopi(String x) { x.length() }
        Map<String, List<String>> menuMap = menuStream.collect(Collectors.toMap(x -> x[0],
                Array2DJoin::buildList, (oldVal, newVal) -> {newVal.addAll(oldVal); return newVal;} ));
        menuMap.put("*",menuMap.values().stream().flatMap(x -> x.stream()).collect(Collectors.toList()));
        List<String[]> returnList = new ArrayList<>();
        for (String[] rec : preference) {
            returnList.addAll(menuMap.get(rec[0].trim()).stream().map(x -> new String[]{rec[1],x}).collect(Collectors.toList()));
        }
        return returnList.stream().toArray(String[][]::new);
    }

    private static  List<String> buildList(String[] v) {
        List<String>  strings  = new ArrayList<>();
        strings.add(v[1]);
        return strings;
    }


}
