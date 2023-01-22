package ru.kata.pp_3_1_5_rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.kata.pp_3_1_5_rest.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT user FROM User user JOIN FETCH user.roles where user.name = (:name)")
    User findUserByName(@Param("name") String name);
}