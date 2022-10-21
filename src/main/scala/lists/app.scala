package lists

object app extends App {

  sealed abstract class Employee(firstName: String, lastName: String, department: String, salary: Double)

  object Employee {

    final case class Engineer(firstName: String, lastName: String, department: String, salary: Double, group: String)
      extends Employee(firstName, lastName, department, salary)

    final case class Doctor(firstName: String, lastName: String, department: String, salary: Double, group: String)
      extends Employee(firstName, lastName, department, salary)


  }

  import Employee._

  val eng1 = Engineer("Isaac", "Newton", "IT", 4500.50, "Engineering")
  val eng2 = Engineer("Albert", "Einstein", "IT", 4699.50, "Engineering")

  val doc1 = Doctor("Michael", "Young", "Cardio", 5000.5, "Medicine")
  val doc2 = Doctor("Jeffrey", "Hall", "Pathology", 6000.5, "Medicine")

  val engineers: List[Engineer] = eng1 :: eng2 :: Nil
  val doctors: List[Doctor]     = doc1 :: doc2 :: Nil

  val employees: List[Employee] = engineers ::: doctors

  println(employees.contains(eng1))
    
}
