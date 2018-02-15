package CreationalDesignPattern;
interface Currency {
	 
    public String getCurrency();
     
    public String getSymbol();
}
class India implements Currency{
	 
    @Override
    public String getCurrency() {
         
        return "Rupee";
    }
 
    @Override
    public String getSymbol() {
         
        return "Rs";
    }
 
    public static void main(String a[]){
         
        India in = new India();
        System.out.println(in.getSymbol());
    }
}
class USA implements Currency{
	 
    @Override
    public String getCurrency() {
         
        return "Dollar";
    }
 
    @Override
    public String getSymbol() {
         
        return "$";
    }
}
public class CurrencyFactoryPatternExample_2 {
	public static Currency getCurrencyByCountry(String cnty) throws Exception{
        
        if("IN".equalsIgnoreCase(cnty)){
            return new India();
        } else if("USA".equalsIgnoreCase(cnty)){
            return new USA();
        }
        throw new Exception("Invalid country...");
    }
     
     
    public static void main(String a[]){
        Currency india;
        try {
            india = CurrencyFactoryPatternExample_2.getCurrencyByCountry("IN");
            System.out.println("Indian currency: "+india.getCurrency());
            System.out.println("Indian currency symbol: "+india.getSymbol());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
