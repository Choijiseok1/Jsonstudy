package testAjaxproject.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import model.User;

/**
 * Servlet implementation class TestServlet4
 */
@WebServlet("/test4.do")
public class TestServlet4 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestServlet4() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 컨트롤러에서 처리한 결과를 json 객체로 리턴한 경우
		// 자바의 객체를 자바스크립트 객체로 바꿔서 리턴함
		//자바스크립트 객체 == json(JavaScript Object Notify)
		// 자바 자체에서는 json 을 취급하는 클래스가 없음
		// 외부 라이브러리를 가져다 써야 함 : WEB-INF/lib 폴더 안에 복사함
		
		String no = request.getParameter("no");
		System.out.println("test4의 no : " + no);
		User user=new User("u1234","p1234","홍길동",25,"h1@naver.com","101-115-8871");
		JSONObject job=new JSONObject();
		job.put("userid",user.getUserId());
		job.put("username",URLEncoder.encode(user.getUserName(),"utf-8"));
		job.put("userpwd",user.getUserPwd());
		job.put("age", user.getAge());
		job.put("email", user.getEmail());
		job.put("phone", user.getPhone());
		// 클라이언트와의 출력스트림 생성해서, Json 개체 전송함
		// 단, json 객체는 문자열 형태로 전송해야함.
		System.out.println("json : "+ job.toJSONString());
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(job.toJSONString());
		out.flush();
		out.close();
	}

}











