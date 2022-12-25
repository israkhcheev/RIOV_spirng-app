package ru.rakhcheev.api.repo;

import org.springframework.data.repository.CrudRepository;
import ru.rakhcheev.api.entity.Shop;

import java.util.List;

public interface ShopRepo extends CrudRepository<Shop, Long> {

    List<Shop> findAll();

}
