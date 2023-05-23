package com.example.helloworld.controller;

import com.example.helloworld.request.BoardCreateRequestDto;
import com.example.helloworld.request.BoardUpdateRequestDto;
import com.example.helloworld.response.BoardListResponseDto;
import com.example.helloworld.response.BoardResponseDto;
import com.example.helloworld.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class BoardController {
    private final BoardService boardService;

    //개별조회
    @GetMapping("/board/{id}")
    public BoardResponseDto searchById(@PathVariable Long id) {
        return boardService.searchById(id);
    }
    @GetMapping("/board")
    public List<BoardListResponseDto> searchAllDesc() {
        return boardService.searchAllDesc();
    }
    @PostMapping("/board")
    public Long create(@RequestBody BoardCreateRequestDto requestDto) {
        return boardService.create(requestDto);
    }
    @PutMapping("/board/{id}")
    public Long update(@PathVariable Long id, @RequestBody BoardUpdateRequestDto requestDto) {
        return boardService.update(id, requestDto);
    }
    @DeleteMapping("/board/{id}")
    public void delete(@PathVariable Long id){
        boardService.delete(id);
    }
}