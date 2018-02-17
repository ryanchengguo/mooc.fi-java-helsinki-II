package PhoneSearch;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PhoneBook {

    private Map<String, Set<String>> numberByName;
    private Map<String, String> nameByNumber;
    private Map<String, Address> addressByName;
    
    public void addNumber(String name, String number) {
        if (!numberByName.containsKey(name)) {
            numberByName.put(name, new HashSet<String>());
        }
        
        if (!nameByNumber.containsKey(number)) {
            nameByNumber.put(number, name);
        }
        
        numberByName.get(name).add(number);
    }
    
    public void searchNumber(String name) {
        if (numberByName.containsKey(name)) {
            for (String number : numberByName.get(name)) {
                System.out.println(" " + number);
            }
        } else {
            System.out.println("  not found");
        }
    }

    public void searchPersonByNumber(String number) {
        if (nameByNumber.containsKey(number)) {
            System.out.println(" " + nameByNumber.get(number));
        } else {
            System.out.println(" not found");
        }
    }

    public void addAddress(String name, String street, String city) {
        addressByName.put(name, new Address(street, city));
    }

    public void searchPersonalInfo(String name) {
        if (!addressByName.containsKey(name) && !numberByName.containsKey(name)) {
            System.out.println("  not found");
        } else {
            if (addressByName.containsKey(name)) {
                System.out.println("address: " + addressByName.get(name));
            } else {
                System.out.println("address not found");
            }
            
            if (numberByName.containsKey(name)) {
                System.out.println("  phone numbers:");
                for (String number : numberByName.get(name)) {
                    System.out.println("   " + number);
                }
            } else {
                System.out.println("  phone number not found");
            }
        }
    }

    public void deletePersonalInfo(String name) {
        
    }

    public void filteredListing(String keyword) {
        
    }
}
