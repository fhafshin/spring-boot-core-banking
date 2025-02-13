package ir.setad.banking;

import ir.setad.banking.aop.xml.SampleAdder;
import ir.setad.banking.config.AppConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;

@SpringBootApplication
@ImportResource("classpath:springAop-applicationContext.xml")
public class BankingApplication implements CommandLineRunner {
    @Autowired
    SampleAdder sampleAdder;

    private final Environment env;

    public BankingApplication(Environment env) {
        this.env = env;
    }


    public static void main(String[] args) {
        SpringApplication.run(BankingApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Boolean b=env.acceptsProfiles(Profiles.of(AppConstants.SPRING_PROFILE_DEVELOPMENT));

        System.out.println(b);
          //  sampleAdder.add(5,35);

    }
}
