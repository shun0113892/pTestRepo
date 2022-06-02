package sample.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class Test1
 */
@WebServlet("/Test1")
public class Test1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Test1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//文字化け対策
		request.setCharacterEncoding("UTF-8");
	    response.setContentType("text/html; charset=UTF-8");
	    //DAOをインスタンス化
		ReviewDAO reviewDAO = new ReviewDAO();
		//DAOのfindAllメソッドの返されたリストをListのsdに入れてる。
    	List<ReviewDTO> sd = reviewDAO.findAll();
    	//アトリビュート
    	request.setAttribute("sd", sd);
    	//forward
    	RequestDispatcher dispatch = request.getRequestDispatcher("/WEB-INF/test1.jsp");
        dispatch.forward(request, response);
    	
    	//サーブレット単体でも出力できるように
        //PrintWriter out = response.getWriter();
        //out.println("test");
        
        /*
        for (ReviewDTO s: sd) {
            out.println("id : "+s.getId());
            out.println("name : "+s.getName());
            out.println("age : "+s.getAge());
            out.println("<br>");
        }
        boolean so = reviewDAO.Exist(3);
        if(so)
        	out.println("ok");
        */
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	

}
