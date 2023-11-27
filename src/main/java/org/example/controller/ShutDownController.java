package org.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shutDown")
public class ShutDownController {

    @GetMapping("/action-slow")
    public void shutDownGracefully(){
        for (int i = 0; i < 66; i++) {
            try {
                System.out.println("hello"+i);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
