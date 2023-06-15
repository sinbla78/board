package com.example.demo.service;

import com.example.demo.enumpkg.ServiceResult;
import com.example.demo.model.Board;
import com.example.demo.model.Result;
import com.example.demo.repositories.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.ErrorResponse;

import java.util.List;
import java.util.Optional;

@Service
public class BoardServiceImpl implements BoardService{

    private static final org.apache.logging.log4j.Logger logger = LogManager.getLogger(BoardServiceImpl.class);

    @Autowired
    BoardRepository repository;

    public Result updateBoard(Board board) {
        Optional<Board> search = repository.findById(board.getBoardNo());
        Result result = new Result();
        if(search.isPresent()) {
            board = repository.save(board);
            result.setPayload(board);
        }else {
            result.setError(new ErrorResponse(ServiceResult.NOTEXIST.toString()));
        }
        return result;
    }

    public Result deleteBoard(int boardNo) {
        Result result = new Result();
        boolean isPresent = repository.findById(boardNo).isPresent();
        if(!isPresent) {
            result.setError(new ErrorResponse(ServiceResult.NOTEXIST.toString()));
        }else {
            repository.deleteById(boardNo);
        }
        return result;
    }

    @Override
    public Result createBoard(Board board) {
        board = repository.save(board);
        Result result = new Result();
        result.setPayload(board);
        return result;
    }

    @Override
    public Result retrieveBoardList() {
        List<Board> list = repository.findAllByOrderByBoardNoDesc();
        Result result = new Result();
        result.setPayload(list);
        return result;
    }

    @Override
    public Result retrieveBoard(int boardNo) {
        Optional<Board> optionalBoard = repository.findById(boardNo);
        Result result = new Result();
        if(optionalBoard.isPresent()) {
            result.setPayload(optionalBoard.get());
        }else {
            result.setError(new ErrorResponse(ServiceResult.NOTEXIST.toString()));
        }
        return result;
    }

}