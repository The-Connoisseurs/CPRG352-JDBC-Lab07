package dataaccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import models.Role;

/**
 * Program description: provides access to the database, allowing role
 * information to be viewed 
 * 
 * @author Jeric Geronimo & Don Laliberte
 */
public class RoleDB {
    public List<Role> getAll() throws Exception {
        List<Role> roleList = new ArrayList<>();
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM role";

        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {

                // retrieve the info from database
                int roleNum = rs.getInt(1);
                String roleDescription = rs.getString(2);

                // create a new role object 
                Role role = new Role(roleNum, roleDescription);

                // add role object to list
                roleList.add(role);
            }
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            cp.freeConnection(con);
        }

        return roleList;
    }
}
