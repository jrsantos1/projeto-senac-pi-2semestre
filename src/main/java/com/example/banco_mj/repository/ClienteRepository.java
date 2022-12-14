package com.example.banco_mj.repository;

import com.example.banco_mj.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    @PersistenceContext
    public List<Cliente> findAll();
    @Query("select c from Cliente c join c.user u where u.cpf = :name ")
    Optional<Cliente> findByCpf(@Param("name") String name);
}
