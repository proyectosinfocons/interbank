package com.example.interbank.Repository;

import com.example.interbank.model.Usuario;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface IUsuarioRepo extends ReactiveMongoRepository<Usuario, String>{
		
	Mono<Usuario> findOneByUsuario(String usuario);	
}
