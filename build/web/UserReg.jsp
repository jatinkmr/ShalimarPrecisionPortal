<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Registration</title>
        <link rel="stylesheet" type="text/css" href="regis.css">         
    </head>
    <body bgcolor="#9df66e">
        <div class="header1">
            <center><h2>Shalimar Precision Online Enterprise Online Solution</h2></center>
        </div>         
        <div style="background-color:#00cc66;clear:both;text-align:center">
            <marquee><b><font color="#12335b">Announcements   >> New Products Has Been
                    Added to Our Portal Regularly.Please Be Updated........</font></b></marquee>
        </div>
        <div class="subhd">
            <center><h2>User Registration Management Portal</h2></center>
        </div>         
        <div id="images">
            <img src="images/usrReg.jpg" height="400px" width="450px" border="3">
        </div>
        <div class="dtls">
            <center>               
                <form action="ureg" name="myfrm">                    
                    <font size="4px" face="Lucida Calligraphy" color="#894d10">User ID</font> <input type="text" name="uid" placeholder="Enter User ID" required/><br/><br/>                    
                    <font size="4px" face="Lucida Calligraphy" color="#894d10">User Type</font> 
                    <select name="usrtyp">
                        <option value="customer" selected>Customer</option>
                        <option value="employee">Employee</option>
                        <option value="administrator">Administrator</option>
                        <option value="manager">Manager</option>
                        <option value="supplier">Supplier</option>                        
                    </select>
                    <br/><br/>                    
                    <font size="4px" face="Lucida Calligraphy" color="#894d10">User Name</font> <input type="text" name="unm" placeholder="Enter User Name" required/><br/><br/>                    
                    <font size="4px" face="Lucida Calligraphy" color="#894d10">Password</font> <input type="password" name="upsswd1" placeholder="Enter password" required/><br/><br/>                    
                    <font size="4px" face="Lucida Calligraphy" color="#894d10">Re-Enter Password</font> <input type="password" name="upsswd2" placeholder="Enter password" required/><br/><br/>                    
                    <font size="4px" face="Lucida Calligraphy" color="#894d10">Security Question</font>
                    <select name="secques">                        
                        <option value="What was your Childhood nickname ?">What was your Childhood nickname ?</option>
                        <option value="What is the middle name of your youngest child ?">What is the middle name of your youngest child ?</option>
                        <option value="What is your oldest sibling's middle name ?">What is your oldest sibling's middle name ?</option>
                        <option value="What was your childhood phone number including area code ?">What was your childhood phone number including area code ?</option>
                        <option value="In what city or town was your first job ?">In what city or town was your first job ?</option>
                        <option value="What was your favourite place to visit as a Child ?">What was your favourite place to visit as a Child ?</option>
                    </select>
                    <br/><br/>                    
                    <font size="4px" face="Lucida Calligraphy" color="#894d10">Security Answer</font> <input type="text" name="sans" placeholder="Enter Your Answer" required/><br/><br/>                    
                    <font size="4px" face="Lucida Calligraphy" color="#894d10">User Contact</font> <input type="text" name="ucon" placeholder="Enter User Contact No" required/><br/><br/>                                        
                    <input type="submit" name="sgn" value="Create">
                    <input type="reset" name="rst" value="Clear">
                    <a href="login.jsp"><input type="button" value="Already Have An Account"></a>                    
                    <center><h3><%=request.getAttribute("errmsg") %></h3></center>
                </form>
            </center>
        </div>                                                
        <div class="foot">                    
            <h2>This Project Has Been Developed By Mr. Jatin Kumar "Kamboj" and Copyright © 2011 <a href="#">Shalimar Precision EnterPrise Online Solution</a></h2>
        </div>                        
    </body>
</html>
