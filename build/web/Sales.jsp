<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sales Management Portal</title>
        <link rel="stylesheet" type="text/css" href="remstyls.css">                        
    </head>
    <body bgcolor="#1697d0">
        <div class="navbar">
            <ul>
                <li><a href="Welcome.jsp">Home</a></li>
                <li><a href="Enquiry.jsp">Enquiry</></li>
                <li><a href="Customer.jsp">Customer</a></li>
                <li><a href="Employee.jsp">Employee</a></li>
                <li><a href="#">Transactions</a>
                    <ul>
                        <li><a href="Inventory.jsp">Inventory</a></li>
                        <li><a href="Sales.jsp">Sales</a></li>
                        <li><a href="Promotion.jsp">Promotion</a></li>
                        <li><a href="Payment.jsp">Payment</a></li>
                    </ul>
                </li>     
                <li><a href="about.jsp">About Us</a></li>
                <li><a href="login.jsp">LogOut</a></li>	
            </ul>
        </div>            
        <div class="header">
            <center><h2>Shalimar Precision Online Enterprise Online Solution</h2></center>
        </div>         
        <div style="background-color:#00cc66;clear:both;text-align:center">
            <marquee><b><font color="#12335b">Announcements   >> New Products Has Been
                    Added to Our Portal Regularly.Please Be Updated........</font></b></marquee>
        </div><br/>
        <div class="subhd">
            <center><h2>Sales Management Portal</h2></center>
        </div>         
        <div id="images">
            <img src="images/saless.jpg" height="400px" width="550px" border="3">
        </div>
        <div class="dtls">
            <center>               
                <form action="saless" name="myfrm">
                    <font size="4px" face="Lucida Calligraphy" color="#894d10">Sale ID</font> <input type="text" name="sid" placeholder="Enter Sales ID"/><br/><br/>
                    <font size="4px" face="Lucida Calligraphy" color="#894d10">Product ID</font> <input type="text" name="pid" placeholder="Enter Product ID" /><br/><br/>
                    <font size="4px" face="Lucida Calligraphy" color="#894d10">Product Quantity</font> <input type="text" name="pqty" placeholder="Enter Product Quantity" /><br/><br/>
                    <font size="4px" face="Lucida Calligraphy" color="#894d10">Product Price</font> <input type="text" name="pprc" placeholder="Enter Product Price" /><br/><br/>                    
                    <input type="submit" name="salsb" value="Insert">
                    <input type="submit" name="salsb" value="Update">
                    <input type="submit" name="salsb" value="Delete">
                    <input type="submit" name="salsb" value="Search">
                    <input type="reset" value="Clear">
                    <center><h3><%=request.getAttribute("errmsg") %></h3></center>
                </form>
            </center>
        </div>                                        
        <div class="foot">                    
            <h2>This Project Has Been Developed By Mr. Jatin Kumar "Kamboj" and Copyright © 2011 <a href="#">Shalimar Precision EnterPrise Online Solution</a></h2>
        </div>                
    </body>
</html>
