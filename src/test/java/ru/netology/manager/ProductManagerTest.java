package ru.netology.manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.TShirt;

import static org.junit.jupiter.api.Assertions.assertEquals;


class ProductManagerTest {
    private ProductManager manager = new ProductManager();
    private Book coreJava = new Book();
    private Book first = new Book(1, "Учебник", 300, "Иванов", 250, 1990);
    private Book second = new Book(2, "История", 250, "Гришин", 300, 2000);
    private Book third = new Book(3, "Журнал", 180, "Издательство", 1000, 2018);
    private TShirt fff = new TShirt(4, "FFF", 1000, "blu", "L");
    private TShirt sss = new TShirt(5, "SSS", 1200, "green", "M");
    private TShirt ttt = new TShirt(6, "ttt", 1500, "black", "XXL");

    @BeforeEach
    public void setUp() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fff);
        manager.add(sss);
        manager.add(ttt);
    }

    @Test
    public void add() {
        manager.add(coreJava);
        Product[] expected = new Product[]{first, second, third, fff, sss, ttt, coreJava};
        Assertions.assertArrayEquals(expected, manager.getAll());
    }

    @Test
    public void getAll() {
        Product[] expected = new Product[]{first, second, third, fff, sss, ttt};
        Assertions.assertArrayEquals(expected, manager.getAll());
    }

    @Test
    public void findById() {
        Product expected = new Book(2, "История", 250, "Гришин", 300, 2000);
        Product actual = manager.findById(2);
        assertEquals (expected, actual);
    }

    @Test
    void removeById() {
        manager.removeById(5);
        Product[] expected = new Product[]{first, second, third, fff, ttt};
        Assertions.assertArrayEquals(expected, manager.getAll());
    }
}