package examples.daoexam.controller;

import examples.daoexam.dto.Board;
import examples.daoexam.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

@Controller
public class BoardController {
    private BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping("/boards")
    public String boards(@RequestParam("start") int start, @RequestParam("end") int end,
            ModelMap modelMap){
        modelMap.addAttribute("boards",boardService.getBoards(start,end
        ));
        return "list";
    }
    @GetMapping("/boards/writeform")
    public String writeform(){
        return "writeform";
    }
    @PostMapping("/write")
    public String write(@RequestParam(name = "name")String name,
                        @RequestParam(name = "title")String title,
                        @RequestParam(name = "content")String content){
        Board board = new Board();
        board.setName(name);
        board.setTitle(title);
        board.setContent(content);
        board.setRegdate(new Date());
        board.setReadCount(0);

        boardService.addBoard(board);

        return "redirect:/boards?start=1&end=10";

    }
}
