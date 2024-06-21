import java.util.*;
import java.util.function.Consumer;
import java.util.function.Supplier; 
  public class OfficeParamsList {
          public static void main(String []args) {
                  List<Map<List<Integer>, List<String>>> officeParametersList =
                          new ArrayList<>();     
                  Map<List<Integer>, List<String>> officeParamMap = new HashMap<>();
                  officeParametersList.add(null);        
                 officeParametersList.add(officeParamMap);
                 officeParametersList.add(new HashMap<List<Integer>,                      
                                                                            List<String>>()); 
                // officeParametersList.forEach(e -> System.out.print(e + " "));

                       Supplier<String> i = () -> "Car";
                        Consumer<String> c = x -> System.out.print(x.toLowerCase());
                        Consumer<String> d = x -> System.out.print(x.toUpperCase());
                        c.andThen(d).accept(i.get());
                        System.out.println();
        }
 }

 class IkmTestDemo {    
             public static <T> void print(T... a) {
                   for (T t : a) {
                       System.out.println(t);
                   }
             }         
             public static void main(String[] args){
                   print("My", "Test");
                   print(new Employee<Integer,String>(1,"One"), new Employee<Integer,String>(2,"Two"));         
           }    
         }
         class Employee<T1, T2> {
            public Employee(int id, String name) {
            }
 }


class LinkEx{
        public static void main(String args[]) {
             Set<String> set = new LinkedHashSet<String>();
             set.add("3");
             set.add("1");
             set.add("3");
             set.add("2");
             set.add("3");
             set.add("1");
                    set.forEach(s -> System.out.print(s+"-"));
        }
   }