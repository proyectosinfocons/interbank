package com.example.interbank.serviceImpl;

import com.example.interbank.model.Usuario;
import com.example.interbank.security.User;
import com.example.interbank.model.Usuario;
import com.example.interbank.security.User;
import reactor.core.publisher.Mono;

public interface IUsuarioService extends ICRUD<Usuario, String>{

	Mono<Usuario> registrarHash(Usuario usuario);
	Mono<User> buscarPorUsuario(String usuario);

}
