package br.jus.tre_pa.cache.spring.lab.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import br.jus.tre_pa.cache.spring.lab.repository.FooRepository;

@Component
public class AppRunner implements CommandLineRunner {

   private static final Logger logger = LoggerFactory.getLogger(AppRunner.class);

    private final FooRepository fooRepository;

    public AppRunner(FooRepository fooRepository) {
        this.fooRepository = fooRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        //logger.info(".... Fetching books");
       // logger.info("-->" + fooRepository.findAll());
    }

}