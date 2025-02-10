package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.DBConnection;
import model.Cart;

public class CartDao {
	public static void insertINtoCart(Cart c) {
		try {
			Connection conn = DBConnection.createConnection();
			String sql="insert into cart(cus_id,pid,qty,pprice,total_price,net_price,payment_status) values(?,?,?,?,?,?,?)";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, c.getCus_id());
			pst.setInt(2, c.getPid());
			pst.setInt(3, c.getQty());
			pst.setInt(4, c.getPprice());
			pst.setInt(5, c.getTotal_price());
			pst.setInt(6, c.getNet_price());
			pst.setString(7, c.getPayment_status());
			pst.executeUpdate();
			System.out.println("added into cart");
		} catch (Exception e) { 
			e.printStackTrace();
		}
	}
	public static List<Cart> getCartByCusId(int cus_id){
		List<Cart> list = new ArrayList<Cart>();
		try {
			Connection conn = DBConnection.createConnection();
			String sql="select * from cart where cus_id=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, cus_id);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				Cart c =new Cart();
				c.setCart_id(rs.getInt("cart_id"));
				c.setCus_id(rs.getInt("cus_id"));
				c.setPid(rs.getInt("pid"));
				c.setQty(rs.getInt("qty"));
				c.setPprice(rs.getInt("pprice"));
				c.setTotal_price(rs.getInt("total_price"));
				c.setPayment_status(rs.getString("payment_status"));
				list.add(c);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public static void updatecart(Cart c) {
		try {
			Connection conn = DBConnection.createConnection();
			String sql="update cart set qty=?,total_price=? where cart_id=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, c.getQty());
			pst.setInt(2, c.getTotal_price());
			pst.setInt(3, c.getCart_id());
			pst.executeUpdate();
			System.out.println("cart updated");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
