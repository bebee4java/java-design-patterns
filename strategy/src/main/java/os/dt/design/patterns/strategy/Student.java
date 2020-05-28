package os.dt.design.patterns.strategy;

import java.util.Comparator;

/**
 * Created by songgr on 2020/05/27.
 */
public class Student implements Comparable<Student> {

    // 学号
    int sid;
    // 语文成绩
    int chinese;
    // 数学成绩
    int math;

    public Student(int sid, int chinese, int math) {
        this.sid = sid;
        this.chinese = chinese;
        this.math = math;
    }

    public int compareTo(Student o) {
        if (this.chinese > o.chinese) return 1;
        else if (this.chinese < o.chinese) return -1;
        else return 0;
    }

    @Override
    public String toString() {
        return "{sid:"+sid+",chinese:"+chinese+",math:"+math+"}";
    }
}

enum StudentStrategyEnum {
    CHINESE {
        @Override
        public Comparator strategy(){
          return new Comparator<Student>(){
              public int compare (Student o1, Student o2){
                  if (o1.chinese > o2.chinese) return 1;
                  else if (o1.chinese < o2.chinese) return -1;
                  else return 0;
              }
          };
      }
    },

    MATH {
        @Override
        public Comparator strategy(){
            return new Comparator<Student>(){
                public int compare (Student o1, Student o2){
                    if (o1.math > o2.math) return 1;
                    else if (o1.math < o2.math) return -1;
                    else return 0;
                }
            };
        }
    };

    public abstract Comparator strategy();
}

