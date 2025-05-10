public class AnonymousPractise {
    public static void main(String[] args) {
        AbstractPractise anonymous = new AbstractPractise() {
            @Override
            public int addition(int a, int b) {
                return a + b;
            }
        };
           System.out.println(anonymous.addition(2,3));

        }




}
