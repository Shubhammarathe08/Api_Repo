package Other_Package;

public class MethodChaining {

     public MethodChaining m1(){
        System.out.println(" m1 method ");
        return this;
    };

     public MethodChaining m2(int a, int b){
        System.out.println("a "+"b >>"+(a+b));
        return this;
    };

     public MethodChaining m3(String ip){
        System.out.println(ip.length()+" >> length of ip string");
        return this;
    };

}
