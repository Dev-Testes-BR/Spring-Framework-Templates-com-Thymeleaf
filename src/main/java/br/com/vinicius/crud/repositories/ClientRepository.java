package br.com.vinicius.crud.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.vinicius.crud.models.Client;

public interface ClientRepository extends JpaRepository<Client, Long>{

}
