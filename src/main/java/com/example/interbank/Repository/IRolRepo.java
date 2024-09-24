package com.example.interbank.Repository;


import com.example.interbank.model.Rol;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface IRolRepo extends ReactiveMongoRepository<Rol, String>{

}
