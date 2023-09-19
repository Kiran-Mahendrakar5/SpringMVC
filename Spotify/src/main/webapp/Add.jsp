<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="send" method="post">
<input type="text" name="songName" placeholder="EntersongName">
<h2>${songName}</h2>
<input type="text" name="artist" placeholder="Enterartist">
<h2>${artist}</h2>
<input type="number" name="rating" placeholder="Enterrating">
<h2>${rating}</h2>
<input type="text" name="album" placeholder="Enteralbum">
<h2>${album}</h2>
<button type="submit">ADDSONG</button>






</form>
</body>
</html>