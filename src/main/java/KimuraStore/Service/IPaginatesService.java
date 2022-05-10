package KimuraStore.Service;

import KimuraStore.Dto.PaginatesDto;
import org.springframework.stereotype.Service;

@Service
public interface IPaginatesService {
    public PaginatesDto GetInfoPaginates(int totalData, int limit, int currentPage);
}
