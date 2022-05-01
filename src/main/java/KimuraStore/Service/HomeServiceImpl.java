package KimuraStore.Service;

import KimuraStore.Dao.SlidesDao;
import KimuraStore.Enity.Slide;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HomeServiceImpl implements IHomeService{

    @Autowired
    private SlidesDao slidesDao;

    @Override
    public List<Slide> GetDataSlide() {
        return slidesDao.GetDataSlide();
    }
}
