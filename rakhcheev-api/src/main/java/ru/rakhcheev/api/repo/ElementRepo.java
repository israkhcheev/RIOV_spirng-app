package ru.rakhcheev.api.repo;

import org.springframework.data.repository.CrudRepository;
import ru.rakhcheev.api.entity.Element;

import java.util.List;

public interface ElementRepo extends CrudRepository<Element, Long> {

    List<Element> findAll();

}
