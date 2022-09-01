package user.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import lombok.Setter;
import user.bean.UserDTO;

@Repository
@Transactional // 마이바티스 처리할때 얘가 다 처리해줌.
public class UserDAOMyBatis implements UserDAO {
	
	@Autowired
	private SqlSession sqlSession = null;


	@Override
	public void write(UserDTO userDTO) {
		sqlSession.insert("userSQL.write", userDTO); // sqlSession.close 해주지 않아도됨. transactionManager이 해줌. 
	}

	@Override
	public UserDTO checkId(String id) {
		
		return sqlSession.selectOne("userSQL.checkId", id); // 아이디를 가지고 가서 검색해와 
	}
	
	@Override
	public List<UserDTO> getUserList() {
		return sqlSession.selectList("userSQL.getUserList"); // 디비
		
	}

	@Override
	public UserDTO getUser(String id) {
		return sqlSession.selectOne("userSQL.getUser", id);
	}

	@Override
	public void update(Map<String, String> map) {
		sqlSession.update("userSQL.update", map);
	}

	@Override
	public void delete(String id) {
		sqlSession.delete("userSQL.delete", id);
	}

	@Override
	public List<UserDTO> getUserSearchList(Map<String, String> map) {
		
		return sqlSession.selectList("userSQL.getUserSearchList", map);
	}

}
