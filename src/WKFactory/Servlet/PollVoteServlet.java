package WKFactory.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import WKFactory.Entity.AttendCourseEntity;
import WKFactory.Entity.PollVoteEntity;
import WKFactory.Factory.BllFacadeFactory;
import WKFactory.Interface.BllInterface;
import net.sf.json.JSONObject;

@SuppressWarnings("serial")
public class PollVoteServlet extends HttpServlet {
	private BllFacadeFactory bllFacadeFactory = BllFacadeFactory.getbBllFactoryInstance() ;
	private BllInterface bllInterface = bllFacadeFactory.getInterface() ;
	/**
	 * Constructor of the object.
	 */
	public PollVoteServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	@Override
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String userNum = request.getParameter("UserNum") ;
		String courseNum = request.getParameter("CourseNum") ;
		String pollString = request.getParameter("Poll") ;
		Double poll = Double.parseDouble( pollString ) ;
		AttendCourseEntity a = new AttendCourseEntity( userNum, courseNum ) ;
		JSONObject json = new JSONObject() ;
		PollVoteEntity pv = new PollVoteEntity() ;
		pv.setPoll( poll ) ;
		pv.setCourseNum(courseNum) ;
		pv.setStudentNum(userNum);
		// json.result 1-未订阅或已经投过票，result 2-投票失败
		if( bllInterface.IsAttend( a ) && !bllInterface.IsPollVote( pv ) ){
			pv.setVoteTime( new Timestamp( System.currentTimeMillis() ) ) ;
			if( bllInterface.AddPollVote( pv ) ) {
				json.put( "reuslt" , 0 ) ;
			}else {
				json.put( "result" , 2 ) ;
			}
			
		}else {
			json.put( "result" , 1 ) ;
		}
		out.print(json) ;
		out.flush();
		out.close();
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	@Override
	public void init() throws ServletException {
		// Put your code here
	}

}
