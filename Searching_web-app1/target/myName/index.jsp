<html>
<link rel="stylesheet" href="CSS/style.css">
<script src="js/jquery-2.2.3.min.js"></script>
<script type="text/javascript" src="js/search.js" charset="UTF-8"></script>
<body>
<h2>Hello World from Perepelova</h2>
<form method="post" action="${pageContext.request.contextPath}/searching">
    <input type="text" name="search_words" >
    <input type="submit" name="ok">
</form>
<div class = "searcher">
    <input class="searcherText" type="text" id="searchText">
    <label for="searchText">Search text</label>
    <button value="Search" id="search"><span>Search</span></button>
</div>
<div class="result">
    <textarea id="result" placeholder="Nothing to search=("></textarea>
</div>
</body>
</html>
