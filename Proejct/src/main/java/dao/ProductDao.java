package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.DBConnection;
import model.Product;

public class ProductDao {
	public static void uploadProduct(Product p) {
		try {
			Connection conn = DBConnection.createConnection();
			String sql="insert into product(sid,pprice,pqty,image,pname,pcategory,pdesc) values(?,?,?,?,?,?,?)";
			PreparedStatement pst= conn.prepareStatement(sql);
			pst.setInt(1,p.getSid());
			pst.setInt(2, p.getPprice());
			pst.setInt(3, p.getPqty());
			pst.setString(4, p.getImage());
			pst.setString(5, p.getPname());
			pst.setString(6, p.getPcategory());
			pst.setString(7, p.getPdesc());
			pst.executeUpdate();
			System.out.println("product uploaded");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static List<Product> getProductsBySid(int sid){
		List<Product> list = new ArrayList<Product>();
		try {
			Connection conn = DBConnection.createConnection();
			String sql="select * from product where sid=?";
			PreparedStatement pst= conn.prepareStatement(sql);
			pst.setInt(1, sid);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				Product p = new Product();
				p.setPid(rs.getInt("pid"));
				p.setSid(rs.getInt("sid"));
				p.setPprice(rs.getInt("pprice"));
				p.setPqty(rs.getInt("pqty"));
				p.setImage(rs.getString("image"));
				p.setPname(rs.getString("pname"));
				p.setPcategory(rs.getString("pcategory"));
				p.setPdesc(rs.getString("pdesc"));
				list.add(p);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public static void deleteProductByPid(int pid) {
		try {
			Connection conn = DBConnection.createConnection();
			String sql="delete from product where pid=?";
			PreparedStatement pst= conn.prepareStatement(sql);
			pst.setInt(1, pid);
			pst.executeUpdate();
			System.out.println("product deleted");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static Product getProductByPid(int pid) {
		Product p = null;
		try {
			Connection conn = DBConnection.createConnection();
			String sql="select * from product where pid=?";
			PreparedStatement pst= conn.prepareStatement(sql);
			pst.setInt(1, pid);
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				p = new Product();
				p.setPid(rs.getInt("pid"));
				p.setSid(rs.getInt("sid"));
				p.setPprice(rs.getInt("pprice"));
				p.setPqty(rs.getInt("pqty"));
				p.setImage(rs.getString("image"));
				p.setPname(rs.getString("pname"));
				p.setPcategory(rs.getString("pcategory"));
				p.setPdesc(rs.getString("pdesc"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return p;
	}
	public static void updateProduct(Product p) {
		try {
			Connection conn = DBConnection.createConnection();
			String sql="update product set pprice=?,pqty=?,image=?,pname=?,pcategory=?,pdesc=? where pid=?";
			PreparedStatement pst= conn.prepareStatement(sql);
			pst.setInt(1, p.getPprice());
			pst.setInt(2, p.getPqty());
			pst.setString(3, p.getImage());
			pst.setString(4, p.getPname());
			pst.setString(5, p.getPcategory());
			pst.setString(6, p.getPdesc());
			pst.setInt(7, p.getPid());
			pst.executeUpdate();
			System.out.println("product updated");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static List<Product> getAllProducts(){
		List<Product> list = new ArrayList<Product>();
		try {
			Connection conn = DBConnection.createConnection();
			String sql="select * from product";
			PreparedStatement pst= conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				Product p = new Product();
				p.setPid(rs.getInt("pid"));
				p.setSid(rs.getInt("sid"));
				p.setPprice(rs.getInt("pprice"));
				p.setPqty(rs.getInt("pqty"));
				p.setImage(rs.getString("image"));
				p.setPname(rs.getString("pname"));
				p.setPcategory(rs.getString("pcategory"));
				p.setPdesc(rs.getString("pdesc"));
				list.add(p);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
