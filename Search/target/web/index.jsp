<html><!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Perepelova</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />
</head>
<body>
<a></a><p></p>
<div class="form-inline" style="text-align: center;">
    <form action="/searcher" method="post">
        <div class="form-group">
            <input id="search" name="search" type="text" class="form-control" style="width: 600px;" />
        </div>
        <button type="submit" class="btn btn-default">Search</button>
    </form>
</div>
<p><%=session.getAttribute("result")%></p>
</body>
</html>