package ir.setad.banking;

import ir.setad.banking.aop.SampleAdder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:springAop-applicationContext.xml")
public class BankingApplication implements CommandLineRunner {
    @Autowired
    SampleAdder sampleAdder;


    public static void main(String[] args) {
        SpringApplication.run(BankingApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        sampleAdder.add(5,35);

    }
}
