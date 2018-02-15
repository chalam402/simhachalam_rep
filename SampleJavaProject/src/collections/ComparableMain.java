package collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
//If this.countryId < country.countryId:then compare method will return -1
//If this.countryId > country.countryId:then compare method will return 1
//If this.countryId==country.countryId:then compare method will return 0

class Country implements Comparable<Country>{
  int countryId;
  String countryName;
  
  
  public Country(int countryId, String countryName) {
      super();
      this.countryId = countryId;
      this.countryName = countryName;
  }
  
  @Override
  public int compareTo(Country country) {
      return (this.countryId < country.countryId ) ? -1: (this.countryId > country.countryId ) ? 1:0 ;
  }
  
  
  public int getCountryId() {
      return countryId;
  }
  
  
  public void setCountryId(int countryId) {
      this.countryId = countryId;
  }
  
  
  public String getCountryName() {
      return countryName;
  }
  
  
  public void setCountryName(String countryName) {
      this.countryName = countryName;
  }
  
}
public class ComparableMain {
    
    public static void main(String[] args) {
        Country indiaCountry=new Country(1, "India");
        Country chinaCountry=new Country(4, "USA");
        Country nepalCountry=new Country(3, "Russia");
        Country bhutanCountry=new Country(2, "Japan");
        
        List<Country> listOfCountries = new ArrayList<Country>();
        listOfCountries.add(indiaCountry);
        listOfCountries.add(chinaCountry);
        listOfCountries.add(nepalCountry);
        listOfCountries.add(bhutanCountry);
        
        System.out.println("ComparableMain - Before Sort  : ");
        for (int i = 0; i < listOfCountries.size(); i++) {
            Country country=(Country) listOfCountries.get(i);
            System.out.println("Country Id: "+country.getCountryId()+"||"+"Country name:"+country.getCountryName());
        }
        Collections.sort(listOfCountries);
        
        System.out.println("ComparableMain - After Sort  : ");
        for (int i = 0; i < listOfCountries.size(); i++) {
            Country country=(Country) listOfCountries.get(i);
            System.out.println("Country Id: "+country.getCountryId()+"|| "+"Country name: "+country.getCountryName());
        }
    }
    
}