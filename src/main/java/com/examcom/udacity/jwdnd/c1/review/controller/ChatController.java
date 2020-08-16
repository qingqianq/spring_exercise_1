package com.examcom.udacity.jwdnd.c1.review.controller;

import com.examcom.udacity.jwdnd.c1.review.model.ChatForm;
import com.examcom.udacity.jwdnd.c1.review.service.MessageService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/chat")
public class ChatController {

    private MessageService messageService;

    public ChatController(MessageService messageService) {
        this.messageService = messageService;
    }

//    @RequestMapping(value = "/chat", method = RequestMethod.GET)
    @GetMapping
    public String getChatPage(ChatForm chatForm, Model model){
        model.addAttribute("chatMessages", this.messageService.getChatMessages());
        return "chat";
    }
    @PostMapping
//    @RequestMapping(value = "/chat", method = RequestMethod.POST)
public String postChatMessage(ChatForm chatForm, Model model){
        this.messageService.addMessage(chatForm);
        chatForm.setMessageText("");
        model.addAttribute("chatMessages", this.messageService.getChatMessages());
        return "chat";
    }

    @ModelAttribute("allMessageTypes")
    public String[] allMessageTypes(){
        return new String[]{"Say", "Shout", "Whisper"};
    }

}
