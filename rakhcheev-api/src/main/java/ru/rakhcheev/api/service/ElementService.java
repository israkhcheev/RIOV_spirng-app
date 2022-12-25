package ru.rakhcheev.api.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.rakhcheev.api.entity.Element;
import ru.rakhcheev.api.repo.ElementRepo;

import java.util.List;
import java.util.Optional;

@Service
public class ElementService {

    private final ElementRepo elementRepo;

    @Autowired
    public ElementService(ElementRepo elementRepo) {
        this.elementRepo = elementRepo;
    }

    public Element createElement(Element element) {
        return elementRepo.save(element);
    }

    public Element getElementById(Long id) throws EntityNotFoundException {
        Optional<Element> optionalElement = elementRepo.findById(id);
        if (optionalElement.isEmpty()) throw new EntityNotFoundException();
        return optionalElement.get();
    }

    public List<Element> getAllElements() {
        return elementRepo.findAll();
    }

    public Element updateElement(Long id, Element element) throws EntityNotFoundException {
        Optional<Element> optionalElement = elementRepo.findById(id);
        if (optionalElement.isEmpty()) throw new EntityNotFoundException();
        Element dbElement = optionalElement.get();

        // updating fields
        if (element.getTitle() != null) dbElement.setTitle(element.getTitle());
        if (element.getPrice() != null) dbElement.setPrice(element.getPrice());

        return elementRepo.save(dbElement);
    }

    public boolean deleteElement(Long id) {
        Optional<Element> optionalElement = elementRepo.findById(id);
        if (optionalElement.isEmpty()) throw new EntityNotFoundException();
        Element dbElement = optionalElement.get();

        elementRepo.delete(dbElement);
        return true;
    }

}
