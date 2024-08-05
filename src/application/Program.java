package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.Date;
import java.util.List;

public class Program {
    public static void main(String[] args) {

        SellerDao sellerDao = new DaoFactory().createSellerDao();
        System.out.println("=== TEST 1: seller findById ====");
        Seller seller = sellerDao.findById(3);
        System.out.println(seller);
        System.out.println();

        System.out.println("=== Test 2: seller findByDepartment ==== ");
        Department department = new Department(2,null);
        List<Seller> list = sellerDao.findByDepartment(department);
        for(Seller obj : list){
            System.out.println(obj);
        }
        System.out.println();

        System.out.println("=== Test 3: seller findAll ==== ");
        list = sellerDao.findAll();
        for(Seller obj : list){
            System.out.println(obj);
        }
        System.out.println();
        System.out.println("=== Test 4: seller insert ==== ");
        Seller newSeller = new Seller(null,"Greg","greg@gmail.com", new Date(),4000.0, department);
        sellerDao.insert(newSeller);
        System.out.println("Inserted! new id = " + newSeller.getId());
        System.out.println();
        System.out.println("=== Test 5: seller UPDATE ==== ");
        seller = sellerDao.findById(1);
        seller.setName("Marta wayne");
        sellerDao.update(seller);

        System.out.println("Update completed!");

    }

}
