package KimuraStore.Service;

import org.springframework.stereotype.Service;

@Service
public interface IEmailService {
    public void SendMessage(String to, String subject, String text);
    String GenerateToken(int len);
}
