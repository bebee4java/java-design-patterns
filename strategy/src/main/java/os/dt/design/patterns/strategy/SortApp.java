package os.dt.design.patterns.strategy;

import java.util.*;

/**
 * Created by songgr on 2020/05/27.
 */
public class SortApp {

    public static void main(String[] args) {

        Student[] arr = {new Student(1, 90, 100),
                new Student(2, 80, 89),
                new Student(3, 91, 90)
        };

//        Class[] arr = {new Class(1, 90, 100),
//                new Class(2, 80, 89),
//                new Class(3, 91, 90)
//        };


        new Sorters<Student>().sort(arr, StudentStrategyEnum.MATH.strategy());
        System.out.println(Arrays.toString(arr));

        Sorter sorter = new Sorter();
        sorter.sort_v1(arr);
        System.out.println(Arrays.toString(arr));




//        new Sorters<Class>().sort(arr, new Comparator<Class>() {
//            public int compare(Class o1, Class o2) {
//                if (o1.chinese > o2.chinese) return 1;
//                else if (o1.chinese < o2.chinese) return -1;
//                else return 0;
//            }
//        });
//
//        System.out.println(Arrays.toString(arr));


//        new Sorters<Class>().sort(arr, new Comparator<Class>() {
//            public int compare(Class o1, Class o2) {
//                if (o1.math > o2.math) return 1;
//                else if (o1.math < o2.math) return -1;
//                else return 0;
//            }
//        });
//
//        System.out.println(Arrays.toString(arr));


        List<Integer> list = new ArrayList<Integer>();
        list.add(3);list.add(1);list.add(2);
        Collections.sort(list, new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                if (o1 > o2) return 1;
                else if (o1 < o2) return -1;
                else return 0;
            }
        });
        System.out.println(list);
    }
}
