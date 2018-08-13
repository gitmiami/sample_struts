package pk;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/**
 * Servlet implementation class boo3Bean
 */
public class boo3Bean extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public boo3Bean() {
        super();

    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}



	public String getAllEmp(){

		StringBuffer respBuf = new StringBuffer("");
		String resp ;
		String CATALINA_HOME= "c";
		String filePath="a.xml";

		try{

			DocumentBuilderFactory dbdactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = dbdactory.newDocumentBuilder();
			Document doc = builder.parse(new File(CATALINA_HOME + filePath));

			Element root = doc.getDocumentElement();


			NodeList emps= root.getElementsByTagName("employee");

			for(int i=0; i<emps.getLength();i++){

				Element elm =(Element)emps.item(i);
				String emp_no = elm.getAttribute("id");

				NodeList emp_name_list = elm.getElementsByTagName("emp_name");
				Element emp_name_tag = (Element)emp_name_list.item(0);
				String emp_name = emp_name_tag.getFirstChild().getNodeValue();

				NodeList emp_dept_list = elm.getElementsByTagName("emp_dept");
				Element emp_dept_tag = (Element)emp_dept_list.item(0);
				String emp_dept = emp_dept_tag.getFirstChild().getNodeValue();

				respBuf.append(emp_no + "<i>" + emp_name + "<i>" + emp_dept);

			}



		}catch(Exception e){

			e.printStackTrace();

		};

		respBuf.setLength(respBuf.length()-3);
		resp = respBuf.toString();
		return resp;


	}

}
