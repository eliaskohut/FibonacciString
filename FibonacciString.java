import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FibonacciString {
    public static void main(String[] args) {
        String[] str = {"l", "k"};
        System.out.println(generate(7, str));
    }

    private static String generate(int n, String[] str) {
        if(str.length != 2){
            return "invalid";
        }
        if(n<=1){
            return null;
        }
        Arrays.stream(str).forEach(x->{
            if(x.length()!=1){
                throw new IllegalArgumentException("Only letters");
            }
        });
        return fibonacci(n, str);
    }
    static String fibonacci(int n, String[] str){
        List<String> res =  new ArrayList<>();
        res.add(str[0]);
        res.add(str[1]);
        n-=2;
        while(n!=0){
            res.add(res.get(res.size() - 1)+ res.get(res.size() - 2));
            n--;
        }
        StringBuilder stringBuilder = new StringBuilder();
        res.forEach(s -> stringBuilder.append(s).append(", "));
        stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length()-1);
        return stringBuilder.toString();
    }
}
