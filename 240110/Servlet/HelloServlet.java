import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

import javax.servlet.*;
import javax.servlet.http.*;

import com.google.gson.Gson;

import javax.servlet.annotation.WebServlet;


@WebServlet("/HelloWorld")
public class HelloServlet extends HttpServlet{
    public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        response.setContentType("text/html; charset=utf-8");

        HashMap<String,Object> person = new HashMap<>();
        HashMap<String,HashMap<String,Object>> persons = new HashMap<>();
        
        person.put("name","이순신");
        person.put("address","여수시");
        person.put("age",20);
        persons.put((String)person.get("name"),person);

        person = new HashMap<>();
        person.put("name","이방원");
        person.put("address","한양시");
        person.put("age",30);
        persons.put((String)person.get("name"),person);

        person = new HashMap<>();
        person.put("name","이도");
        person.put("address","서울시");
        person.put("age",42);
        persons.put((String)person.get("name"),person);

        Gson gson = new Gson();
        String jsonString = gson.toJson(persons);
        // System.out.println(jsonString);
                
        PrintWriter out = response.getWriter();
        out.println(jsonString);
    }
}

