package examples.boot.springboard.controller;

import examples.boot.springboard.dto.Board;
import examples.boot.springboard.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Controller
public class BoardController {
    private BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping("/boards")
    public String boards(@RequestParam(value = "start",defaultValue = "1") int start,
                         @RequestParam(value = "end",defaultValue = "10") int end,
                         ModelMap modelMap){
        modelMap.addAttribute("boards",boardService.getBoards(start,end));
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

    @PostMapping("/boards")
    public String write(@ModelAttribute Board board,
                        @RequestParam("file") MultipartFile file){
        board.setRegdate(new Date());
        board.setReadCount(0);

        System.out.println("------file info start ----");
        System.out.println(file.getContentType());
        System.out.println(file.getOriginalFilename());
        System.out.println(file.getName());
        System.out.println(file.getSize());

        UUID uuid = UUID.randomUUID();
        String uuidStr = uuid.toString();
        System.out.println(uuidStr);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
        String dateStr = simpleDateFormat.format(new Date());

        String baseDir = "/tmp"; // 이미 있어야 한다.
        String saveDir = baseDir+"/"+dateStr;
        String saveFile = saveDir+"/"+uuidStr;

        File fileObj = new File(saveDir);
        fileObj.mkdirs();

        InputStream in = null;
        OutputStream out = null;
        try{
            in = file.getInputStream();
            out = new FileOutputStream(saveFile);
            byte[] buffer = new byte[1024];
            int readCount = 0;
            while((readCount = in.read(buffer)) != -1){
                out.write(buffer,0,readCount);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }finally {
            if(in != null){
                try{ in.close(); } catch(Exception e){}
            }
            if(out != null){
                try{ out.close(); } catch(Exception e){}
            }
        }
        System.out.println("------file info end ----");

        boardService.addBoard(board);

        return "redirect:/boards";
    }

    @GetMapping("/boards/download/{id}")
    @ResponseBody
    public void download(@PathVariable("id") Long id,
                         HttpServletResponse response) {
        // id에 해당하는 파일정보를 읽는다.
        String contentType = "image/jpeg";
        long size = 1457013L;
        String originalFileName = "profile.jpeg";
        String savePath = "/tmp/2018/10/31/20b28ca9-5b0e-4d77-980e-8a81e00fa4b2";
        response.setContentLength((int) size);
//        response.setContentType("application/x-msdownload");
        response.setContentType(contentType);
        try {
            originalFileName = URLDecoder.decode(originalFileName, "ISO8859_1");
        } catch (UnsupportedEncodingException e) {

        }
//        response.setHeader("Content-disposition","attachment; filename="+originalFileName);

        InputStream in = null;
        OutputStream out = null;

        try {
            in = new FileInputStream(savePath);
            out = response.getOutputStream();
            byte[] buffer = new byte[1024];
            int readCount = 0;
            while ((readCount = in.read(buffer)) != -1) {
                out.write(buffer, 0, readCount);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (Exception e) {
                }
            }
            if (out != null) {
                try {
                    out.close();
                } catch (Exception e) {
                }
            }
        }
    }
}
