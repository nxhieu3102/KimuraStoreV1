package KimuraStore.Service;

import KimuraStore.Dto.CartDto;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public interface ICartService {


    public HashMap<Integer, CartDto> AddCart(int id, HashMap<Integer, CartDto> cart);

    public HashMap<Integer, CartDto> EditCart(int id, int quantity, HashMap<Integer, CartDto> cart);

    public HashMap<Integer, CartDto> DeleteCart(int id, HashMap<Integer, CartDto> cart);

    public int GetTotalQuantity(HashMap<Integer, CartDto> cart);

    public double GetTotalPrice(HashMap<Integer, CartDto> cart);
}
