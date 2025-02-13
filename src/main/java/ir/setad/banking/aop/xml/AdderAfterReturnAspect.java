package ir.setad.banking.aop.xml;

public class AdderAfterReturnAspect {


    public void afterReturn(final Object afterReturnValue){
        System.out.println("after return "+afterReturnValue);
    }
}
