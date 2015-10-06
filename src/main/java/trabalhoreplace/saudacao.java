package trabalhoreplace;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/saudacao")
public class saudacao extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		String Nome = req.getParameter("nome");
		String Saldacao;
		Calendar DTAtual = Calendar.getInstance();
		int horas = DTAtual.get(Calendar.HOUR_OF_DAY);
		if(horas > 5 && horas < 12){
			Saldacao = "Bom dia";
		}else if(horas <= 18){
			Saldacao = "Boa tarde";
		}else{
			Saldacao = "Boa noite";
		}
		resp.getWriter().write(getOriginal(Saldacao, Nome));
	}
	
	public String getOriginal(String Saldacao, String Nome){
		String Original = "<HTML><BODY><H2> {{SALDAÇÃO}} </H2><B><H2> {{NOME}} </H2></B></BODY></HTML";
		Original = Original.replace("{{SALDAÇÃO}}", Saldacao);
		Original = Original.replace("{{NOME}}", Nome);
		return Original;
	}

}
