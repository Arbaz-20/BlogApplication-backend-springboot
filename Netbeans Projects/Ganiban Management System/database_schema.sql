-- Ganiban Management System Database Schema
-- Veritabanı: maintainance

-- 1. Admin Tablosu
CREATE TABLE IF NOT EXISTS admin (
    login_ID VARCHAR(50) PRIMARY KEY,
    password VARCHAR(50) NOT NULL
);

-- 2. Users Tablosu
CREATE TABLE IF NOT EXISTS users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    Login_ID VARCHAR(50) NOT NULL,
    password VARCHAR(50) NOT NULL
);

-- 3. Customers Details Tablosu
CREATE TABLE IF NOT EXISTS customers_details (
    Flat_No VARCHAR(50) PRIMARY KEY,
    Floor_No VARCHAR(10) NOT NULL,
    Building_Wing VARCHAR(10) NOT NULL,
    Flat_Status VARCHAR(20) NOT NULL,
    Name_of_the_Owner VARCHAR(100) NOT NULL,
    Name_of_the_Renter VARCHAR(100),
    Mobile_Number VARCHAR(15)
);

-- 4. Billing Tablosu
CREATE TABLE IF NOT EXISTS billing (
    Reciept_no VARCHAR(20) PRIMARY KEY,
    Date VARCHAR(20) NOT NULL,
    Name VARCHAR(100) NOT NULL,
    Building_Wing VARCHAR(10) NOT NULL,
    Flat_No_or_Shop_No VARCHAR(50) NOT NULL,
    Rupees VARCHAR(20) NOT NULL,
    Only_Rupees_inwords VARCHAR(500),
    From_month VARCHAR(20),
    to_month VARCHAR(20),
    Maintainance_Charges VARCHAR(20),
    Total VARCHAR(20) NOT NULL
);

-- 5. Income Tablosu
CREATE TABLE IF NOT EXISTS income (
    ID VARCHAR(20) PRIMARY KEY,
    Date VARCHAR(20) NOT NULL,
    Sender VARCHAR(100) NOT NULL,
    Income_Mode VARCHAR(50) NOT NULL,
    Cheque_No VARCHAR(50),
    Bank_Transaction VARCHAR(50),
    Amount VARCHAR(20) NOT NULL,
    Discription TEXT NOT NULL
);

-- 6. Expenses Tablosu
CREATE TABLE IF NOT EXISTS expenses (
    ID VARCHAR(20) PRIMARY KEY,
    Date VARCHAR(20) NOT NULL,
    Reciever VARCHAR(100) NOT NULL,
    Expense_Mode VARCHAR(50) NOT NULL,
    Cheque_No VARCHAR(50),
    Bank_Transaction VARCHAR(50),
    Amount VARCHAR(20) NOT NULL,
    Discription TEXT NOT NULL
);

