<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inventory Management Portal</title>
        <link rel="stylesheet" type="text/css" href="remstyls.css">        
    </head>
    <body bgcolor="#00ffff">
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
            <center><h2>Inventory Management Portal</h2></center>
        </div>
        <div id="imagesR">
            <img src="images/invntry.jpg" height="400px" width="550px" border="3">
        </div>
        <div class="dtls">
            <center>               
                <form action="invntry" name="myfrm">
                    <font size="4px" face="Lucida Calligraphy" color="#894d10">Inventory ID</font> <input type="text" name="iid" placeholder="Enter Inventory ID" value='<%=request.getAttribute("invid")%>'/><br/><br/>
                    <font size="4px" face="Lucida Calligraphy" color="#894d10">Product ID</font> <input type="text" name="pid" placeholder="Enter Product ID" value='<%=request.getAttribute("prid")%>'/><br/><br/>
                    <font size="4px" face="Lucida Calligraphy" color="#894d10">Unit Price</font> <input type="text" name="upr" placeholder="Enter Unit Price" value='<%=request.getAttribute("unprc")%>'/><br/><br/>
                    <font size="4px" face="Lucida Calligraphy" color="#894d10">Product Quantity</font> <input type="text" name="prqn" placeholder="Enter Product Quantity" value='<%=request.getAttribute("prqty")%>'/><br/><br/>
                    <font size="4px" face="Lucida Calligraphy" color="#894d10">Product Grade</font> <input type="text" name="igr" placeholder="Enter Product Grade" value='<%=request.getAttribute("prgrd")%>'/><br/><br/>     
                    <input type="submit" name="invsb" value="Insert">
                    <input type="submit" name="invsb" value="Update">
                    <input type="submit" name="invsb" value="Delete">
                    <input type="submit" name="invsb" value="Search">
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
