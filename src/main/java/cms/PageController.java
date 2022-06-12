/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cms;

/**
 *
 * @author ngt
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class PageController {

    @Autowired
    PageRepository pageRepository;

//    @RequestMapping("/")
//    String home() {
//        return "Hello World!";
//    }    
    
    @GetMapping("/page")
    public List<Page> index() {
        return pageRepository.findAll();
    }

//    @GetMapping("/page/{id}")
//    public Page show(@PathVariable String id) {
//        int pageId = Integer.parseInt(id);
////        return pageRepository.findOne(example)
//        return pageRepository.findOne(pageId);
//    }

    @PostMapping("/page/search")
    public List<Page> search(@RequestBody Map<String, String> body) {
        String searchTerm = body.get("text");
        return pageRepository.findByTitleContainingOrContentContaining(searchTerm, searchTerm);
    }

    @PostMapping("/page")
    public Page create(@RequestBody Map<String, String> body) {
        String title = body.get("title");
        String content = body.get("content");
        return pageRepository.save(new Page(title, content));
    }

//    @PutMapping("/page/{id}")
//    public Page update(@PathVariable String id, @RequestBody Map<String, String> body) {
//        int pageId = Integer.parseInt(id);
//        // getting blog
//        Page page = pageRepository.findOne(pageId);
//        page.setTitle(body.get("title"));
//        page.setContent(body.get("content"));
//        return pageRepository.save(page);
//    }

//    @DeleteMapping("page/{id}")
//    public boolean delete(@PathVariable String id){
//        int pageId = Integer.parseInt(id);
//        pageRepository.delete(pageId);
////        pageRepository.delete(pageId);
//        return true;
//    }
    @DeleteMapping("page/{id}")
    public boolean delete(@PathVariable Page page) {
//        Page page = Integer.parseInt(id);
        pageRepository.delete(page);
//        pageRepository.delete(pageId);
        return true;
    }

}
