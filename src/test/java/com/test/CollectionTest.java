package com.test;

import com.google.common.base.Splitter;
import com.google.common.collect.*;
import org.junit.Test;

import java.util.Collection;
import java.util.Set;

/**
 * Created by shliangyan on 2017/5/11.
 */
public class CollectionTest {

    @Test
    public void name() throws Exception {
        // method 1
        Set<String> colors = ImmutableSet.<String>builder()
                .add("red", "green", "black", "white", "grey")
                .build();
        // method 2
        Set<String> color2 = ImmutableSet.of("red", "green", "black", "white", "grey");
        // method 3
        Set<String> color3 = ImmutableSet.copyOf(new String[]{"red", "green", "black", "white", "grey"});
        for (String color : colors) {
            System.out.println(color);
        }
    }

    @Test
    public void test() {
        Multiset multiset = HashMultiset.create();
        String sentences = "this is a story, there is a good girl in the story.";
        Iterable<String> words = Splitter.onPattern("[^a-z]{1,}").omitEmptyStrings().trimResults().split(sentences);
        for (String word : words) {
            multiset.add(word);
        }
        for (Object element : multiset.elementSet()) {
            System.out.println(element + ":" + multiset.count(element));
        }
    }

    /**
     * 测试双向map
     */
    @Test
    public void testBiMap() {
        BiMap<String, String> weekNameMap = HashBiMap.create();
        weekNameMap.put("星期一","Monday");
        weekNameMap.put("星期二","Tuesday");
        weekNameMap.put("星期三","Wednesday");
        weekNameMap.put("星期四","Thursday");
        weekNameMap.put("星期五","Friday");
        weekNameMap.put("星期六","Saturday");
        weekNameMap.put("星期日","Sunday");

        System.out.println("星期日的英文名是" + weekNameMap.get("星期日"));
        System.out.println("Sunday的中文是" + weekNameMap.inverse().get("Sunday"));
    }

    @Test
    public void testMultiMap() {
        Multimap<String, String> multimap = ArrayListMultimap.create();
        // 添加键值对
        multimap.put("Fruits", "Banana");
        //给Fruits元素添加另一个元素
        multimap.put("Fruits", "Apple");
        multimap.put("Fruits", "Pear");
        multimap.put("Vegetables", "Carrot");

        //获得 multimap 的size
        int size = multimap.size();
        System.out.println(size);

        Collection<String> fruits = multimap.get("Fruits");
        System.out.println(fruits);

        Collection<String> ve = multimap.get("Ve");
        System.out.println(ve);

        // remove
        multimap.remove("Fruits", "Pear");
    }

    @Test
    public void testTable() {
        Table<Integer, Integer, String> table = HashBasedTable.create();
        for (int row = 0; row < 10; row++) {
            for (int column = 0; column < 5; column++) {
                table.put(row, column, "value of cell (" + row + "," + column + ")");
            }
        }

    }
}
