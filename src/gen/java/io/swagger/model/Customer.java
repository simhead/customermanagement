package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;





@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-11-24T13:02:24.894Z")
public class Customer   {
  
  private Long customerid = null;
  private String firstname = null;
  private String lastname = null;
  private String address = null;
  private Long debt = null;
  private Long salary = null;

  public Customer (int customerid, String firstname, String lastname, String address) {
	  this.customerid = new Long(customerid);
	  this.firstname = firstname;
	  this.lastname = lastname;
  }
  
  /**
   * Customer ID
   **/
  public Customer customerid(Long customerid) {
    this.customerid = customerid;
    return this;
  }

  
  @ApiModelProperty(required = true, value = "Customer ID")
  @JsonProperty("customerid")
  public Long getCustomerid() {
    return customerid;
  }
  public void setCustomerid(Long customerid) {
    this.customerid = customerid;
  }

  /**
   **/
  public Customer firstname(String firstname) {
    this.firstname = firstname;
    return this;
  }

  
  @ApiModelProperty(required = true, value = "")
  @JsonProperty("firstname")
  public String getFirstname() {
    return firstname;
  }
  public void setFirstname(String firstname) {
    this.firstname = firstname;
  }

  /**
   **/
  public Customer lastname(String lastname) {
    this.lastname = lastname;
    return this;
  }

  
  @ApiModelProperty(required = true, value = "")
  @JsonProperty("lastname")
  public String getLastname() {
    return lastname;
  }
  public void setLastname(String lastname) {
    this.lastname = lastname;
  }

  /**
   **/
  public Customer address(String address) {
    this.address = address;
    return this;
  }

  
  @ApiModelProperty(value = "")
  @JsonProperty("address")
  public String getAddress() {
    return address;
  }
  public void setAddress(String address) {
    this.address = address;
  }

  /**
   **/
  public Customer debt(Long debt) {
    this.debt = debt;
    return this;
  }

  
  @ApiModelProperty(required = true, value = "")
  @JsonProperty("debt")
  public Long getDebt() {
    return debt;
  }
  public void setDebt(Long debt) {
    this.debt = debt;
  }

  /**
   **/
  public Customer salary(Long salary) {
    this.salary = salary;
    return this;
  }

  
  @ApiModelProperty(value = "")
  @JsonProperty("salary")
  public Long getSalary() {
    return salary;
  }
  public void setSalary(Long salary) {
    this.salary = salary;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Customer customer = (Customer) o;
    return Objects.equals(customerid, customer.customerid) &&
        Objects.equals(firstname, customer.firstname) &&
        Objects.equals(lastname, customer.lastname) &&
        Objects.equals(address, customer.address) &&
        Objects.equals(debt, customer.debt) &&
        Objects.equals(salary, customer.salary);
  }

  @Override
  public int hashCode() {
    return Objects.hash(customerid, firstname, lastname, address, debt, salary);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    
    sb.append("\"customerid\":\"").append(toIndentedString(customerid)).append("\",");
    sb.append("\"firstname\":\"").append(toIndentedString(firstname)).append("\",");
    sb.append("\"lastname\":\"").append(toIndentedString(lastname)).append("\",");
    sb.append("\"address\":\"").append(toIndentedString(address)).append("\"");
    sb.append("}");
    return sb.toString();
  }


  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

