package io.db;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the CUSTOMERS database table.
 * 
 */
@Entity
@Table(name="CUSTOMERS")
@NamedQueries({
    @NamedQuery(name="Customer.findAll",
                query="SELECT c FROM DBCustomer c"),
    @NamedQuery(name="Customer.count",
                query="SELECT count(c) FROM DBCustomer c"),
}) 
public class DBCustomer implements Serializable {
   private static final long serialVersionUID = 1L;
   private int customerid;
   private String firstname;
   private String lastname;
   private String address;
   
   public DBCustomer() {
   }


   @Id
   @GeneratedValue(strategy=GenerationType.IDENTITY)
   @Column(updatable=false)
   public int getCustomerid() {
      return this.customerid;
   }

   public void setCustomerid(int customerid) {
      this.customerid = customerid;
   }


   public String getFirstname() {
      return this.firstname;
   }

   public void setFirstname(String firstname) {
      this.firstname = firstname;
   }

   public String getLastname() {
	      return this.lastname;
	   }

	   public void setLastname(String lastname) {
	      this.lastname = lastname;
	   }

   public String getAddress() {
      return this.address;
   }

   public void setAddress(String address) {
      this.address = address;
   }

}