package br.jus.tre_pa.cache.spring.lab.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import br.jus.tre_pa.cache.spring.lab.domain.Foo;
import br.jus.tre_pa.cache.spring.lab.repository.FooRepository;
import java.util.List;

@Service
//@CacheConfig(cacheNames = "foo")
//@Cacheable("foo")
public class FooService {

	@Autowired
	private FooRepository fooRepository;


	
	/**
	 * Retorna uma lista de  Foo com paginação. 
	 *
	 * @param pageable 
	 * @return 
	 */
	@Cacheable(cacheNames="foo")
	public Page<Foo> findAll(Pageable pageable) {
		return fooRepository.findAll(pageable);
	}


	/**
	 * Retorna uma instância de  Foo pelo id. 
	 *
	 */
	public Foo findOne(Long id) {
		return fooRepository.findOne(id);
	}

	/**
	 * Verifica se a instância de Foo existe na base de dados.
	 *
	 * @param id Id de Foo.
	 * @return
	 */
	public boolean exists(Long id) {
		return fooRepository.exists(id);
	}

	/**
	 * Deleta uma instância de Foo.
	 * 
	 * @param id Id do objeto a ser deletado.
	 */
	@Transactional
	public void delete(Long id) {
		fooRepository.delete(id);
	}
	
	/**
	 * Insere uma instância de Foo na base de dados. 
	 *
	 * @param newFoo Objeto com os dados para inserção de Foo.
	 * @return Foo atualizado.
	 */
	@Transactional
	@CachePut(cacheNames="foo", key="#newFoo")
	public Foo insert(Foo newFoo) {
		Foo foo = new Foo();
		this.updateAttributes(foo, newFoo);
		return fooRepository.save(foo);
	}
	
	/**
	 * Atualiza a instância de Foo na base de dados. 
	 *
	 * @param newFoo Objeto com os dados para atualização de Foo.
	 * @return Foo atualizado.
	 */
	@Transactional
	public Foo update(Foo newFoo) {
		Foo foo = fooRepository.findOne(newFoo.getId());
		this.updateAttributes(foo, newFoo);
		return fooRepository.save(foo);
	}
	
	private void updateAttributes(Foo foo, Foo newFoo) {
		foo.setLocal(newFoo.getLocal());
		foo.setNome(newFoo.getNome());
		foo.setNumero(newFoo.getNumero());
	}
	@CacheEvict(cacheNames="foo", allEntries = true)
	public void clearCache(){
		
	}
	
}
