package com.example.wc.controller;

import com.example.wc.entity.Greeting;
import com.example.wc.entity.HelloMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.HtmlUtils;

import java.security.Principal;

@Controller
public class GreetingController {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting greeting(HelloMessage message) throws Exception {
        Thread.sleep(1000); // simulated delay
        return new Greeting("Hello, " + HtmlUtils.htmlEscape(message.getName()) + "!");
    }

    @MessageMapping("/chat")
    //在springmvc 中可以直接获得principal,principal 中包含当前用户的信息
    public void handleChat(Principal principal, HelloMessage message) {

        /**
         * 此处是一段硬编码。如果发送人是wyf 则发送给 wisely 如果发送人是wisely 就发送给 wyf。
         * 通过当前用户,然后查找消息,如果查找到未读消息,则发送给当前用户。
         */
        if (principal.getName().equals("a")) {
            //通过convertAndSendToUser 向用户发送信息,
            // 第一个参数是接收消息的用户,第二个参数是浏览器订阅的地址,第三个参数是消息本身

            messagingTemplate.convertAndSendToUser("b",
                    "/queue/notifications", principal.getName() + "-send:"
                            + message.getName());
            /**
             * 72 行操作相等于
             * messagingTemplate.convertAndSend("/user/abel/queue/notifications",principal.getName() + "-send:"
             + message.getName());
             */
        } else {
            messagingTemplate.convertAndSendToUser("a",
                    "/queue/notifications", principal.getName() + "-send:"
                            + message.getName());
        }
    }

    @RequestMapping(value = "/chat")
    public String chat(){
        return  "chat";
    }

    @RequestMapping(value = "/wx")
    public String wx(){
        return  "wx";
    }

    @RequestMapping(value = "/login")
    public String login(){
        return  "login";
    }
}
