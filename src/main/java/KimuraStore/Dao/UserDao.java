package KimuraStore.Dao;

import KimuraStore.Entity.Mapper.MapperUser;
import KimuraStore.Entity.User;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDao extends BaseDao {
    private StringBuffer sqlString() {
        StringBuffer  sql = new StringBuffer();
        sql.append("select * from user ");
        return  sql;
    }

    public void AddAccount(User user) {
        StringBuffer sql = new StringBuffer();
        sql.append("INSERT ");
        sql.append("into user( ");
        sql.append("email, ");
        sql.append("password, ");
        sql.append("display_name ");
        sql.append(") ");
        sql.append("values ");
        sql.append("( ");
        sql.append("'"+ user.getEmail()+ "', ");
        sql.append("'"+ user.getPassword()+ "', ");
        sql.append("'"+ user.getDisplay_name()+ "' ");
        sql.append(")");

        _jdbcTemplate.update(sql.toString());
    }

    public User GetUserByEmail(String email) {
        StringBuffer sql = sqlString();
        sql.append("WHERE email =  '" + email + "'");
        List<User> list = _jdbcTemplate.query(sql.toString(), new MapperUser());

        if(list.size() == 0)
            return null;

        return list.get(0);
    }

    public void SaveToken(String token, int id) {
        String sql = "UPDATE user SET `reset_password_token` = '" + token + "' WHERE id = " + id;
        _jdbcTemplate.update(sql);
    }

    public boolean CheckToken(String token, String email) {
        User user = GetUserByEmail(email);

        if(user == null)
            return false;

        String resetPasswordToken = user.getResetPasswordToken();
        if(resetPasswordToken.equals(token))
            return true;

        return false;
    }

    public void ChangePassword(String password, User user) {
        int id = user.getId();
        password = BCrypt.hashpw(password, BCrypt.gensalt(12));
        String sql = "UPDATE user SET `password` = '" + password + "' WHERE id = " + id;
        _jdbcTemplate.update(sql);
    }

}
