package Model;

public class AddressBookData {
    int emp_id;
    String empName;
    int cityCount;

    public AddressBookData(){

    }
  
    public int getEmp_id()
    {
        return emp_id;
    }
  
    public int setEmp_id(int emp_id)
    {
        this.emp_id = emp_id;
        return emp_id;
    }
  
    public int setCityCount(int city) {
        this.cityCount = city;
        return cityCount;
    }

    

    public String getEmpName() {
        return empName;
    }

    public String setEmpName(String empName) {
        this.empName = empName;
        return empName;
    }

    @Override
    public String toString() {
        return "EmpPayrollData [cityCount=" + cityCount + ", emp_id=" + emp_id + "]";
    }

    
}
