package manager.managerModel.properties;

import model.ACproperties.Role;

import java.util.ArrayList;

public class ManagerRole {
    private ArrayList<Role>listRole;

    public ManagerRole() {
        listRole=new ArrayList<>();
        listRole.add(new Role(0,"ADMIN"));
        listRole.add(new Role(1,"USER"));
        listRole.add(new Role(2,"VIP-1"));
        listRole.add(new Role(3,"VIP-2"));

    }

    public ArrayList<Role> getListRole() {
        return listRole;
    }

    public void setListRole(ArrayList<Role> listRole) {
        this.listRole = listRole;
    }
}
