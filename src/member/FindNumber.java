package member;

import java.sql.SQLException;

import user.Main;

public class FindNumber {
	
	public static int find(String table, String attribute){
		int n=0;
		int count;
		while(true){
			n++;
			String sql="SELECT COUNT(*) count FROM " + table + " WHERE " + attribute + " = " + n;
			try {
				Main.rs = Main.st.executeQuery(sql);
				while(Main.rs.next()){
					count = Main.rs.getInt("count");
					if(count==0)
						return n;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}		
	}
}
