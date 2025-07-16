package application;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

import java.util.List;
import java.util.Scanner;

public class ProgramDep {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        DepartmentDao departmentDao = DaoFactory.createDepartment();

        System.out.println("\n=== TEST 1: department insert ===");
        Department dep = new Department(null, "Dance");
        departmentDao.insert(dep);
        System.out.println("Done! Department inserted!");

        System.out.println("\n=== TEST 2: department findById ===");
        dep = departmentDao.findById(7);
        System.out.println(dep);

        System.out.println("\n=== TEST 3: department Update ===");
        dep = departmentDao.findById(7);
        dep.setName("Yoga");
        departmentDao.update(dep);
        System.out.println("Done! Updated completed");

        System.out.println("\n=== TEST 4: department findAll ===");
        List<Department> list = departmentDao.findAll();
        for (Department obj : list){
            System.out.println(obj);
        }

        System.out.println("\n=== TEST 5: department Delete ===");
        int id = sc.nextInt();
        departmentDao.deleteById(id);
        System.out.println("Delete completed");

        sc.close();
    }
}
