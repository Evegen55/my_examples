package HKUST;

import comp102x.IO;

/**
 * This program demonstrate simple arithematics values represented by barcodes
 */
public class BarcodeDemo
{
   public static void main(String[] args) {
   
       // Declare and initialize two long variables
       long value1 = IO.inputBarcode(); // Read a barcode from an existing file
       long value2 = IO.inputBarcode(); // Read another barcode from an existing file
       
       // Output the values represented by the two barcodes
       IO.outputln("The value of the 1st barcode is: " + value1);
       IO.outputln("The value of the 2nd barcode is: " + value2);
       
       // Add and multiply two barcodes
       long addResult = value1 + value2;
       long mulResult = value1 * value2;
  
       // Output the calculation results
       IO.outputln("The result of adding the two barcodes values is: " + addResult);
       IO.outputln("The result of multiplying the two barcodes values is: " + mulResult);
       
       // Output the calculation results as images on the file system
       IO.outputBarcode(addResult);
   }
}
