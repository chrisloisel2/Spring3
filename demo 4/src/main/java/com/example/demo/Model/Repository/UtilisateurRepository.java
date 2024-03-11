package com.example.demo.Model;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.Model.Entity.Emprunt;
import com.example.demo.Model.Entity.Livre;

public interface UtilisateurRepository extends CrudRepository<Utilisateur, Long> {

}

public interface LivreRepository extends CrudRepository<Livre, Long> {

}

public interface EmpruntRepository extends CrudRepository<Emprunt, Long> {

}