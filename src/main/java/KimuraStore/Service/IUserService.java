package KimuraStore.Service;

import KimuraStore.Entity.User;
import org.springframework.stereotype.Service;

@Service
public interface IUserService {
    public void AddAccount(User user);
    public boolean IsAccountExist(User user);
    public boolean checkAccount(User user);
    public User GetUserByEmail(User user);
}
