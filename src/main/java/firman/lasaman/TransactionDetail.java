package firman.lasaman;

/**
 * description of class TransactionDetail 
 *
 * @author firman.lasaman
 * @version  v1.0.0
 */
public class TransactionDetail {
    // create constructor
    private String name;
    private String address;
    private String model;
    private int quantity;
    private String creditCard;
    private Double grossAmount;
    private Double vat;
    private Double totalPrice;

   
   /**
     * constructor for transactiondetail
    * @param name name
    * @param address address
    * @param model xiaomi model
    * @param quantity quantity
    * @param creditCard credit card
    * @param grossAmount gross amount
    * @param vat vat
    * @param totalPrice total price
    */
   public TransactionDetail (String name, String address, String model, int quantity, String creditCard, Double grossAmount, Double vat, Double totalPrice){
       this.name = name;
       this.address = address;
       this.model = model;
       this.quantity = quantity;
       this.creditCard = creditCard;
       this.grossAmount = grossAmount;
       this.vat = vat;
       this.totalPrice = totalPrice;
   }
   /**
     * constructor for transactiondetail
    */
   public TransactionDetail(){

   }
   /**
    * to get name
     * @return name
     */
   public String getName(){
       return name;
   }
    /**
     * to get address
     * @return address
     */
    public String getAddress(){
         return address;
    }
    /**
     * to get model
     * @return model
     */
    public String getModel(){
        return model;
    }
    /**
     * to get quantity
     * @return quantity
     */
    public int getQuantity(){
        return quantity;
    }
    /**
     * to get credit card
     * @return credit card
     */
    public String getCreditCard(){
        return creditCard;
    }
    /**
     * to get gross amount
     * @return gross amount
     */
    public Double getGrossAmount(){
        return grossAmount;
    }
    /**
     * to get vat
     * @return vat
     */
    public Double getVat(){
        return vat;
    }
    /**
     * to get total price
     * @return total price
     */
    public Double getTotalPrice(){
        return totalPrice;
    }
    /**
     * to set name
     * @param name to set name
     */
    public void setName(String name){
        this.name = name;
    }
    /**
     * to set address
     * @param address to set address
     */
    public void setAddress(String address){
        this.address = address;
    }
    /**
     * to set model
     * @param model to set model
     */
    public void setModel(String model){
        this.model = model;
    }
    /**
     * to set quantity
     * @param quantity to set quantity
     *
     */
    public void setQuantity(int quantity){
        this.quantity = quantity;
    }
    /**
     * to set credit card
     * @param creditCard to set credit card
     */
    public void setCreditCard(String creditCard){
        this.creditCard = creditCard;
    }
    /**
     * to set gross amount
     * @param value to set gross amount
     */
    public void setGrossAmount(Double value){
        this.grossAmount = value*this.quantity;
    }
    /**
     *to set vat
     */
    public void setVat(){
        this.vat = this.grossAmount*0.12;
    }
    /**
     * to set total price
     */
    public void setTotalPrice(){
        this.totalPrice = this.vat + this.grossAmount;
    }

    /**
     * to set string format to be readable
     * @return string format
     */
    public String toStringDetail(){
        return  "Order Verified. Successful Transaction"+"\n" +
                "Customer Name : " + getName() + "\n" +
                "Shipping Address : " + getAddress() + "\n" +
                "Item Ordered : " + getModel() + "\n" +
                "Quantity : " + getQuantity() + "\n" +
                "Gross Amount : " + getGrossAmount() + "\n" +
                "VAT (12%) : " + getVat() + "\n" +
                "Total Price : " + getTotalPrice() + "\n";
    }


}
