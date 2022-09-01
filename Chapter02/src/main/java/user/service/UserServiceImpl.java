package user.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import user.bean.UserDTO;
import user.dao.UserDAO;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDAO userDAO = null;
	
	@Override
	public void write(UserDTO userDTO) {
		userDAO.write(userDTO);
		
	}

	@Override
	public String checkId(String id) { // 여기서 db 갔다오면 됨
		UserDTO userDTO =userDAO.checkId(id); 
		// sql에서는 select * from usertable where id = 'hong' => return 은 절대 boolean형이 올 수 없다! 
		// return 시켜주는건 DTO 로 리턴된다! 
		
		//select name usertable where id = 'hong' => return 은 String이 된다!
		
		if(userDTO == null) 
			return "non_exist";
		else 
			return "exist";
	}

	@Override
	public List<UserDTO> getUserList() {
		return userDAO.getUserList();
	}

	@Override
	public UserDTO getUser(String id) {
		return userDAO.getUser(id);

	}

	@Override
	public void update(Map<String, String> map) {
		userDAO.update(map);
	}

	@Override
	public void delete(String id) {
		userDAO.delete(id);
		
	}

	@Override
	public void upload(String id) {
		// TODO Auto-generated method stub
		
	}
}
