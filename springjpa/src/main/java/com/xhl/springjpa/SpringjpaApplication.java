package com.xhl.springjpa;

import com.xhl.springjpa.dao.UserRepository;
import com.xhl.springjpa.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class SpringjpaApplication implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringjpaApplication.class, args);
    }
    @Override
    public void run(String... args) throws Exception {
        try {
            User user = new User();
            user.setName("张三");
            user.setAge(20);
            userRepository.save(user);
            List<User> u = userRepository.findByNameLike("%张三%");
            System.out.println(u.size());
            User  us =  userRepository.findByAge(20);
            System.out.println(us.getAge());
            us =  userRepository.findByName("这是你干");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
