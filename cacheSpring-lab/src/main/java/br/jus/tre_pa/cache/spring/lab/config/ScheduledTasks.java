package br.jus.tre_pa.cache.spring.lab.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import br.jus.tre_pa.cache.spring.lab.service.FooService;

//@Component
//@EnableScheduling
public class ScheduledTasks {
	
/*	private final Logger log = LoggerFactory.getLogger(this.getClass());	
	private final long SEGUNDO = 10000;
	//private final long MINUTO = SEGUNDO * 60;
	
	@Autowired
	private FooService service;
	
	private Pageable pageable;
	
	*/
    /**
     * Executa de 1 em 1 minuto
     */
	/* @Scheduled(fixedDelay = SEGUNDO)
    public void reportCurrentTime() {
        log.info("=====================================================================");
        log.info("						Limpando Cache"                                );
        log.info("=====================================================================");
        service.clearCache();

		
        
    }*/

}
