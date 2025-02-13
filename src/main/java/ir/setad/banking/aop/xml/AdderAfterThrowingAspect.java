package ir.setad.banking.aop.xml;

public class AdderAfterThrowingAspect {

    public void afterThrowing(final Exception exception) {

        System.out.println("error:" + exception);


    }
}
