
package service;

/**
 *
 * @author Drew
 */
public class RestaurantCalculator {
    double subtotal;
    
    public RestaurantCalculator(){
        subtotal=0.0;
    }
    
    public double getSteakPrice(String qty){
        double price = 0.0;
        if (!qty.isEmpty()){
            price=Double.parseDouble(qty)*19.95;
        }
        subtotal+=price;
        return price;
    }
    public double getLobsterPrice(String qty){
        double price = 0.0;
        if (!qty.isEmpty()){
            price=Double.parseDouble(qty)*23.95;
        }
        subtotal+=price;
        return price;
    }
    public double getSaladPrice(String qty){
        double price = 0.0;
        if (!qty.isEmpty()){
            price=Double.parseDouble(qty)*3.95;
        }
        subtotal+=price;
        return price;
    }
    public double getBeerPrice(String qty){
        double price = 0.0;
        if (!qty.isEmpty()){
            price=Double.parseDouble(qty)*5.95;
        }
        subtotal+=price;
        return price;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public double getTax() {
        return subtotal*.05;
    }

    public double getTotal() {
        return subtotal+getTax();
    }

    public double getSuggestedTip() {
        return .2*getTotal();
    }
}