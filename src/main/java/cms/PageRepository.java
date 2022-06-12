/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cms;

/**
 *
 * @author ngt
 */

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PageRepository extends JpaRepository<Page, Integer> {

    // custom query to search to blog post by title or content
    List<Page> findByTitleContainingOrContentContaining(String text, String textAgain);
    
//    Page findOne(Integer Id);
//    
//    boolean delete(Integer Id);
//    
//    Page findByTitle(String title);
//    
//    List<Page> findByTitleContaining(String expr);
    
}