CREATE  TABLE `firstdb`.`companydetails` (
  `companyname` VARCHAR(200) NOT NULL ,
  `tin` VARCHAR(45) NOT NULL ,
  `pan` VARCHAR(45) NOT NULL ,
  `gst` VARCHAR(45) NOT NULL ,
  `cst` VARCHAR(45) NOT NULL ,
  `address` VARCHAR(345) NOT NULL ,
  `phone` VARCHAR(45) NOT NULL ,
  `logo` BLOB NOT NULL ,
  `email` VARCHAR(45) NOT NULL  );
  
  
  CREATE  TABLE `firstdb`.`productdetails` (
  `productno` VARCHAR(45) NOT NULL ,
  `productname` VARCHAR(450) NOT NULL ,
  `productdesc` VARCHAR(450) NOT NULL ,
  `rate` DOUBLE NOT NULL DEFAULT 0 ,
  `companyname` VARCHAR(45) NULL);

	
	CREATE  TABLE `firstdb`.`clientdetails` (
  `clientname` VARCHAR(45) NOT NULL ,
  `gst` VARCHAR(45) NOT NULL ,
  `cst` VARCHAR(45) NOT NULL ,
  `pan` VARCHAR(45) NOT NULL ,
  `address` VARCHAR(345) NOT NULL ,
  `contact` VARCHAR(45) NOT NULL ,
  `tin` VARCHAR(45) NOT NULL ,
  `companyname` VARCHAR(45) NOT NULL ,
  `outstandingamount` DOUBLE NOT NULL DEFAULT 0 ,
  `amountpaid` DOUBLE NOT NULL DEFAULT 0 );
  
  CREATE  TABLE `firstdb`.`unitdetails` (
  `unit` VARCHAR(45) NOT NULL ,
  `unitname` VARCHAR(45) NOT NULL );
  
  insert into firstdb.unitdetails values(1,'KG');
  insert into firstdb.unitdetails values(2,'GRAM');
  insert into firstdb.unitdetails values(3,'TEST');
  
  CREATE  TABLE `firstdb`.`billno` (
  `no` INT NOT NULL AUTO_INCREMENT ,
  `companyname` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`no`) );

CREATE  TABLE `firstdb`.`billdetails` (
  `sno` INT NOT NULL ,
  `prodDesc` VARCHAR(45) NOT NULL ,
  `qty` INT NOT NULL ,
  `rate` DOUBLE NOT NULL ,
  `amount` DOUBLE NOT NULL ,
  `vat` DOUBLE NOT NULL ,
  `addTax` DOUBLE NOT NULL ,
  `billNo` VARCHAR(45) NOT NULL,
  `unit` varchar(45) not null
  );
  
  ALTER TABLE `firstdb`.`billdetails` ADD COLUMN `companyname` VARCHAR(45) NOT NULL  AFTER `unit` , ADD COLUMN `clientname` VARCHAR(45) NOT NULL  AFTER `companyname`;


  
  
