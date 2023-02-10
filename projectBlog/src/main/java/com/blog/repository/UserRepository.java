package com.blog.repository;

import com.blog.table.User;
import org.springframework.data.jpa.repository.JpaRepository;

// DAO
// 자동으로 bean 등록이 된다. -> @repository 생략가능
public interface UserRepository extends JpaRepository<User,Integer> {


}
