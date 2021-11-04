package com.ebook.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.ebook.model.order.Order;

public class OrderDAO {

  public OrderDAO() {
  }

  public Order getOrder(String orderId) {
    try {

      Statement st = DBHelper.getConnection().createStatement();
      String selectQueryString = "SELECT orderID, orderState, payment_received FROM orders WHERE orderID = '" + orderId
          + "'";

      ResultSet orderRS = st.executeQuery(selectQueryString);
      System.out.println("OrderDAO: **************** Query " + selectQueryString);

      Order order = new Order();
      while (orderRS.next()) {
        order.setOrderId(orderRS.getString("orderID"));
        order.setOrderState(orderRS.getString("orderState"));
        order.setPaymentReceived(orderRS.getBoolean("payment_received"));
      }
      orderRS.close();

      return order;
    } catch (SQLException se) {
      System.err.println("OrderDAO: Threw a SQLException retreiving the order object.");
      System.err.println(se.getMessage());
      se.printStackTrace();
    }
    return null;
  }

  public void addOrder(Order order) {
    Connection con = DBHelper.getConnection();
    PreparedStatement orderPst = null;

    try {
      String orderStm = "INSERT INTO orders (orderID, orderState, payment_received) VALUES(?, ?, ?)";
      orderPst = con.prepareStatement(orderStm);
      orderPst.setString(1, order.getOrderId());
      orderPst.setString(2, order.getOrderState());
      orderPst.setBoolean(3, order.isPaymentReceived());
      orderPst.executeUpdate();
    } catch (SQLException ex) {

    } finally {

      try {
        if (con != null) {
          con.close();
        }
      } catch (SQLException se) {
        System.err.println("OrderDAO: threw a SQLException saving the order object");
        System.err.println(se.getMessage());
      }

    }
  }

  public void confirmOrder(Order order) {
    Connection con = DBHelper.getConnection();
    PreparedStatement orderPst = null;
    try {
      String orderStm = "UPDATE orders SET orderState = '" + order.getOrderState() + "' WHERE orderID = '"
          + order.getOrderId() + "'";
      orderPst = con.prepareStatement(orderStm);
      orderPst.executeUpdate();
    } catch (Exception se) {

    } finally {
      try {
        if (con != null) {
          con.close();
        }
      } catch (SQLException se) {
        System.err.println("OrderDAO: threw a SQLException updating the order object");
        System.err.println(se.getMessage());
      }
    }
  }

  public void cancelOrder(Order order) {
    Connection con = DBHelper.getConnection();
    PreparedStatement orderPst = null;
    try {
      String orderStm = "UPDATE orders SET orderState = '" + order.getOrderState() + "' WHERE orderID = '"
          + order.getOrderId() + "'";
      orderPst = con.prepareStatement(orderStm);
      orderPst.executeUpdate();
    } catch (Exception se) {

    } finally {
      try {
        if (con != null) {
          con.close();
        }
      } catch (SQLException se) {
        System.err.println("OrderDAO: threw a SQLException updating the order object");
        System.err.println(se.getMessage());
      }
    }
  }

  public void orderDelivered(Order order) {
    Connection con = DBHelper.getConnection();
    PreparedStatement orderPst = null;
    try {
      String orderStm = "UPDATE orders SET orderState = '" + order.getOrderState() + "' WHERE orderID = '"
          + order.getOrderId() + "'";
      orderPst = con.prepareStatement(orderStm);
      orderPst.executeUpdate();
    } catch (Exception se) {

    } finally {
      try {
        if (con != null) {
          con.close();
        }
      } catch (SQLException se) {
        System.err.println("OrderDAO: threw a SQLException updating the order object");
        System.err.println(se.getMessage());
      }
    }
  }

  public void orderPayed(Order order) {
    Connection con = DBHelper.getConnection();
    PreparedStatement orderPst = null;
    try {
      String orderStm = "UPDATE orders SET payment_received = 'yes' WHERE orderID = '" + order.getOrderId() + "'";
      orderPst = con.prepareStatement(orderStm);
      orderPst.executeUpdate();
    } catch (Exception se) {

    } finally {
      try {
        if (con != null) {
          con.close();
        }
      } catch (SQLException se) {
        System.err.println("OrderDAO: threw a SQLException updating the order object");
        System.err.println(se.getMessage());
      }
    }
  }


  public void orderSentOut(Order order) {
	  Connection con = DBHelper.getConnection();
	  PreparedStatement orderPst = null;
	  try {
	      String orderStm = "UPDATE orders SET orderState = '" + order.getOrderState() + "' WHERE orderID = '"
	          + order.getOrderId() + "'";
	      orderPst = con.prepareStatement(orderStm);
	      orderPst.executeUpdate();
	    } catch (Exception se) {

	    } finally {
	      try {
	        if (con != null) {
	          con.close();
	        }
	      } catch (SQLException se) {
	        System.err.println("OrderDAO: threw a SQLException updating the order object");
	        System.err.println(se.getMessage());
	      }
	    }
  }

  public void isFinished(Order order) {
	    Connection con = DBHelper.getConnection();
	    PreparedStatement orderPst = null;
	    try {
	      String orderStm = "UPDATE orders SET orderState = '" + order.getOrderState() + "' WHERE orderID = '"
	          + order.getOrderId() + "'";
	      orderPst = con.prepareStatement(orderStm);
	      orderPst.executeUpdate();
	    } catch (Exception se) {

	    } finally {
	      try {
	        if (con != null) {
	          con.close();
	        }
	      } catch (SQLException se) {
	        System.err.println("OrderDAO: threw a SQLException updating the order object");
	        System.err.println(se.getMessage());
	      }
	    }
	  }


  public String getOrderState(Order order){

    try{
      Statement con = DBHelper.getConnection().createStatement();
      String selectOrderQuery = "SELECT orderState FROM orders WHERE orderID = '" + order.getOrderId() + "'";
      ResultSet ordRS = con.executeQuery(selectOrderQuery);

      Order order2 = new Order();
      
      while(ordRS.next()) {
    	  order2.setOrderState(ordRS.getString("orderState"));    	  
      }
      
      ordRS.close();
      
      return order2.getOrderState();
    } catch (SQLException se){
      System.err.println("OrderDAO: Threw a SQLException returning order state.");
      System.err.println(se.getMessage());
      se.printStackTrace();
    }
    return null;

  }


}
