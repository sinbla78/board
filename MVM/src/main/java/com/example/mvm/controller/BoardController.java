package com.example.mvm.controller;



import com.example.mvm.dto.request.BoardRequest;
import com.example.mvm.dto.response.BoardResponse;
import com.example.mvm.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/board")
public class BoardController {
    private BoardService boardService;

    public String addBoard(@RequestBody BoardRequest req) {
        boardService.addBoard(req);
        return "";
    }

    @GetMapping
    public BoardResponse getBoard(@RequestParam long id) {
        return boardService.getBoard(id);
    }

    @GetMapping("/all")
    public List<BoardResponse> getAllBoards() {
        return boardService.getAllBoards();
    }
}
