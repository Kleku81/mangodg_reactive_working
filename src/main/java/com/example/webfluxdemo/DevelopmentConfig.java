package com.example.webfluxdemo;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.example.webfluxdemo.model.Tweet;
import com.example.webfluxdemo.repository.TweetRepository;

@Configuration
public class DevelopmentConfig {

  @Bean
  public CommandLineRunner dataLoader(TweetRepository repo
        ) { // user repo for ease of testing with a built-in user
    
    return new CommandLineRunner() {
      @Override
      public void run(String... args) throws Exception {
    	  
    	  System.out.println("!!!!!! Loadin data !!!!!!");
    	  Tweet tweet1 = new Tweet("test1 tweet");  
    	  Tweet tweet2 = new Tweet("test2 tweet");  
    	  Tweet tweet3 = new Tweet("test3 tweet");  
        
//        UserUDT u = new UserUDT(username, fullname, phoneNumber)
        
         repo.save(tweet1).subscribe(); 
         repo.save(tweet2).subscribe(); 
         repo.save(tweet3).subscribe(); 
         
         /*"Craig Walls", "123 North Street", "Cross Roads", "TX", 
              "76227", "123-123-1234", "craig@habuma.com"))
          .subscribe(user -> {
              paymentMethodRepo.save(new PaymentMethod(user, "4111111111111111", "321", "10/25")).subscribe();
        */
      
    }
    };
  }
}