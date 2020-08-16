package com.examcom.udacity.jwdnd.c1.review.service;

import com.examcom.udacity.jwdnd.c1.review.model.ChatForm;
import com.examcom.udacity.jwdnd.c1.review.model.ChatMessage;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class MessageService {

    private List<ChatMessage> messageList;
    public MessageService(){

    }

    public void addMessage(ChatForm chatForm){
        ChatMessage newMessage = new ChatMessage();
        newMessage.setUsername(chatForm.getUsername());
        switch (chatForm.getMessageType()){
            case "Say":
                newMessage.setMessage(chatForm.getMessageText());
            case "Shout":
                newMessage.setMessage(chatForm.getMessageText().toUpperCase());
            case "Whisper":
                newMessage.setMessage((chatForm.getMessageText().toLowerCase()));
                break;
        }
        this.messageList.add(newMessage);
    }

    public List<ChatMessage> getChatMessages(){
        return messageList;
    }

    @PostConstruct
    public void postConstruct(){
        messageList = new ArrayList<>();
        System.out.println("Creating MassageService Bean");
    }
}
