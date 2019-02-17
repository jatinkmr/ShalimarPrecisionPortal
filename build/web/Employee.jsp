<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Employee Management Portal</title>
        <link rel="stylesheet" type="text/css" href="remstyls.css">                
    </head>
    <body bgcolor="#66d368">
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
            <center><h2>Employee Management Portal</h2></center>
        </div>         
        <div id="images">
            <img src="images/employee.jpg" height="400px" width="550px" border="3">
        </div>
        <div class="dtls">
            <center>               
<form action="empm" name="myfrm">
                    <font size="4px" face="Lucida Calligraphy" color="#894d10">Employee ID</font> <input type="text" name="eid" placeholder="Enter Employee ID" value='<%=request.getAttribute("empid")%>'/><br/><br/>
                    <font size="4px" face="Lucida Calligraphy" color="#894d10">Employee Name</font> <input type="text" name="enm" placeholder="Enter Employee Name" value='<%=request.getAttribute("empnm")%>'/><br/><br/>
                    <font size="4px" face="Lucida Calligraphy" color="#894d10">Employee Contact</font> <input type="text" name="ecn" placeholder="Enter Customer Contact" value='<%=request.getAttribute("empcon")%>'/><br/><br/>
                    <font size="4px" face="Lucida Calligraphy" color="#894d10">Employee Address</font> <input type="text" name="edd" placeholder="Enter Your Address Here" value='<%=request.getAttribute("empadd")%>'/><br/><br/>
                    <font size="4px" face="Lucida Calligraphy" color="#894d10">Employee Email</font> <input type="text" name="eeml" placeholder="Enter Customer Email" value='<%=request.getAttribute("empeml")%>'/><br/><br/>
                    <font size="4px" face="Lucida Calligraphy" color="#894d10">Employee City</font> <input type="text" name="ety" placeholder="Enter Customer City" value='<%=request.getAttribute("empcty")%>'/><br/><br/>
                    <font size="4px" face="Lucida Calligraphy" color="#894d10">Employee State</font> <input type="text" name="est" placeholder="Enter Customer State" value='<%=request.getAttribute("empst")%>'/><br/><br/>
                    <font size="4px" face="Lucida Calligraphy" color="#894d10">Employee Gender</font> <input type="text" name="gend" placeholder="Enter Gender(Mal/Fem)" value='<%=request.getAttribute("empgend")%>'  /><br/><br/>
                    <input type="submit" name="empsb" value="Insert">
                    <input type="submit" name="empsb" value="Update">
                    <input type="submit" name="empsb" value="Delete">
                    <input type="submit" name="empsb" value="Search">
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
