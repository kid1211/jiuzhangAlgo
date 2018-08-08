public class ReferenceTest {

    public void test() {
        
        int[] a = {1, 2, 3};
        int[] b = fix(a);
        System.out.print(a[1] + " " + b[1]);

        Integer[] c = {1, 2, 3};
        Integer[] d = fix(c);
        System.out.print(c[1] + " " + d[1]);
    }

    private Integer[] fix(Integer[] c) {
        c[1] = 4;
        return c;
    }

    private int[] fix(int[] a) {
        a[1] = 4;
        return a;
    }
}
