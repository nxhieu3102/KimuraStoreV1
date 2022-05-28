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
    public boolean checkAccount(User user) {
        String password = user.getPassword();
        user = userDao.GetUserByEmail(user.getEmail());

        if(user == null)
            return false;

        if(BCrypt.checkpw(password, user.getPassword()))
            return true;
        
        return false;
    }

    @Override
    public User GetUserByEmail(User user) {
        return userDao.GetUserByEmail(user.getEmail());
    }
}
