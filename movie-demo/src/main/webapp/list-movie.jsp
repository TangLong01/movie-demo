<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>List of Movies</title>
    <style>
        body {
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            height: 100vh;
            margin: 0;
            font-size: 20px;
            background: lightpink;
        }

        h1 {
            font-size: 60px;
        }

        table {
            border-collapse: collapse;
            width: 80%;
        }

        th, td {
            padding: 8px;
            border: 1px solid black;
        }

        button {
            font-size: 20px;
            background: darkgreen;
            color: white;
            border: 2px solid white;
            cursor: pointer;
            padding: 2px 8px;
            border-radius: 5px;
        }

        input {
            font-size: 20px;
            border: 2px solid black;
            padding: 2px 8px;
            border-radius: 5px;
        }

        div {
            display: flex;
            margin-bottom: 5px;
            font-size: 20px;
        }

        span {
            width: 40%;
            font-size: 20px;
            font-weight: bold;
        }

        input {
            width: 60%;
            font-size: 20px;
        }
    </style>
</head>

<body>
<h1>List of Movies</h1>
<form method="post">
    <input type="hidden" name="action" value="add"/>
    <div>
        <span>Title: </span>
        <input type="text" name="title"/><br/>
    </div>
    <div>
        <span>Genre: </span>
        <input type="text" name="genre"/><br/>
    </div>
    <div>
        <span>Year of Release: </span>
        <input type="text" name="year"/><br/>
    </div>
    <button type="submit" style="width: 30%; margin-left: 35%; margin-bottom: 10px">Add</button>
</form>
<table border="1">
    <thead>
    <tr>
        <th>ID</th>
        <th>Title</th>
        <th>Genre</th>
        <th>Year of Release</th>
        <th>Update</th>
        <th>Delete</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="movie" items="${movies}">
        <tr>
            <td>${movie.id}</td>
            <td>${movie.title}</td>
            <td>${movie.genre}</td>
            <td>${movie.yearOfRelease}</td>
            <td>
                <form method="post">
                    <input type="hidden" name="action" value="update"/>
                    <input type="hidden" name="movieIdUpdate" value="${movie.id}"/>
                    <input style="width: 50%" type="text" name="newTitle" placeholder="New title"/>
                    <button type="submit">Update movie</button>
                </form>
            </td>
            <td>
                <form method="post">
                    <input type="hidden" name="action" value="delete"/>
                    <input type="hidden" name="movieIdDelete" value="${movie.id}"/>
                    <button type="submit">Delete movie</button>
                </form>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>