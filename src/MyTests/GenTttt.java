package MyTests;



public class GenTttt {
    public static void main(String[] args) {
        String regex = ".*407.*";
        String s = "00407-121-313";
        System.out.println(s.matches(regex));;
    }

}
