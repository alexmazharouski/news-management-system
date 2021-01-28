package ru.clevertec.news.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.clevertec.news.entities.user.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
