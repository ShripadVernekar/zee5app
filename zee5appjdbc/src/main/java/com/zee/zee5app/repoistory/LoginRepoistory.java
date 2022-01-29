package com.zee.zee5app.repoistory;

import com.zee.zee5app.dto.Login;
import com.zee.zee5app.dto.ROLE;

public interface LoginRepoistory {
	
	public String addCredentials(Login login);

	public String deleteCredentials(String userName);

	public String changePassword(String userName,String password);

	public String changeRole(String userName,ROLE role);

}
