package KimuraStore.Service.Impl;

import KimuraStore.Dto.PaginatesDto;
import KimuraStore.Service.IPaginatesService;
import org.springframework.stereotype.Service;

@Service
public class PaginateServiceImpl implements IPaginatesService {

    @Override
    public PaginatesDto GetInfoPaginates(int totalData, int limit, int currentPage) {
        PaginatesDto paginates = new PaginatesDto();
        paginates.setLimit(limit);

        int totalPage = SetInfoTotalPage(totalData, limit);
        paginates.setTotalPage(totalPage);
        paginates.setCurrentPage(checkCurrentPage(currentPage, totalPage));

        int start = findStart(paginates.getCurrentPage(), limit);
        int end = findEnd(start, limit, totalData);

        paginates.setStart(start);
        paginates.setEnd(end);

        return paginates;
    }

    private int findEnd(int start, int limit, int totalData) {
        return start + limit > totalData ? totalData : start + limit - 1;
    }

    private int findStart(int currentPage, int limit) {
        return (currentPage - 1) * limit + 1;
    }

    private int checkCurrentPage(int currentPage, int totalPage) {
        if (currentPage < 1)
            return 1;
        if (currentPage > totalPage && totalPage > 0)
            return totalPage;
        return currentPage;
    }

    private int SetInfoTotalPage(int totalData, int limit) {
        int totalPage = 0;
        totalPage = totalData / limit + ((totalData % limit == 0) ? 0 : 1);
        return totalPage;
    }
}
