package KimuraStore.Service;

import KimuraStore.Entity.User;
import org.springframework.stereotype.Service;

@Service
public interface IUserService {
    public void AddAccount(User user);
    public boolean IsAccountExist(User user);
    public boolean CheckAccount(User user);
    public User GetUserByEmail(String user);
    public void SaveToken(String token, int id);
    public boolean CheckToken(String token, String email);
    public void ChangePassword(String password, User user);
    public void ChangeInfo(String name, String email, User user);
}
