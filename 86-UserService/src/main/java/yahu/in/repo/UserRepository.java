package yahu.in.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import yahu.in.entity.User;

public interface UserRepository extends JpaRepository<User, String> {

}
