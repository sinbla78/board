package com.example.demo.controller;

import com.example.demo.model.Board;
import com.example.demo.repositories.BoardRepository;
import com.example.demo.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.xml.transform.Result;

@RestController
@RequestMapping(value = "restapi/board")
public class BoardRestController {

    @Autowired
    BoardRepository repository;

    @Autowired
    BoardService boardService;

    @GetMapping
    public Result retrieveBoardList() {
        Result result = (Result) boardService.retrieveBoardList();
        return result;
    }

    @GetMapping("/{boardNo}")
    public Result retrieveBoard(@PathVariable Integer boardNo) {
        Result result = (Result) boardService.retrieveBoard(boardNo);
        return result;
    }

    @PostMapping
    public Result createBoard(@ModelAttribute Board board) {
        Result result = (Result) boardService.createBoard(board);
        return result;
    }

    @PutMapping
    public Result updateBoard(@ModelAttribute Board board) {
        Result result = (Result) boardService.updateBoard(board);
        return result;
    }

    @DeleteMapping
    public Result deleteBoard(@RequestParam int boardNo) {
        Result result = (Result) boardService.deleteBoard(boardNo);
        return result;
    }

}