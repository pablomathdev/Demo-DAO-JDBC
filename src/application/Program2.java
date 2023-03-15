package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("\n=== TEST 1: Department insert ====");

		Department newDepartment = new Department(null, "Finance");
		DepartmentDao depDao = DaoFactory.createDepartmentDao();

		depDao.insert(newDepartment);
		System.out.println("Inserted! New id = " + newDepartment.getId());

		System.out.println("\n=== TEST 2: Department findById ====");

		System.out.println("Enter id of department: ");
		int id = sc.nextInt();
		Department dep = depDao.findById(id);

		System.out.println(dep);

		System.out.println("\n=== TEST 3: Department findByAll ====");

		List<Department> list = depDao.findAll();

		for (Department obj : list) {
			System.out.println(obj);
		}

		System.out.println("\n=== TEST 4: Department update ====");
		System.out.println("Enter id of department: ");

		dep = depDao.findById(sc.nextInt());

		dep.setName("Clothes");
		depDao.update(dep);
		System.out.println("Update completed");

		System.out.println("\n=== TEST 5: Department delete ====");

		System.out.println("Enter id for delete test: ");
		
		depDao.deleteById(sc.nextInt());
		System.out.println("Delete completed");
		sc.close();
	}

}
