import java.util.Stack;

class Converter extends Thread {
    private String postFix;
    private String inFix;

    public Converter(String postFix) {
        this.postFix = postFix;
    }

    @Override
    public void run() {
        Stack<String> st = new Stack<>();
        for (int i = 0; i < postFix.length(); i++) {
            char c = postFix.charAt(i);
            if (Character.isLetterOrDigit(c))
                st.push(String.valueOf(c));
            else {
                String o1 = st.pop();
                String o2 = st.pop();
                String combined = o2 + c + o1;
                st.push(combined);
            }
        }
        inFix = st.pop();
    }

    public String getInFix() {
        return inFix;
    }
}

public class PolishToNormal {
    public static void main(String[] args) {
        Converter converter = new Converter("AB*CD/+");
        converter.start();
        try {
            converter.join();
        } catch (InterruptedException ex) {
            System.out.println("Thread interrupted: " + ex.getMessage());
        }
        String s = converter.getInFix();
        System.out.println(s);
    }
}
