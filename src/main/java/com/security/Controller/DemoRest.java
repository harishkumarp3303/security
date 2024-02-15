package com.security.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;




/**
 * DemoRest
 */

@RestController
@RequestMapping("security")
public class DemoRest {

   @GetMapping("demo")
   public String demoSecurity() {
       return new String("Message from security");
   }
   
    
    
}