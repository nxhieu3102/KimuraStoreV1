package KimuraStore.Service.Impl;

import KimuraStore.Dao.UserDao;
import KimuraStore.Entity.User;
import KimuraStore.Service.IUserService;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    UserDao userDao;

    @Override
    public void AddAccount(User user) {
        userDao.AddAccount(user);
    }

    @Override
    public boolean IsAccountExist(User user) {
        user = userDao.GetUserByEmail(user.getEmail());
        if(user == null)
            return false;
        return true;
    }

    @Override
    public boolean CheckAccount(User user) {
        String password = user.getPassword();
        user = userDao.GetUserByEmail(user.getEmail());

        if(user == null)
            return false;
        if(BCrypt.checkpw(password, user.getPassword()))
            return true;
        
        return false;
    }

    @Override
    public User GetUserByEmail(String email) {
        return userDao.GetUserByEmail(email);
    }

    @Override
    public void SaveToken(String token, int id) {
        userDao.SaveToken(token, id);
    }

    @Override
    public boolean CheckToken(String token, String email) {
        return userDao.CheckToken(token, email);
    }

    @Override
    public void ChangePassword(String password, User user) {
        userDao.ChangePassword(password, user);
    }


}
