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

    public boolean AddAccount(User user) {
        User c = GetUserByEmail(user.getEmail());
        if(c != null)
            return false;

        StringBuffer sql = new StringBuffer();
        sql.append("INSERT ");
        sql.append("into user( ");
        sql.append("email, ");
        sql.append("password, ");
        sql.append("display_name, ");
        sql.append("role ");
        sql.append(") ");
        sql.append("values ");
        sql.append("( ");
        sql.append("'"+ user.getEmail()+ "', ");
        sql.append("'"+ user.getPassword()+ "', ");
        sql.append("'"+ user.getDisplay_name()+ "', ");
        sql.append("'"+ user.getRole()+ "' ");

        sql.append(")");

        _jdbcTemplate.update(sql.toString());
        return true;
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

    public void ChangeInfo(String name, String email, User user) {
        //UPDATE `kimurastore`.`user` SET `email` = 'ab@gmail.com', `display_name` = 'hieu dz' WHERE (`id` = '12');
        int id = user.getId();
        String sql = "UPDATE user SET `email` = '" + email + "', `display_name` = '" + name + "' WHERE id = " + id;
        _jdbcTemplate.update(sql);
    }

    public List<User> GetDataUser() {
        String sql = "SELECT * FROM user";
        List<User> users = _jdbcTemplate.query(sql, new MapperUser());
        return users;
    }

    public void DeleteUser(int id) {
        String sql = "DELETE FROM user WHERE id = " + id;
        _jdbcTemplate.update(sql);
    }

    public boolean EditUser(int id, String name, String email, String role) {
        //UPDATE `kimurastore`.`user` SET `email` = 'aaa@gmail.com', `display_name` = 'Hiếu đẹp trai' WHERE (`id` = '13');
        String sql = "SELECT * FROM user WHERE email = '" + email + "'";
        List<User> user = _jdbcTemplate.query(sql, new MapperUser());

        if(user.size() > 0)
            return false;

        sql = "UPDATE user SET email = '" + email + "', display_name = '" + name + "', role = " + role + " WHERE id = " + id;
        _jdbcTemplate.update(sql);
        return true;
    }

    public User GetUserById(int id) {
        String sql = "SELECT * FROM user WHERE id = " + id;
        List<User> user = _jdbcTemplate.query(sql, new MapperUser());
        if(user.size() == 0)
            return null;
        return user.get(0);
    }
}
