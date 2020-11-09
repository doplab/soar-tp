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
-- -- Show sellers
-- -- Verify a shop
UPDATE USERS SET VERIFIED='t' WHERE USERNAME='Barty''s';
-- Buyer Page Queries
-- -- Deposit money
-- -- Remove drink
-- -- Remove food
-- -- See a shop
SELECT ITEMS.ITEM_CLASS, ITEMS.ITEM_NAME, ITEMS.ITEM_PRICE, ITEMS.HAS_MEAT_OR_ALCOHOL, ITEMS.INGREDIENTS
FROM USERS 
INNER JOIN USER_HAS_ITEM ON USERS.USER_ID=USER_HAS_ITEM.USER_ID
INNER JOIN ITEMS ON ITEMS.ITEM_ID=USER_HAS_ITEM.ITEM_ID
WHERE USERNAME='Barty''s';
-- -- Add an item to shopping cart
SELECT USER_ID FROM USERS WHERE USERNAME='marge'; -- we know her ID=2
SELECT ITEM_ID FROM ITEMS WHERE ITEM_NAME='Pizza'; -- we know its ID=2
INSERT INTO USER_HAS_ITEM (USER_ID, ITEM_ID) VALUES (2, 2);
-- -- See a shopping cart
-- Main Page Queries
-- -- Create a buyer
-- -- Create a seller
-- Seller Page Queries
-- -- Add a drink
-- -- Add a food
-- -- Remove a drink
-- -- Remove a food