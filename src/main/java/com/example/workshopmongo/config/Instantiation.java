package com.example.workshopmongo.config;

import com.example.workshopmongo.domain.Post;
import com.example.workshopmongo.domain.User;
import com.example.workshopmongo.repository.PostRepository;
import com.example.workshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.Arrays;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userReposiroty;

    @Autowired
    private PostRepository postReposiroty;

    @Override
    public void run(String... args) throws Exception {

        SimpleDateFormat sft = new SimpleDateFormat("dd/MM/yyyy");
        sft.setTimeZone(java.util.TimeZone.getTimeZone("GMT"));

        userReposiroty.deleteAll();
        postReposiroty.deleteAll();

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");


        Post post1 = new Post(null, sft.parse("21/03/2018"), "Partiu viagem", "Vou viajar para São Paulo. Abraços!", maria);
        Post post2 = new Post(null, sft.parse("23/03/2018"), "Bom dia", "Acordei feliz hoje!", maria);

        userReposiroty.saveAll(Arrays.asList(maria, alex, bob));
        postReposiroty.saveAll(Arrays.asList(post1, post2));
    }

}
