package homework9;

public class StringvsStringBuilder {
    public static void main(String[] args) {
        final long COUNT = 712_000;

        long startTime = System.currentTimeMillis();
        String str = "";
        for (int i = 0; i < COUNT; i++) {
            str += "x";
        }
        System.out.println("String: " + (System.currentTimeMillis() - startTime));

        startTime = System.currentTimeMillis();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < COUNT; i++) {
            builder.append("x");
        }
        System.out.println("StringBuilder: " + (System.currentTimeMillis() - startTime));
    }
}
