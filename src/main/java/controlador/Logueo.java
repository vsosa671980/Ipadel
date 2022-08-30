package controlador;

import jakarta.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import com.google.gson.Gson;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import modelo.Usuario;

/**
 * Servlet implementation class Logueo
 */
@WebServlet("/Logueo")
public class Logueo extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Logueo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
       System.out.println("Entro en el get");
		
		HttpSession misession= (HttpSession) request.getSession();
		
		if ((misession.getAttribute("usuario") == null || request.getSession(false) == null)) {
			PrintWriter pw= response.getWriter();

			System.out.println("Expulsado de la pagina");
			
			
		}else {
			
			System.out.println("Identificado");

			String JSON = ""; 
		
			Usuario u = (Usuario) misession.getAttribute("usuario");
			
			
			u.setNombre("Lonny");
			misession.setAttribute("usuario",u);

			

			Gson gson = new Gson();
			JSON = gson.toJson(u);

			PrintWriter respuesta= response.getWriter();
			respuesta.print(JSON);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pw= response.getWriter();
		
		String nombre = request.getParameter("nombre");
		String pass = request.getParameter("pass");
		
		Usuario u = new Usuario(nombre);
		
		try {
			if(u.logeando(pass)) {
				System.out.println("Logeado");
			
				HttpSession misession= request.getSession(true);
				misession.setAttribute("usuario",u);
				misession.setAttribute("usuario2",3);

				
				misession.setAttribute("permiso",u.getPermiso());
				
				
				response.sendRedirect("index.html");
				
			}else{
						
				System.out.println("NO logeado");
				
				pw.println("<html><body>El usuario no es correcto</body></html>");
				response.sendRedirect("login.html");
				pw.close();
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
