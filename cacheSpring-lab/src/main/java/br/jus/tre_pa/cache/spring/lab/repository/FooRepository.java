package br.jus.tre_pa.cache.spring.lab.repository;

import java.util.List;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.jus.tre_pa.cache.spring.lab.domain.Foo;

@Repository
public interface FooRepository extends JpaRepository<Foo, Long> {
	
}