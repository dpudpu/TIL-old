package examples.daoexam.service;

import examples.daoexam.dao.BoardDao;
import examples.daoexam.dto.Board;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BoardServiceImpl implements BoardService {
    private BoardDao boardDao;

    public BoardServiceImpl(BoardDao boardDao){
        this.boardDao = boardDao;
    }

    @Override
    @Transactional
    public Board addBoard(Board board) {
        // board정보를 저장. id값을 저장시 자동으로 생성된다.
        Long id = boardDao.addBoard(board);
        board.setId(id);
        return board;
    }

    @Override
    @Transactional
    public Board getBoard(Long id) {
        //readCount를 수정.
        boardDao.upateCount(id);
        // 1건 읽어오고
        Board board = boardDao.getBoard(id);
        return board;
    }

    @Override
    @Transactional(readOnly=true)
    public List<Board> getBoards(int start, int limit) {
        return boardDao.getBoards(start, limit);
    }
}



/*

CREATE table board (
    id bigint(20) unsigned NOT NULL AUTO_INCREMENT,
    title varchar(255) NOT NULL,
    name varchar(255) NOT NULL,
    content text,
    regdate datetime,
    read_count int,
    primary key(id)
);

/*
INSERT INTO board (title, name, content, regdate, read_count)
VALUES ('홍길동전', '홍길동', '홍길동', now(), 0);

INSERT INTO board (title, name, content, regdate, read_count)
VALUES ('배대준', '배대준', '배대준', now(), 0);

INSERT INTO board (title, name, content, regdate, read_count)
VALUES ('아이유', '아이유', '아이유', now(), 0);

INSERT INTO board (title, name, content, regdate, read_count)
VALUES ('1234', '몰라', '123', now(), 0);

INSERT INTO board (title, name, content, regdate, read_count)
VALUES ('빅토르', '빅토르', '홍길동', now(), 0);

INSERT INTO board (title, name, content, regdate, read_count)
VALUES ('자크', '자크', '자크', now(), 0);

INSERT INTO board (title, name, content, regdate, read_count)
VALUES ('1111', '11111', '11111', now(), 0);

INSERT INTO board (title, name, content, regdate, read_count)
VALUES ('22222', '2222', '2222', now(), 0);

INSERT INTO board (title, name, content, regdate, read_count)
VALUES ('3333', '3333', '3333', now(), 0);

INSERT INTO board (title, name, content, regdate, read_count)
VALUES ('4444', '44444', '4444', now(), 0);

INSERT INTO board (title, name, content, regdate, read_count)
VALUES ('5555', '5555', '5555', now(), 0);

INSERT INTO board (title, name, content, regdate, read_count)
VALUES ('6666', '6666', '7777', now(), 0);

INSERT INTO board (title, name, content, regdate, read_count)
VALUES ('8888', '888', '888', now(), 0);

 */

