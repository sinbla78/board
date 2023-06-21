package com.example.mvm.service;

import com.example.mvm.dto.request.BoardRequest;
import com.example.mvm.dto.response.BoardResponse;
import com.example.mvm.entity.Board;
import com.example.mvm.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    public void addBoard(BoardRequest req) {
        boardRepository.save(new Board(0, req.getTitle(), req.getContents(), LocalDateTime.now()));
    }

    public BoardResponse getBoard(long id) {
        Board board = boardRepository.findById(id).orElseThrow();
        return new BoardResponse(
                board.getId(),
                board.getTitle(),
                board.getContents(),
                board.getCreatAt()
        );
    }

    public List<BoardResponse> getAllBoards() {
        List<Board> boards = boardRepository.findAll();
        return boards.stream()
                .map(board -> new BoardResponse(
                        board.getId(),
                        board.getTitle(),
                        board.getContents(),
                        board.getCreatAt()
                ))
                .toList();
    }
}