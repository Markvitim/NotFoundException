package ru.netology.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.TShirt;
import ru.netology.manager.NotFoundException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProductRepositoryTest {
    private ProductRepository repository = new ProductRepository();
    private Book coreJava = new Book();
    private Book first = new Book(1, "Учебник", 300, "Иванов", 250, 1990);
    private Book second = new Book(2, "История", 250, "Гришин", 300, 2000);
    private Book third = new Book(3, "Журнал", 180, "Издательство", 1000, 2018);
    private TShirt fff = new TShirt(4, "FFF", 1000, "blu", "L");
    private TShirt sss = new TShirt(5, "SSS", 1200, "green", "M");
    private TShirt ttt = new TShirt(6, "ttt", 1500, "black", "XXL");

    @BeforeEach
    public void setUp() {
        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.save(fff);
        repository.save(sss);
        repository.save(ttt);
    }

    @Test
    public void save() {
        repository.save(coreJava);
        Product[] expected = new Product[]{first, second, third, fff, sss, ttt, coreJava};
        Assertions.assertArrayEquals(expected, repository.findAll());
    }

    @Test
    public void findAll() {
        Product[] expected = new Product[]{first, second, third, fff, sss, ttt};
        Assertions.assertArrayEquals(expected, repository.findAll());
    }

    @Test
    public void removeById() {
        repository.removeById(1);
        Product[] expected = new Product[]{second, third, fff, sss, ttt};
        Assertions.assertArrayEquals(expected, repository.findAll());
    }

    @Test
    public void checkNFE(){
        Assertions.assertThrows(NotFoundException.class, ()->{repository.removeById(10);});
    }

    @Test
    public void findById() {
        Product expected = new Book(2, "История", 250, "Гришин", 300, 2000);
        assertEquals(expected, repository.findById(2));
    }

}
