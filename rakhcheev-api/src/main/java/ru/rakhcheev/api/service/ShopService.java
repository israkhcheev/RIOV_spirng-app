package ru.rakhcheev.api.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.rakhcheev.api.dto.ShopRegistry;
import ru.rakhcheev.api.entity.Shop;
import ru.rakhcheev.api.repo.ShopRepo;

import java.util.List;
import java.util.Optional;

@Service
public class ShopService {

    private final ShopRepo shopRepo;

    @Autowired
    public ShopService(ShopRepo elementRepo) {
        this.shopRepo = elementRepo;
    }

    public Shop createShop(ShopRegistry element) {
        Shop shop = new Shop();
        shop.setName(element.getName());
        shop.setType(element.getType());
        shop.setOnline(element.isOnline());
        return shopRepo.save(shop);
    }

    public Shop getShopById(Long id) throws EntityNotFoundException {
        Optional<Shop> optionalElement = shopRepo.findById(id);
        if (optionalElement.isEmpty()) throw new EntityNotFoundException();
        return optionalElement.get();
    }

    public List<Shop> getAllShop() {
        return shopRepo.findAll();
    }

    public Shop updateShop(Long id, Shop element) throws EntityNotFoundException {
        Optional<Shop> optionalElement = shopRepo.findById(id);
        if (optionalElement.isEmpty()) throw new EntityNotFoundException();
        Shop dbElement = optionalElement.get();

        // updating fields
        if (element.getName() != null) dbElement.setName(element.getName());
        if (element.getType() != null) dbElement.setType(element.getType());
        if (element.getType() != null) dbElement.setType(element.getType());

        return shopRepo.save(dbElement);
    }

    public boolean deleteShop(Long id) {
        Optional<Shop> optionalElement = shopRepo.findById(id);
        if (optionalElement.isEmpty()) throw new EntityNotFoundException();
        Shop dbElement = optionalElement.get();

        shopRepo.delete(dbElement);
        return true;
    }


}
