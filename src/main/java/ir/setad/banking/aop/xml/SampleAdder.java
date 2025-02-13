package ir.setad.banking.aop.xml;

public class SampleAdder {

    public int add(int a, int b) {

        if(a<0 || b<0)
            throw new IllegalArgumentException();
        System.out.println(new StringBuilder().append("run sun func :").append(a + b).toString());
        return a+b;
    }
}
