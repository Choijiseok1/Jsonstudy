package testAjaxproject.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import model.User;

/**
 * Servlet implementation class Test5
 */
@WebServlet("/test5.do")
public class Test5 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Test5() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	String no = request.getParameter("no");
	System.out.println("no="+no);
	
	ArrayList<User> list=new ArrayList<User>();
		
	list.add(new User("u1111","p1111","홍길동",25,"fhld@naver.com","14535735"));
	list.add(new User("u232","p45111","홍43동",225,"fhtrd@naver.com","769346784"));
	list.add(new User("u42","p111431","zxcv",245,"fheryhrtld@naver.com","9866423"));
	list.add(new User("u1431","p541111","홍trwu46",525,"rtyld@navyrtr.com","5780623"));
	list.add(new User("u15341","p113411","홍46uw동",225,"fhrty@narty,com","63443780-123"));
	
	//전송은 json 객체 한개만 전송할수있음.
JSONObject job=new JSONObject();

JSONArray jarr=new JSONArray();

//list 에서 user객체 한개를 꺼냄 
// => json 객체 한개에 값들을 옴겨 담음.
// => json 객체를 json배열에 저장함.

for(User user:list) {
	//한 사람의 정보를 저장할 json 객체 생성함.
	JSONObject job1=new JSONObject();
	
}








	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
	}

}
