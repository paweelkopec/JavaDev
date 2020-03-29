package com.pawelk.javadev.repositories;

import com.pawelk.javadev.models.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;

import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = NONE)
class UserRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserRepository repository;

    @Test
    public void whenFindAll() {
        //given
        User firstUser = new User();
        firstUser.setEmail("test@mail.com");
        firstUser.setFirstname("admin");
        firstUser.setLastname("Admin");
        firstUser.setPassword("admin");
        entityManager.persist(firstUser);
        entityManager.flush();

        User secondtUser = new User();
        secondtUser.setEmail("usersec@mail.com");
        secondtUser.setFirstname("admin");
        secondtUser.setLastname("Admin");
        secondtUser.setPassword("admin");
        entityManager.persist(secondtUser);
        entityManager.flush();

        //when
        List<User> users = repository.findAll();

        //then
        assertThat(users.size()).isEqualTo(6);
        assertThat(users.get(4)).isEqualTo(firstUser);
        assertThat(users.get(5)).isEqualTo(secondtUser);
    }

}