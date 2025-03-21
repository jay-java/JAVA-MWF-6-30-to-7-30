package controller;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import dao.ProductDao;
import model.Product;

@WebServlet("/Productcontroller")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 512, maxFileSize = 1024 * 1024 * 512, maxRequestSize = 1024 * 1024 * 512)
public class Productcontroller extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	
	private String extractfilename(Part file) {
	    String cd = file.getHeader("content-disposition");
	    System.out.println(cd);
	    String[] items = cd.split(";");
	    for (String string : items) {
	        if (string.trim().startsWith("filename")) {
	            return string.substring(string.indexOf("=") + 2, string.length()-1);
	        }
	    }
	    return "";
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if(action.equalsIgnoreCase("upload")) {
			String savePath = "C:\\Users\\user\\JAVA MWF 6-30 to 7-30\\Proejct\\src\\main\\webapp\\product image";   
			File fileSaveDir=new File(savePath);
	        if(!fileSaveDir.exists()){
	            fileSaveDir.mkdir();
	        }
	        Part file1 = request.getPart("image");
		 	String fileName=extractfilename(file1);
		    file1.write(savePath + File.separator + fileName);
		    String filePath= savePath + File.separator + fileName ;
		    
		    String savePath2 = "C:\\Users\\user\\JAVA MWF 6-30 to 7-30\\Proejct\\src\\main\\webapp\\product image";
	        File imgSaveDir=new File(savePath2);
	        if(!imgSaveDir.exists()){
	            imgSaveDir.mkdir();
	        }
	        
	        Product p = new Product();
	        p.setSid(Integer.parseInt(request.getParameter("sid")));
	        p.setPprice(Integer.parseInt(request.getParameter("pprice")));
	        p.setPqty(Integer.parseInt(request.getParameter("pqty")));
	        p.setImage(fileName);
	        p.setPname(request.getParameter("pname"));
	        p.setPcategory(request.getParameter("pcategory"));
	        p.setPdesc(request.getParameter("pdesc"));
	        ProductDao.uploadProduct(p);
	        response.sendRedirect("s-upload-product.jsp");
		}
		else if(action.equalsIgnoreCase("update")) {
			String savePath = "C:\\Users\\user\\JAVA MWF 6-30 to 7-30\\Proejct\\src\\main\\webapp\\product image";   
			File fileSaveDir=new File(savePath);
	        if(!fileSaveDir.exists()){
	            fileSaveDir.mkdir();
	        }
	        Part file1 = request.getPart("image");
		 	String fileName=extractfilename(file1);
		    file1.write(savePath + File.separator + fileName);
		    String filePath= savePath + File.separator + fileName ;
		    
		    String savePath2 = "C:\\Users\\user\\JAVA MWF 6-30 to 7-30\\Proejct\\src\\main\\webapp\\product image";
	        File imgSaveDir=new File(savePath2);
	        if(!imgSaveDir.exists()){
	            imgSaveDir.mkdir();
	        }
	        
	        Product p = new Product();
	        p.setPid(Integer.parseInt(request.getParameter("pid")));
	        p.setPprice(Integer.parseInt(request.getParameter("pprice")));
	        p.setPqty(Integer.parseInt(request.getParameter("pqty")));
	        p.setImage(fileName);
	        p.setPname(request.getParameter("pname"));
	        p.setPcategory(request.getParameter("pcategory"));
	        p.setPdesc(request.getParameter("pdesc"));
	        ProductDao.updateProduct(p);
	        response.sendRedirect("s-manage-product.jsp");
		}
		
	}

}
