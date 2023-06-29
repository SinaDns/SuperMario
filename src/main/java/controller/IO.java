package controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import model.User;

import java.io.File;
import java.io.IOException;

public class IO {

    private static final IO instance = new IO();
    ObjectMapper objectMapper;

    private IO() {
        objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
    }

    public static IO getInstance() {
        return instance;
    }

    public void save() {


        try {
            objectMapper.writeValue(new File("users.json"), User.users);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


    public void load() {


    }


}
