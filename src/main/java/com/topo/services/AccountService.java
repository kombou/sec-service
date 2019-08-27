package com.topo.services;

import com.topo.entities.AppRole;
import com.topo.entities.AppUser;

public interface AccountService {
    public AppUser saveUser(String username, String password, String confirmedPassord);
    public AppRole save(AppRole role);
    public  AppUser loadUserByUsername(String username);
    public void addRoleToUser(String username, String rolename);
}
