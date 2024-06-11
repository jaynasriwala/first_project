<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1>Student Box Cricket</h1>


<form action="savestudent" method = "post">

Name: <input type="text" name="studentName" value="${StudentName}">

<span style="color:red">${nameError}</span>
<br><br>
Playing Type : 
				Batman <input type="radio" name="playerType" value="Batsman" ${playertypevalue!=null && playertypevalue.equals("Batsman") ? "checked" : ""}/>
				Bowller <input type="radio" name="playerType" value="Bowller" ${playertypevalue!=null && playertypevalue.equals("Bowller") ? "checked" : "" }>
	
				allRounder <input type="radio" name="playerType" value="allRounder" ${playertypevalue!=null && playertypevalue.equals("allRounder") ? "checked" : "" }>
		<span style="color:red">${playertype}</span> 		
<br><br>
Food Preference : 
				
				<select name="FoodPreference">
				<option value="-1">--select food--</option>
				<option value="reguler" ${foovalue!=null && foodvalue.equals("reguler") ? "selected" : "" } >reguler</option>
  				<option value="jain" ${foovalue!=null && foodvalue.equals("jain") ? "selected" : "" }>jain</option>
				
				</select>	
				
				<span style="color:red">${food}</span>			
<br><br>
Drink : 
		RB <input type="checkbox" name="drink" value= "RB" ${drinkvalue.contains("RB") ? "checked" : "" }>
		MD <input type="checkbox" name="drink" value= "MD" ${drinkvalue.contains("MD") ? "checked" : "" }>
		LJ <input type="checkbox" name="drink" value= "LJ" ${drinkvalue.contains("LJ") ? "checked" : "" }>
		CO <input type="checkbox" name="drink" value= "CO" ${drinkvalue.contains("CO") ? "checked" : "" }>
		
		<span style="color:red">${drink}</span>
<br><br>		
<input type="Submit" value="Reg">
</form>
</body>
</html>