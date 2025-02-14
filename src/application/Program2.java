package application;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

import java.util.List;
import java.util.Scanner;

public class Program2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

        System.out.println("=== TEST 1: findById =====");
        Department dep = departmentDao.findById(2);
        System.out.println(dep);

        System.out.println("=== TEST 2: findAll =====");
        List<Department> list = departmentDao.findAll();
        for(Department obj : list){
            System.out.println(obj);
        }
        System.out.println();

        System.out.println("=== TEST 3: insert =====");
        Department newDepartment = new Department(null,"Music");
        departmentDao.insert(newDepartment);
        System.out.println("Inserted! New id: " + newDepartment.getId());

        System.out.println();

        System.out.println("=== TEST 4: update =====");

        dep = departmentDao.findById(1);
        dep.setName("Food");
        departmentDao.update(dep);

        System.out.println("Update complete!");

        System.out.println();

        System.out.println("=== TEST 4: delete =====");
        System.out.print("Enter id of department to delete: ");
        int id = sc.nextInt();
        departmentDao.deleteById(id);

        System.out.println("Delete completed!");


        sc.close();




    }
}
