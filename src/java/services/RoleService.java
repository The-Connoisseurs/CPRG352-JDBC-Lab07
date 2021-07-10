package services;

import dataaccess.RoleDB;
import java.util.List;
import models.Role;
        
public class RoleService {
    public List<Role> getAll() throws Exception {
        RoleDB userDB = new RoleDB();
        List<Role> roleList = userDB.getAll();
        return roleList;
    }
}
