** Quantum Bookstore **
* You Can
  - Add Books To invnetory (PaperBook ,EBook ,DemoBook)
  - remove outdated books
  - buy single book
  
model Folder contains :
  -Book
  -DemoBook extends Book implements IDemoBook
  -EBook extends Book implements IEBook
  -PaperBook extends Book implements IPaperBook

Screenshot for main :
  -create books
  -add books by BookStoreService to invnetory
  -Buy book by BookStoreService
![image](https://github.com/user-attachments/assets/67df01a4-5565-4115-8ecb-c848d0bcb7a2)

Screenshot for output 1 
  -first for book paperBook (Shippable)
  -second for EBook (online)
  -third for DemoBook And he can't buy it
  ![image](https://github.com/user-attachments/assets/e5798260-788a-458b-a604-343b5fda0adb)

Screenshot for main 2:
  --add remove function to remove all books before 5 years
  ![image](https://github.com/user-attachments/assets/71dd9cbf-35ab-4b2a-afae-b2c9d7e5ca32)

Screenshot for output 2
--remove 2 books from 3 
--show the total price for 3rd book 
  ![image](https://github.com/user-attachments/assets/8dec0a34-a166-4d7b-bc1e-68f2ed2e1446)




