package com.example.usersbooking.repository;

import com.example.usersbooking.model.Operator;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface IAuthRepository extends MongoRepository<Operator, String> {
    Optional<Operator> findFirstByEmail(String email);

    //Optional<Operator> saveGeneratedToken(String generatedToken);
}
