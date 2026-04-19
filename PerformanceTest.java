package second;

public class PerformanceTest {
    public static void main(String[] args) {

        // StringBuffer Test
        StringBuffer sbuffer = new StringBuffer();
        long start1 = System.currentTimeMillis();

        for (int i = 0; i < 10000; i++) {
            sbuffer.append("AIET");
        }

        long end1 = System.currentTimeMillis();
        System.out.println("Time taken by StringBuffer: " + (end1 - start1) + " ms");

        // StringBuilder Test
        StringBuilder sbuilder = new StringBuilder();
        long start2 = System.currentTimeMillis();

        for (int i = 0; i < 10000; i++) {
            sbuilder.append("AIET");
        }

        long end2 = System.currentTimeMillis();
        System.out.println("Time taken by StringBuilder: " + (end2 - start2) + " ms");
    }
}
