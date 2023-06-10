package org.personal.helpers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import net.bytebuddy.implementation.bytecode.Throw;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.personal.UserData;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class JsonHelper {
    public Object object;
    public static UserData[] data;

    public JsonHelper() {
        String path = "src/main/resources/testData.json";
        JSONParser jsonParser = new JSONParser();
        try {
            FileReader reader = new FileReader(path);
            object =  jsonParser.parse(reader);
            String json = object.toString();
            ObjectMapper objectMapper = new ObjectMapper();
            data = objectMapper.readValue(json, UserData[].class);
        } catch (IOException | ParseException  e) {
            e.printStackTrace();
            throw new RuntimeException("testData.json not found at " + path);
        }

    }

    public UserData getUser(String userName) {
        for (UserData user: data) {
            if (user.getUserName().equals(userName)) {
                return user;
            }
        }
        throw new RuntimeException("Didn't find such" + userName + "in the testData.json file");
    }
}
