package ru.clevertec.news.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.clevertec.news.entities.user.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
}
