-- Admin Page Queries
-- -- Create an admin
INSERT INTO USERS (USER_CLASS, USERNAME, FIRST_NAME, LAST_NAME, EMAIL, PASSWORD) VALUES ('a', 'melike', 'melike', 'gecer', 'melike.gecer@unil.ch', 1509442);
-- -- Remove an admin
DELETE FROM USERS WHERE USERNAME='melike';
-- -- Remove a buyer
DELETE FROM USERS WHERE USERNAME='marge';
-- -- Remove a seller
DELETE FROM USERS WHERE USERNAME='Barty''s';
-- -- Show users
SELECT * FROM USERS;
-- -- Show info
SELECT * FROM USERS WHERE USERNAME='lisa';
-- -- Show admins
SELECT * FROM USERS WHERE USER_CLASS='a';
-- -- Show buyers
SELECT * FROM USERS WHERE USER_CLASS='b';
-- -- Show sellers
SELECT * FROM USERS WHERE USER_CLASS='s';
-- -- Verify a shop
UPDATE USERS SET VERIFIED='t' WHERE USERNAME='Barty''s';
-- Buyer Page Queries
-- -- Deposit money
-- -- -- we learn the user's balance, then we increase it by the amount
-- -- -- we know her balance is 0.0 and she want to deposit 100 CHF
-- -- -- 0 + 100 = 100
SELECT BALANCE FROM USERS WHERE USERNAME='marge';
UPDATE USERS SET BALANCE=100 WHERE USERNAME='marge';
-- -- Remove drink from a shopping cart, first we should learn the IDs
SELECT USER_ID FROM USERS WHERE USERNAME='marge'; -- we know her ID=2
SELECT ITEM_ID FROM ITEMS WHERE ITEM_NAME='Water'; -- we know its ID=4
DELETE FROM USER_HAS_ITEM WHERE USER_ID=2 AND ITEM_ID=4;
-- -- Remove food, first we should learn the IDs
SELECT USER_ID FROM USERS WHERE USERNAME='marge'; -- we know her ID=2
SELECT ITEM_ID FROM ITEMS WHERE ITEM_NAME='Pasta'; -- we know its ID=1
DELETE FROM USER_HAS_ITEM WHERE USER_ID=2 AND ITEM_ID=1;
-- -- See a shop, we need to join all the tables
SELECT ITEMS.ITEM_CLASS, ITEMS.ITEM_NAME, ITEMS.ITEM_PRICE, ITEMS.HAS_MEAT_OR_ALCOHOL, ITEMS.INGREDIENTS
FROM USERS 
INNER JOIN USER_HAS_ITEM ON USERS.USER_ID=USER_HAS_ITEM.USER_ID
INNER JOIN ITEMS ON ITEMS.ITEM_ID=USER_HAS_ITEM.ITEM_ID
WHERE USERNAME='Barty''s';
-- -- Add an item to shopping cart, first we should learn the IDs
SELECT USER_ID FROM USERS WHERE USERNAME='marge'; -- we know her ID=2
SELECT ITEM_ID FROM ITEMS WHERE ITEM_NAME='Pizza'; -- we know its ID=2
INSERT INTO USER_HAS_ITEM (USER_ID, ITEM_ID) VALUES (2, 2);
-- -- See a shopping cart, we need to join all the tables
SELECT ITEMS.ITEM_CLASS, ITEMS.ITEM_NAME, ITEMS.ITEM_PRICE, ITEMS.HAS_MEAT_OR_ALCOHOL, ITEMS.INGREDIENTS
FROM USERS 
INNER JOIN USER_HAS_ITEM ON USERS.USER_ID=USER_HAS_ITEM.USER_ID
INNER JOIN ITEMS ON ITEMS.ITEM_ID=USER_HAS_ITEM.ITEM_ID
WHERE USERNAME='marge';
-- Main Page Queries
-- -- Create a buyer
INSERT INTO USERS (USER_CLASS, USERNAME, FIRST_NAME, LAST_NAME, EMAIL, PASSWORD, BALANCE) VALUES ('b', 'melike', 'melike', 'gecer', 'melike.gecer@unil.ch', 1509442, 0.0);
-- -- Create a seller
INSERT INTO USERS (USER_CLASS, USERNAME, FIRST_NAME, LAST_NAME, EMAIL, PASSWORD, VERIFIED) VALUES ('s', 'Chez-Alpha', 'alpha', 'diallo', 'alpha.diallo@unil.ch', 1509442, 'f');
-- Seller Page Queries
-- -- Add a drink, first we should add the item to ITEMS, then to USER_HAS_ITEM
INSERT INTO ITEMS (ITEM_CLASS, ITEM_NAME, ITEM_PRICE, HAS_MEAT_OR_ALCOHOL) VALUES ('d', 'Lemonade', 5.0, 'f');
INSERT INTO USER_HAS_ITEM (USER_ID, ITEM_ID) VALUES (2, 7); -- let's say its ID=7
-- -- Add a food, first we should add the item to ITEMS, then to USER_HAS_ITEM
INSERT INTO ITEMS (ITEM_CLASS, ITEM_NAME, ITEM_PRICE, HAS_MEAT_OR_ALCOHOL, INGREDIENTS) VALUES ('f', 'Eclair', 10.0, 'f', 'flour, butter, chocolate');
INSERT INTO USER_HAS_ITEM (USER_ID, ITEM_ID) VALUES (2, 8); -- let's say its ID=8
-- -- Remove a drink, we should remove from both USER_HAS_ITEM and ITEMS
SELECT ITEM_ID FROM ITEMS WHERE ITEM_NAME='Water'; -- we know its ID=4
DELETE FROM USER_HAS_ITEM WHERE ITEM_ID=4;
DELETE FROM ITEMS WHERE ITEM_ID=4;
-- -- Remove a food, we should remove from both USER_HAS_ITEM and ITEMS
SELECT ITEM_ID FROM ITEMS WHERE ITEM_NAME='Pasta'; -- we know its ID=1
DELETE FROM USER_HAS_ITEM WHERE ITEM_ID=1;
DELETE FROM ITEMS WHERE ITEM_ID=1;