package com.example.pets.model.DAO;

import com.example.pets.model.Endereco;
import com.example.pets.model.Usuario;
import jakarta.persistence.EntityManager;

public class UsuarioDAO {
    private EntityManager entityManager;
    public UsuarioDAO (EntityManager entityManager){
        this.entityManager = entityManager;
    }

    public void salvar(Usuario u){
        entityManager.getTransaction().begin();

        entityManager.persist(u);

        entityManager.getTransaction().commit();
    }

}
