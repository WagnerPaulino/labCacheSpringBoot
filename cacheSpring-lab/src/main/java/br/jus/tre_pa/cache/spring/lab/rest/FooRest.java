package br.jus.tre_pa.cache.spring.lab.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import br.jus.tre_pa.cache.spring.lab.domain.Foo;
import br.jus.tre_pa.cache.spring.lab.service.FooService;

@RestController
public class FooRest {

	private Logger log = LoggerFactory.getLogger(FooRest.class);

	@Autowired
	private FooService fooService;

	/**
	 * Endpoint para buscar todas as instâncias de Foo.
	 *
	 */
	@RequestMapping(method = RequestMethod.GET, path = "/api/foos")
	public ResponseEntity<?> findAll(Pageable pageable) {
		log.debug("[findAll] Requisição para buscar todos foos");
		Page<Foo> foos = fooService.findAll(pageable);
		return ResponseEntity.ok(foos);
	}


	/**
	 * Endpoint para buscar 1 (uma) instância de Foo.
	 *
	 */
	@RequestMapping(method = RequestMethod.GET, path = "/api/foos/{id}")
	public ResponseEntity<?> find(@PathVariable("id") Long id) {
		log.debug("[find] Requisição para buscar foo. id={}", id);
		boolean exists = fooService.exists(id);
		if (exists) {
			log.debug("[find] foo encontrado.");
			return ResponseEntity.ok(fooService.findOne(id));
		}
		log.debug("[find] foo NÃO encontrado.");
		return ResponseEntity.notFound().build();
	}

	/**
	 * Endpoint para deleção de Foo.
	 *
	 */
	@RequestMapping(method = RequestMethod.DELETE, path = "/api/foos/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		log.debug("[delete] Requisição para deletar foo. id={}", id);
		boolean exists = fooService.exists(id);
		if (exists) {
			log.debug("[delete] foo encontrado.");
			fooService.delete(id);
			log.debug("[delete] foo deletado com sucesso.");
			return ResponseEntity.ok().build();
		}
		log.debug("[delete] foo NÃO encontrado.");
		return ResponseEntity.notFound().build();
	}

	/**
	 * Endpoint para inserção de Foo.
	 *
	 */
	@RequestMapping(method = RequestMethod.POST, path = "/api/foos")
	public ResponseEntity<?> insert(@RequestBody Foo foo) {
		log.debug("[insert] Requisição para inserir foo...");
		Foo insertedFoo = fooService.insert(foo);
		log.debug("[insert] Foo inserido com sucesso. id={}", insertedFoo.getId());
		return ResponseEntity.ok(insertedFoo);
	}

	/**
	 * Endpoint para atualização de Foo.
	 *
	 */
	@RequestMapping(method = RequestMethod.PUT, path = "/api/foos/{id}")
	public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody Foo foo) {
		log.debug("[update] Requisição para atualizar de foo...");
		boolean exists = fooService.exists(id);
		if (exists) {
			log.debug("[update] foo encontrado.");
			Foo updatedFoo = fooService.update(foo);
			log.debug("[update] foo atualizado com sucesso.");
			return ResponseEntity.ok(updatedFoo);
		}
		log.debug("[update] foo NÃO encontrado.");
		return ResponseEntity.notFound().build();
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/api/foos/clearCache")
	public ResponseEntity<?> clearCache(){
		fooService.clearCache();
		log.debug("==============> Cache limpo!!!");
		return ResponseEntity.ok(null);
	}

}
