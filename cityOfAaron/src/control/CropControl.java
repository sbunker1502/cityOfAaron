package control;


import java.util.Random;
import model.*;

public class CropControl {
   private int landPrice;
   //constants
   private static final int LAND_BASE = 17;
   private static final int LAND_RANGE = 10;

   //random number generator
   private static Random random = new Random();

   //calcLandCost() method
   //Purpose: Calculate a random land cost between 17 and 26 bushels/acre
   //Parameters: none
   //Returns: the land cost
   public static int calcLandCost() {
       int landPrice = random.nextInt(LAND_RANGE) + LAND_BASE;
       return landPrice;
   }

   // The sellLand method
   // Purpose: To sell land
   // Parameters: the price of land, the number of acres to sell, and
   // a reference to a CropData object 
   // Returns: the acres owned after the sale
   // Pre-conditions: acres to sell must be positive
   // and <= acresOwned
   public static int sellLand(int landPrice, int acresToSell, CropData cropData) {

      //if acresToSell < 0, return -1
      if(acresToSell < 0){
         return -1;
      }
      
      //if acresToSell > acresOwned, return -1
      int owned = cropData.getAcresOwned();
      if(acresToSell > owned){
         return -1;
      }
      //acresOwned = acresOwned - acresToSell
      owned -= acresToSell ;
      cropData.setAcresOwned(owned);
      
      //wheatInStore = wheatInStore + acresToSell * landPrice
      int wheat = cropData.getWheatInStore();
      wheat += (acresToSell * landPrice) ;
      cropData.setWheatInStore(wheat);
      
      //return acresOwned
      return owned ;
   }
   
   
   
   // The buyLand method
   // Purpose: To buy land
   // Parameters: the price of land, the number of acres to buy, a
   // a reference to a CropData object, and the number of wheat bushels in store. 
   // Returns: the acres owned after the purchase
   // Pre-conditions: acres to buy must be >= 0,
   // and landPrice * acresToBuy must be <= wheatInStore
   public static int buyLand(int landPrice, int acresToBuy, int wheatInStore, CropData cropData) {
      
      //if acresToBuy < 0, return -1
      if(acresToBuy < 0){
         return -1;
      }
      
      //set totalPrice to landPrice*acresToBuy
      int totalPrice = landPrice * acresToBuy;
      
      //if totalPrice > wheatInStore, return -2
      if(totalPrice > wheatInStore){
         return -2;
      }
      
      //set owned to cropData.getAcresOwned()
      int acresOwned = cropData.getAcresOwned();
      
      //add acresToBuy to owned
      acresOwned += acresToBuy;
      //add totalPrice to wheatInStore
      wheatInStore -= totalPrice;
      
      //set this.acresOwned to owned
      cropData.setAcresOwned(acresOwned);
      //set this.wheatInStore to wheatInStore
      cropData.setWheatInStore(wheatInStore);
      
      
      //return owned
      return acresOwned;
   }     

   // feed people by tyler
   
   //Pseudo-code for public int feedPeople(wheatInStore, wheatForPeople, poplation) 
    public static int feedPeople(int wheatForPeople, CropData cropData){
        try {
        int wheatInStore = cropData.getWheatInStore(); 
   //if wheatForPeople < 0, return -1     
        if (wheatForPeople < 0) {
            throw new CropException("Negative Output.");
        }
        
   //if wheatInStore < wheatForPeople return -1     
        if (wheatInStore < wheatForPeople) {
        }
   //wheatInStore = wheatInStore - wheatForPeople     
         if (wheatForPeople < wheatInStore) {
            wheatInStore -= wheatForPeople; 
            cropData.setWheatInStore(wheatInStore);
   // wheat for people
            cropData.setWheatForPeople(wheatForPeople);
            return cropData.getWheatInStore();
        }
        
        }
   //return wheatInStore
        catch (CropException  e) {
        
        }
        return 0;
    }

    private static class CropException extends Exception {

        public CropException(String a_negative_value_was_input) {
        }
    }
    }