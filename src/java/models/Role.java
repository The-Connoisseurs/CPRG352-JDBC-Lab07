package models;

public class Role {
    private int roleNum;
    private String roleDescription;

    public Role(int roleNum, String roleDescription) {
        this.roleNum = roleNum;
        this.roleDescription = roleDescription;
    }

    public int getRoleNum() {
        return roleNum;
    }

    public void setRoleNum(int roleNum) {
        this.roleNum = roleNum;
    }

    public String getRoleDescription() {
        return roleDescription;
    }

    public void setRoleDescription(String roleDescription) {
        this.roleDescription = roleDescription;
    }

 
    
}
