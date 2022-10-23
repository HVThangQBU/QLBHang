package models;

public class Role {
  int id;
  private String roleName;
  private String roleCode;
public Role() {}
  public Role(int id, String roleName, String roleCode) {
    this.id = id;
    this.roleName = roleName;
    this.roleCode = roleCode;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getRoleName() {
    return roleName;
  }

  public void setRoleName(String roleName) {
    this.roleName = roleName;
  }

  public String getRoleCode() {
    return roleCode;
  }

  public void setRoleCode(String roleCode) {
    this.roleCode = roleCode;
  }
}
