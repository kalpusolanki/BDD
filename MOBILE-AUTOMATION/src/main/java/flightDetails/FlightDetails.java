package flightDetails;


import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class FlightDetails {
    private String flightId;
    private String passangerName;
    private int fare;
    private String destination;
    private boolean status;
    private TravelClass travelclass;
    public FlightDetails(String flightId,String passangerName,int fare,String destination,boolean status,TravelClass travelClass)
    {
        this.flightId=flightId;
        this.passangerName=passangerName;
        this.fare=fare;
        this.destination=destination;
        this.status=status;
        this.travelclass=travelClass;

    }

    public String getPassangerName()
    {
        return passangerName;
    }

    public String getDestination()
    {
        return  destination;

    }
    public TravelClass getTravelClass()
    {
        return  travelclass;

    }

    public static void main(String[] args) {
       List<FlightDetails> fd = Arrays.asList(new FlightDetails("F101","John",5000,"Delhi",true,TravelClass.ECONOMY),
                                              new FlightDetails("F102","ALice",6000,"banglore",true,TravelClass.FIRST),
                                               new FlightDetails("F103","Bob",7000,"lucknow",true,TravelClass.ECONOMY),
                                               new FlightDetails("F104","Emma",2000,"Delhi",true,TravelClass.BUSINESS),
                                                new FlightDetails("F105","namrta",1000,"Delhi",true,TravelClass.ECONOMY),
                                                  new FlightDetails("F106","Jsjgj",8000,"banglore",true,TravelClass.BUSINESS));


//        Map<String, List<String>> ns = fd.stream().collect(Collectors.groupingBy(FlightDetails::getDestination, Collectors.mapping(FlightDetails::getPassangerName, Collectors.toList())));
//      ns.forEach((s, passangeName) -> System.out.println(s+"    "+passangeName));


//        Map<String, List<FlightDetails>> ns = fd.stream().collect(Collectors.groupingBy(FlightDetails::getDestination));
//        ns.forEach((destination,list)->{System.out.println(destination+"   ");
//       list.forEach((v)->{
//           System.out.print("Status  "+v.status);System.out.print("   TC  "+v.travelclass);System.out.print("   flight  "+v.flightId);System.out.print("    PN  "+v.passangerName);
//
//       });
//       System.out.println();  System.out.println();});


        Map<String, List<String>> md = fd.stream().collect(Collectors.groupingBy(FlightDetails::getDestination, Collectors.mapping(f -> f.getPassangerName() + "(" + f.getTravelClass() + ")", Collectors.toList())));

        md.entrySet().forEach(f-> System.out.println(f.getKey()+"-------"+f.getValue()));
    }
//
//    // Accumulate names into a List
//    List<String> list = people.stream()
//            .map(Person::getName)
//            .collect(Collectors.toList());
//
//    // Accumulate names into a TreeSet
//    Set<String> set = people.stream()
//            .map(Person::getName)
//            .collect(Collectors.toCollection(TreeSet::new));
//
//    // Convert elements to strings and concatenate them, separated by commas
//    String joined = things.stream()
//            .map(Object::toString)
//            .collect(Collectors.joining(", "));
//
//    // Compute sum of salaries of employee
//    int total = employees.stream()
//            .collect(Collectors.summingInt(Employee::getSalary));
//
//    // Group employees by department
//    Map<Department, List<Employee>> byDept = employees.stream()
//            .collect(Collectors.groupingBy(Employee::getDepartment));
//
//    // Compute sum of salaries by department
//    Map<Department, Integer> totalByDept = employees.stream()
//            .collect(Collectors.groupingBy(Employee::getDepartment,
//                    Collectors.summingInt(Employee::getSalary)));
//
//    // Partition students into passing and failing
//    Map<Boolean, List<Student>> passingFailing = students.stream()
//            .collect(Collectors.partitioningBy(s -> s.getGrade() >= PASS_THRESHOLD))
}
