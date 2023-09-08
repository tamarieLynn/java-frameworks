Part C 
Customize the HTML user interface. Changes were made to the given mainscreen.html page.  I Changed the title on line 14. The Name of the shop was added to line 19, then I added parts to the table under the part title at line 52 - 58.  I added products to the product table at line 62 from line 87 to 89. 

Part D 
I created the new about.html page and linked it to the mainscreen.html and put a link on the mainscreen.html page to navigate to the about us page. 

Part E Added 5 products in BootStrapDate from line 92 - 96, save those products from line 97-101
Created 5 new OutsourcedPart objects from line 43 - 68. Saved those from line 70-74. I used the given code that was commented out to have those new parts and products put onto the webpage.

Part F Add a “Buy Now” button to your product list.

•   The “Buy Now” button must be next to the buttons that update and delete products.
Lines 103 - 110 in mainscreen.html

•   The button should decrement the inventory of that product by one. It should not affect the inventory of any of the associated parts.

•   Display a message that indicates the success or failure of a purchase.
Functions as the previous bullet point suggest.

Part G. Modify the parts to track maximum and minimum inventory 

•   Add additional fields to the part entity for maximum and minimum inventory.
Lines 31-34 in Parts.java
•   Modify the sample inventory to include the maximum and minimum fields.
Lines 38-73 in BootStrapData included the added fields.
•   Add to the InhousePartForm and OutsourcedPartForm forms additional text inputs for the inventory so the user can set the maximum and minimum values.
Lines 25 and 26 in InhousePartForm.html, Lines 25 and 26 in OutsourcedPartForm.html
•   Rename the file the persistent storage is saved to.
Done.
•   Modify the code to enforce that the inventory is between or at the minimum and maximum value.
Added method isInventoryInRange() to the Parts.java file. Lines 119-122. 
