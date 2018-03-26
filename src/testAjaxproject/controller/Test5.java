package testAjaxproject.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
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
		
	list.add(new User("u1111", "p1111", "홍길동", 25, "h1111@iei.or,kr", "010-1111-1111"));
	list.add(new User("u2222", "p2222", "강감찬", 33, "k2222@iei.or,kr", "010-2222-2222"));
	list.add(new User("u3333", "p3333", "장영실", 45, "j3333@iei.or,kr", "010-3333-3333"));
	list.add(new User("u4444", "p4444", "이순신", 52, "lss44@iei.or,kr", "010-4444-4444"));
	list.add(new User("u5555", "p5555", "황진이", 22, "hwj55@iei.or,kr", "010-5555-5555"));

	//전송은 json 객체 한개만 전송할 수 있음
	//최종 전송용 json 객체 생성함
	JSONObject json = new JSONObject();
	
	//list 를 옮겨 담을 json 배열 객체가 필요함
	JSONArray jarr = new JSONArray();
	
	//list 에서 user 객체 한 개 꺼냄
	// => json 객체 한 개에 값들을 옮겨 담음
	// => json 객체를 json 배열에 저장함
	for(User user : list) {
		//한 사람의 정보를 저장할 json 객체 생성함
		JSONObject job = new JSONObject();
		
		job.put("userid", user.getUserId());
		job.put("userpwd", user.getUserPwd());
		//json에서 한글깨짐을 막으려면, 인코딩처리해서 저장해야 함
		//java.net.URLEncoder 클래스의 encode() 사용하면 됨
		job.put("username", URLEncoder.encode(
							user.getUserName(), "utf-8"));
		job.put("age", user.getAge());
		job.put("email", user.getEmail());
		job.put("phone", user.getPhone());
		
		//json 배열에 job 객체 저장함
		jarr.add(job);
	}
	
	//전송용 객체에 jarr 배열 담음
	json.put("list", jarr);
	System.out.println("json : " + json.toJSONString());
	
	response.setContentType("application/json; charset=utf-8");
	PrintWriter out = response.getWriter();
	out.print(json.toJSONString());
	out.flush();
	out.close();
}



	
	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
	}

}
