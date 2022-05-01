package KimuraStore.Service;

import KimuraStore.Enity.Slide;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IHomeService {
    public List<Slide> GetDataSlide();
}
