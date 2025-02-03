package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.DBConnection;
import model.WishList;

public class WIshListDao {
	public static void addToWishList(WishList w) {
		try {
			Connection conn = DBConnection.createConnection();
			String sql = "insert into wishlist(cus_id,pid) values(?,?)";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, w.getCus_id());
			pst.setInt(2, w.getPid());
			pst.executeUpdate();
			System.out.println("addedd");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static List<WishList> getWishLIstByCusID(int cus_id){
		List<WishList> list = new  ArrayList<WishList>();
		try {
			Connection conn = DBConnection.createConnection();
			String sql = "select * from wishlist where cus_id=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, cus_id);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				WishList w= new WishList();
				w.setWid(rs.getInt("wid"));
				w.setCus_id(rs.getInt("cus_id"));
				w.setPid(rs.getInt("pid"));
				list.add(w);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public static void removerProduct(int wid) {
		try {
			Connection conn = DBConnection.createConnection();
			String sql = "delete from wishlist where wid=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, wid);
			pst.executeUpdate();
			System.out.println("deleted");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
