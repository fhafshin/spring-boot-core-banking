package ir.setad.banking;

import ir.setad.banking.aop.xml.SampleAdder;
import ir.setad.banking.config.AppConstants;
import ir.setad.banking.domain.Account;
import ir.setad.banking.domain.User;
import ir.setad.banking.repository.AccountRepository;
import ir.setad.banking.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.math.BigDecimal;

@SpringBootApplication
@ImportResource("classpath:springAop-applicationContext.xml")
public class BankingApplication implements CommandLineRunner {
    private final SampleAdder sampleAdder;


    private final AccountRepository accountRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    private final Environment env;

    public BankingApplication(SampleAdder sampleAdder, AccountRepository accountRepository, PasswordEncoder passwordEncoder, UserRepository userRepository, Environment env) {
        this.sampleAdder = sampleAdder;
        this.accountRepository = accountRepository;
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.env = env;
    }


    public static void main(String[] args) {
        SpringApplication.run(BankingApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Boolean b = env.acceptsProfiles(Profiles.of(AppConstants.SPRING_PROFILE_DEVELOPMENT));

        System.out.println(b);
        //  sampleAdder.add(5,35);

        accountRepository.save(new Account(new BigDecimal(1000), "hesam"));
        accountRepository.save(new Account(new BigDecimal(5000), "ali"));

        User user = new User();
        user.setUsername("user1");
        user.setRole("USER");
        user.setPassword(passwordEncoder.encode("123456"));
        userRepository.save(user);

    }
}
