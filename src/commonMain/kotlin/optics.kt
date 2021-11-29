import arrow.optics.optics

@optics
data class Street(val number: Int, val name: String) {
  companion object
}

@optics
data class Address(val city: String, val street: Street) {
  companion object
}

@optics
data class Company(val name: String, val address: Address) {
  companion object
}

@optics
data class Employee(val name: String, val company: Company?) {
  companion object
}

@optics
data class CompanyEmployees(val employees: List<Employee>) {
  companion object
}

sealed class Keys
object One : Keys()
object Two : Keys()
object Three : Keys()
object Four : Keys()

@optics
data class Db(val content: Map<Keys, String>) {
  companion object
}


