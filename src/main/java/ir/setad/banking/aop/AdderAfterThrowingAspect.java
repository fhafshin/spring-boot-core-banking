package ir.setad.banking.aop;

public class AdderAfterThrowingAspect {

    public void afterThrowing(final Exception exception) {

        System.out.println("error:" + exception);


    }
}
