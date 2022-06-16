package control;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.CommandProcess;

//@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
//		list.do=service.ListAction 를 예로 들면 String --> list.do  Object --> service.ListAction
    private Map<String, Object> commandMap = new HashMap<String, Object>();

    public Controller() {
        super();
    }

	public void init(ServletConfig config) throws ServletException {
		//web.xml에서 propertyConfig에 해당하는 init-param 의 값을 읽어옴
		String 	        props = config.getInitParameter("config");
		
		///WEB-INF/command.properties
		System.out.println("props --> " + props);
		//명령어와 처리클래스의 매핑정보를 저장할 Properties객체 생성 (매우 중요 면접 단골 손님)
		//key=value 방식으로 키를 통해 value 값을 찾는다.
		Properties	    pr    = new Properties();
		FileInputStream f     = null;
		
		try {
//																		  /WEB-INF/command.properties
			String configFilePath = config.getServletContext().getRealPath(props);
			System.out.println("configFilePath --> " + configFilePath);
			f = new FileInputStream(configFilePath);
			//command.properties파일의 정보를 Properites파일에 저장
			System.out.println("f --> " + f);
			pr.load(f);
		} catch (IOException e) {
			throw new ServletException(e);
		}finally {
			if(f != null) try {f.close();} catch (IOException ex) {}
		}
		//Iterator객체는 Enumeration객체를 확장시킨 개념의 객체
		Iterator keyIter = pr.keySet().iterator();
		//객체를 하나씩 꺼내서 그 객체명으로 Properties객체에 정장된 객체에 접근
		while(keyIter.hasNext()) {//키가 존재하는 지 확인
			String command   = (String)keyIter.next(); // 키를 가져온다. ex) /list.do
			String className = pr.getProperty(command); // 키에 해당하는 value 값을 가져온다. ex)service.ListAction
			try {
//				ListAction la = new ListAction();
				Class  commandClass    = Class.forName(className);//해당 문자열을 클래스로 만든다.
				Object commandInstance = commandClass.newInstance();//해당클래스의 객체를 생성
				commandMap.put(command, commandInstance);//Map객체인 commandMap에 객체 저장
			} catch (Exception e) {
				throw new ServletException(e);
			}
		}
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestServletPro(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestServletPro(request, response);
	}
	
	//시용자의 요청을 분석해서 해당 작업을 처리

	protected void requestServletPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String 		   view	   = null;
		CommandProcess com 	   = null;
		String		   command = request.getRequestURI();
		HttpSession    session = request.getSession();
		System.out.println("1. command ==> " + command); // /ch16/list.do
//		System.out.println("(request.getContextPath() ==> " + request.getContextPath());
		command = command.substring(request.getContextPath().length());//프로젝트 Path값만 잘라낸다.
		System.out.println("2. command subString ==> " + command); // /ch16/com
		
		try {
			com  = (CommandProcess)commandMap.get(command);
			System.out.println("command ==> " + command); // /ch16/com
			System.out.println("com ==> " + com);         // /ch16/com
			view = com.requestPro(request, response, session); 
			System.out.println("view ==>" + view);        // /ch16/com
			
			
		} catch (Exception e) {
			throw new ServletException(e);
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request, response);
		
	}

}
