package hello.survlet.basic.response;

import com.fasterxml.jackson.databind.ObjectMapper;
import hello.survlet.basic.HelloData;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name ="responseJsonServlet", urlPatterns = "/response-json")
public class ResponseJsonServlet extends HttpServlet {
    private ObjectMapper objectMapper = new ObjectMapper();
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=utf-8");
        HelloData helloData = new HelloData();
        helloData.setAge(20);
        helloData.setUsername("junseok");

        String result = objectMapper.writeValueAsString(helloData);
        response.getWriter().write(result);
    }
}
