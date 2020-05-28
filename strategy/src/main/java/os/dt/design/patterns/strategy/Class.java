package os.dt.design.patterns.strategy;

/**
 * Created by songgr on 2020/05/27.
 */
public class Class implements Comparable<Class> {
    // 班级编号
    int cid;
    // 语文平均成绩
    int chinese;
    // 数学平成绩
    int math;

    public Class(int cid, int chinese, int math) {
        this.cid = cid;
        this.chinese = chinese;
        this.math = math;
    }

    public int compareTo(Class o) {
        if (this.chinese > o.chinese) return 1;
        else if (this.chinese < o.chinese) return -1;
        else return 0;
    }

    @Override
    public String toString() {
        return "{cid:"+cid+",chinese:"+chinese+",math:"+math+"}";
    }
}
