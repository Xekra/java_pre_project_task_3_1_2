package ru.kata.spring.boot_security.demo.dao;

import org.springframework.stereotype.Repository;
import ru.kata.spring.boot_security.demo.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO{

    @PersistenceContext
    private EntityManager em;


    @Override
    public void createUser(User user) {
        if(user.getId() == null) {
            em.persist(user);
        } else em.merge(user);
    }

    @Override
    public void updateUser(User user) {
        em.merge(user);
    }

    @Override
    public void deleteUser(Long id) {
        User user = em.find(User.class, id);
        em.remove(user);
    }

    @Override
    public User getUserById(Long id) {
        User user = em.find(User.class, id);
        em.detach(user);
        return user;
    }

    @Override
    public List<User> getAllUsers() {
        return em.createQuery("from User", User.class)
                .getResultList();
    }
}
