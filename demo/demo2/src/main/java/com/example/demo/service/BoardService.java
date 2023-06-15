package com.example.demo.service;

import com.example.demo.model.Board;
import com.example.demo.model.Result;


public interface BoardService {
    public Result createBoard(Board board);

    public Result retrieveBoardList();

    public Result retrieveBoard(int boardNo);

    public Result updateBoard(Board board);

    public Result deleteBoard(int boardNo);

}