package com.example.helloworld.entity;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
public interface BoardRepository extends CrudRepository<Board, Long> {
    List<Board> findAllByOrderByIdDesc();
}
