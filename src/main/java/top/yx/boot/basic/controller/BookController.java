package top.yx.boot.basic.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import top.yx.boot.basic.controller.dto.AjaxResponse;
import top.yx.boot.basic.controller.dto.Param;
import top.yx.boot.basic.entity.Book;
import top.yx.boot.basic.entity.BookReader;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @author DELL
 * @date 2021/3/5
 * @description BookController
 */

@RestController
@RequestMapping(value = "api/v1/books")
@Slf4j
public class BookController {

    @GetMapping("all")
    public AjaxResponse selectBook(){
        BookReader[] readers = {
                BookReader.builder()
                        .name("aaa")
                        .age(20)
                        .build(),
                BookReader.builder()
                        .name("bbb")
                        .age(19)
                        .build(),
        };
        List<BookReader> readerList = Arrays.asList(readers);
        Book book1 = Book.builder()
                .id(123)
                .author("yx")
                .title("Spring")
                .content("SpringBoot从入门到精通")
                .createdTime(new Date())
                .readers(readerList)
                .build();

        Book book2 = Book.builder()
                .id(456)
                .author("yx")
                .title("Vue.js")
                .content("Vue.js从入门到精通")
                .createdTime(new Date())
                .readers(readerList)
                .build();

        Book[] books = {book1, book2};
        List<Book> bookList = Arrays.asList(books);

        return  AjaxResponse.success(bookList);
    }


    @GetMapping("{id}")
    public AjaxResponse getBook(@PathVariable int id){
        Book book = Book.builder()
                .id(id)
                .author("yx")
                .title("Java")
                .content("Java")
                .createdTime(new Date())
                .build();
        return AjaxResponse.success(book);
    }
    @PostMapping()
    public AjaxResponse saveBook(@RequestBody Book book) {
        log.info("saveBook:" + book);
        return  AjaxResponse.success(book);
    }

    @PutMapping()    //修改,通过问号传参
    public  AjaxResponse updateBook(@RequestParam int id,@RequestParam String title){
        Book book= Book.builder()
                .id(id)
                .author("ldd")
                .title("java")
                .content("java")
                .createdTime(new Date())
                .build();
        book.setTitle(title);
        log.info("book:"+book);
        return AjaxResponse.success(book);
    }
    //删除
    //1.根据id删除
    @DeleteMapping("{id}")
    public  AjaxResponse deleteBook(@PathVariable int id,String title){
        log.info("id:"+id);
        return AjaxResponse.success();
    }
    //2.根据？传参
    //2.1

//       @DeleteMapping()
//       public AjaxResponse deleteBook(int id,String title){
//          log.info("id:" + id);
//          log.info("title:"+title);
//          return AjaxResponse.success();
//    }
    //2.2

//        @DeleteMapping()
//        public AjaxResponse deleteBook(@RequestParam("id") int idd,@RequestParam("title") String ti){
//            log.info("id:" + idd);
//            log.info("title:"+ti);
//            return AjaxResponse.success();
//}
     //2.3

    //    @DeleteMapping()
//    public AjaxResponse deleteBook(@RequestParam(value = "id",defaultValue = "111")int idd,@RequestParam("title")String ti){
//        log.info("id:" + idd);
//        log.info("title:"+ti);
//        return AjaxResponse.success();
//    }

    //3.body请求体

//    @DeleteMapping()
//    public AjaxResponse deleteBook(@RequestBody Param param){
//        log.info("id:" + param.getId());
//        log.info("title:"+param.getTitle());
//        return AjaxResponse.success(param);
//    }


}