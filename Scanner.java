public class Scanner {
   
    String[] item = new String[3];
    double totalPrice;

    public String[] match(String input, String cPrice) {
        if (input.equals("001")) {
            item[0] = "2.99";
            item[1] = "apple";
            totalPrice = Double.parseDouble(cPrice) + Double.parseDouble(item[0]);
            item[2] = String.valueOf(totalPrice);
        } else if (input.equals("002")) {
            item[0] = "3.99";
            item[1] = "orange";
            totalPrice = Double.parseDouble(cPrice) + Double.parseDouble(item[0]);
            item[2] = String.valueOf(totalPrice);
        }else if (input.equals("003")){
            item[0] = "4.99";
            item[1] = "pear";
            totalPrice = Double.parseDouble(cPrice) + Double.parseDouble(item[0]);
            item[2] = String.valueOf(totalPrice);
        } else {
            System.out.println("That is an invalid product!");
        }
        return item;
    }
}
