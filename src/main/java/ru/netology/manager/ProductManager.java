package ru.netology.manager;

import ru.netology.domain.Product;
import ru.netology.repository.ProductRepository;

public class ProductManager {
    private ProductRepository repository = new ProductRepository();

    public ProductManager() {
    }

    public ProductManager(ProductRepository repository) {
        this.repository = repository;
    }

    public void add(Product product) {
        repository.save(product);
    }

    public Product[] getAll() {
        return repository.findAll();
    }

    public Product findById(int id) {
        return  repository.findById(id);
    }

    public void removeById(int idToRemove) {
        repository.removeById(idToRemove);
    }
}



