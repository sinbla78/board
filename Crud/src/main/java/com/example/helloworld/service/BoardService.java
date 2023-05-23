package com.example.helloworld.service;

import com.example.helloworld.entity.Board;
import com.example.helloworld.entity.BoardRepository;
import com.example.helloworld.request.BoardCreateRequestDto;
import com.example.helloworld.request.BoardUpdateRequestDto;
import com.example.helloworld.response.BoardListResponseDto;
import com.example.helloworld.response.BoardResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class BoardService {
    private final BoardRepository boardRepository;

    @Transactional
    public Long create(BoardCreateRequestDto requestDto) {
        return boardRepository.save(requestDto.toEntity()).getId();
    }
    public Long update(Long id, BoardUpdateRequestDto requestDto) {
        return null;
    }
    @Transactional
    public void delete(Long id){
        Board board = boardRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("해당 게시물이 존재하지 않습니다."));

        boardRepository.delete(board);
    }
    @Transactional(readOnly = true)
    public BoardResponseDto searchById(Long id) {
        Board board = boardRepository.findById(id).orElseThrow(()
                -> new IllegalArgumentException("해당 게시물이 존재하지 않습니다."));
        return BoardResponseDto.builder()
                .id(board.getId())
                .title(board.getTitle())
                .content(board.getContent())
                .build();
    }
    @Transactional(readOnly = true)
    public List<BoardListResponseDto> searchAllDesc() {
        return boardRepository.findAllByOrderByIdDesc().stream()
                .map(BoardListResponseDto::new)
                .collect(Collectors.toList());
    }
}

