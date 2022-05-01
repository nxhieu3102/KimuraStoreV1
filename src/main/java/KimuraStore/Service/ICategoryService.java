package KimuraStore.Service;

import KimuraStore.Enity.Category;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ICategoryService {
    public List<Category> GetDataCategory();
}
