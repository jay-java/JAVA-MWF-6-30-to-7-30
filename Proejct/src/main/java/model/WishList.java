package model;

public class WishList {
	private int wid,cus_id,pid;

	public int getCus_id() {
		return cus_id;
	}

	public void setCus_id(int cus_id) {
		this.cus_id = cus_id;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public int getWid() {
		return wid;
	}

	public void setWid(int wid) {
		this.wid = wid;
	}

	@Override
	public String toString() {
		return "WishList [wid=" + wid + ", cus_id=" + cus_id + ", pid=" + pid + "]";
	}
	
}
